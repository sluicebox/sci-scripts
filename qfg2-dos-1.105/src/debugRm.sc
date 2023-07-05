;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use Interface)
(use n940)
(use PolyEdit)
(use WriteFeature)
(use Game)
(use User)
(use Actor)
(use System)

(public
	debugRm 0
)

(procedure (GetBucks &tmp [sCurDinars 10] [sCurGold 10] [sCurComm 10] [sDinars 5] [sGold 5] [sComm 5])
	(Format @sCurDinars 99 5 [gInvNum 2]) ; "(%d)", Dinar
	(Format @sCurGold 99 5 [gInvNum 17]) ; "(%d)", Gold
	(Format @sCurComm 99 5 [gEgoStats 13]) ; "(%d)", communication
	(= sDinars (= sGold (= sComm 0)))
	(if
		(PrintD
			80
			{Get Bucks}
			{Dinars}
			41
			@sDinars
			5
			@sCurDinars
			101
			{Gold}
			41
			@sGold
			5
			4
			14
			@sCurGold
			101
			{Comm}
			41
			@sComm
			5
			4
			2
			@sCurComm
		)
		(= [gInvNum 2] (ReadNumber @sDinars)) ; Dinar
		(= [gInvNum 17] (ReadNumber @sGold)) ; Gold
		(= [gEgoStats 13] (ReadNumber @sComm)) ; communication
		(= [gInvNum 1] 0) ; Centime
	)
)

(instance debugRm of Locale
	(properties)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event &tmp evt obj [unused 2] i nr whichSkill skillValue nullStr [str80 40] [theNumber 5] [theQty 5])
		(if (or (not gDebugging) (event claimed:))
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((& (event modifiers:) emCTRL)
						(event claimed: 1)
						(DontMove 0)
						(while (!= evMOUSERELEASE ((= evt (Event new:)) type:))
							(GlobalToLocal evt)
							(gEgo posn: (evt x:) (evt y:) setMotion: 0)
							(Animate (gCast elements:) 0)
							(evt dispose:)
						)
						(evt dispose:)
					)
					((& (event modifiers:) emSHIFT)
						(= obj
							(Print
								(Format @str80 99 0 (event x:) (event y:)) ; "%d/%d"
								#at
								150
								100
								#font
								999
								#dispose
							)
						)
						(while (!= evMOUSERELEASE ((= evt (Event new:)) type:))
							(evt dispose:)
						)
						(obj dispose:)
						(evt dispose:)
					)
				)
			)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_QUESTION
						(Print 99 1) ; "ALT-U Show updating views ALT-S Show cast ALT-F Show Memory ALT-T Teleport ALT-V Visual ALT-P Priority ALT-C Control ALT-H Heavy-Duty Ego ALT-I Get InvItem ALT-B Set Ego's Bucks ALT-K Set one of Ego's sKills ALT-L Logfile ALT-W Write Features Ctrl-W Write Cast for Tester"
					)
					(KEY_ALT_u
						(gCast eachElementDo: #perform showUpdaters)
					)
					(KEY_ALT_s
						(= nullStr {*})
						(StrAt nullStr 0 0)
						(for
							((= i (gCast first:)))
							i
							((= i (gCast next: i)))
							
							(= obj (NodeValue i))
							(Print
								(Format ; "view: %d x:%d y:%d %s %s illB=$%x"
									@str80
									99
									2
									(obj view:)
									(obj x:)
									(obj y:)
									(if (& (obj signal:) $0004)
										{stopUpd:\n}
									else
										nullStr
									)
									(if (& (obj signal:) $4000)
										{ignoreActors:\n}
									else
										nullStr
									)
									(if
										(or
											(== (obj superClass:) Actor)
											(== (obj superClass:) Ego)
										)
										(obj illegalBits:)
									else
										-1
									)
								)
								#title
								(obj name:)
								#icon
								(obj view:)
								(obj loop:)
								(obj cel:)
							)
						)
					)
					(KEY_ALT_e
						(Print
							(Format ; "x:%d y:%d loop:%d cel:%d priority:%d"
								@str80
								99
								3
								(gEgo x:)
								(gEgo y:)
								(gEgo loop:)
								(gEgo cel:)
								(gEgo priority:)
							)
							#title
							{Ego}
							#icon
							(gEgo view:)
							(gEgo loop:)
							(gEgo cel:)
						)
					)
					(KEY_ALT_i
						(= theNumber 0)
						(StrCpy @theQty {1})
						(if
							(PrintD
								80
								{Get Inventory Item}
								{Inventory ID}
								41
								@theNumber
								5
								{Quantity}
								41
								@theQty
								5
							)
							(= i (ReadNumber @theNumber))
							(= nr (ReadNumber @theQty))
							(gEgo get: i nr)
						)
					)
					(KEY_ALT_t
						(if (= nr (GotoPlaceAndTime))
							(= gCurRoomNum 0)
							(gCurRoom newRoom: nr)
						)
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_p
						(Show 2)
					)
					(KEY_ALT_c
						(Show 4)
					)
					(KEY_ALT_f
						(gGame showMem:)
					)
					(KEY_ALT_b
						(GetBucks)
					)
					(KEY_ALT_k
						(= whichSkill (GetNumber {Change which Stat/Skill?}))
						(= [gEgoStats whichSkill]
							(GetNumber {Enter new value:} [gEgoStats whichSkill])
						)
					)
					(KEY_ALT_h
						(= skillValue (GetNumber {What should each skill be?} 150))
						(for ((= whichSkill 0)) (< whichSkill 30) ((++ whichSkill))
							(= [gEgoStats whichSkill] skillValue)
						)
						(= [gEgoStats 15] 3500) ; experience
						(= [gEgoStats 16] (MaxHealth)) ; health
						(= [gEgoStats 17] (MaxStamina)) ; stamina
						(= [gEgoStats 18] (MaxMana)) ; mana
						(Print 99 4) ; "Why, you feel better already!"
					)
					(KEY_ALT_z
						(= gQuit 1)
					)
					(KEY_ALT_x
						(= gQuit 1)
					)
					(KEY_ALT_w
						(CreateObject doit:)
					)
					(KEY_ALT_g
						(MakePath doit:)
					)
					($0017
						((ScriptID 92 0) init:) ; writeCast
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance showUpdaters of Code
	(properties)

	(method (doit aObj &tmp [str 100])
		(if (& (aObj signal:) $0003)
			(Print
				(Format @str 99 6 (aObj signal:)) ; "signal $%04x"
				#icon
				(aObj view:)
				(aObj loop:)
				(aObj cel:)
				#title
				(aObj name:)
			)
		)
	)
)

