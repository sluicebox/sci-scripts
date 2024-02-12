;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 298)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Game)
(use User)
(use Actor)
(use System)

(public
	debugRm 0
)

(instance debugRm of Locale
	(properties)

	(method (dispose)
		(gMouseHandler delete: self)
		(gKeyHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(gMouseHandler add: self)
		(gKeyHandler add: self)
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 2] temp4 temp5 [temp6 40])
		(if (or (not global101) (event claimed:))
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (& (event modifiers:) emSHIFT)
					(= temp1
						(Print
							(Format @temp6 298 0 (event x:) (event y:)) ; "%d/%d"
							#at
							150
							100
							#font
							999
							#dispose
						)
					)
					(while (!= evMOUSERELEASE ((= temp0 (Event new:)) type:))
						(temp0 dispose:)
					)
					(temp1 dispose:)
					(temp0 dispose:)
				)
			)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_QUESTION
						(SaveSubLang)
						(Print 298 1) ; "Key commands: ALT-S Show cast ALT-M Show Memory ALT-T Teleport ALT-V Visual ALT-P Priority ALT-C Control ALT-I Get InvItem ALT-B Set Ego's Bucks ALT-K Set one of Ego's sKills ALT-X Make Ego eXtra special"
						(RestoreSubLang)
					)
					((LangSwitch 7936 1 7936 1)
						(for
							((= temp4 (gCast first:)))
							temp4
							((= temp4 (gCast next: temp4)))
							
							(= temp1 (NodeValue temp4))
							(Print
								(Format ; "view: %d x:%d y:%d %s %s illB=$%x"
									@temp6
									298
									2
									(temp1 view:)
									(temp1 x:)
									(temp1 y:)
									(if (& (temp1 signal:) $0004)
										{stopUpd:\n}
									else
										{}
									)
									(if (& (temp1 signal:) $4000)
										{ignoreActors:\n}
									else
										{}
									)
									(if
										(or
											(== (temp1 superClass:) Act)
											(== (temp1 superClass:) Ego)
										)
										(temp1 illegalBits:)
									else
										-1
									)
								)
								#title
								(temp1 name:)
								#icon
								(temp1 view:)
								(temp1 loop:)
								(temp1 cel:)
							)
						)
					)
					((LangSwitch 4608 5 4608 5)
						(Format ; "ego x:%d y:%d loop:%d cel:%d"
							@temp6
							298
							3
							(gEgo x:)
							(gEgo y:)
							(gEgo loop:)
							(gEgo cel:)
						)
						(Print @temp6 82 (gEgo view:) 6 0 7 0)
					)
					((LangSwitch 5888 4 5888 4)
						(= temp4
							(GetNumber
								{ID number of the object?}
							)
						)
						(gEgo get: temp4)
					)
					((LangSwitch 5120 15 5120 15)
						(gCurRoom
							newRoom:
								(GetNumber
									{Which room number?}
								)
						)
					)
					((LangSwitch 12032 23 12032 23)
						(Show 1)
					)
					((LangSwitch 6400 6 6400 6)
						(Show 2)
					)
					((LangSwitch 11776 8 11776 8)
						(Show 4)
					)
					((LangSwitch 12800 25 12800 25)
						(gGame showMem:)
					)
					((LangSwitch 12288 2 12288 2)
						(Print
							(Format @temp6 298 4 [gInvNum 1] [gInvNum 1]) ; "Our Hero has %d silvers.%", silver, silver
						)
						(= [gInvNum 1] ; silver
							(GetNumber {Enter Silvers.})
						)
					)
					((LangSwitch 9472 11 9472 11)
						(= temp5
							(GetNumber
								{Change which Stat/Skill?}
							)
						)
						(= [gEgoStats temp5]
							(GetNumber
								{Enter new value:}
								[gEgoStats temp5]
							)
						)
					)
					((LangSwitch 11520 24 11520 24)
						(for ((= temp5 0)) (< temp5 25) ((++ temp5))
							(= [gEgoStats temp5] 80)
						)
						(= [gEgoStats 13] 1900) ; experience
						(= [gEgoStats 14] (MaxHealth)) ; health
						(= [gEgoStats 15] (MaxStamina)) ; stamina
						(= [gEgoStats 16] (MaxMana)) ; mana
						(Print 298 5) ; "Why, you feel better already!"
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

