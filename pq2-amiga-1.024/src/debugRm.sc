;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use User)
(use Actor)
(use System)

(public
	debugRm 0
)

(instance debugRm of Locale
	(properties)

	(method (handleEvent event &tmp temp0 temp1 [temp2 2] temp4 [temp5 40])
		(if (or (not global101) (event claimed:))
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((& (event modifiers:) emCTRL)
						(event claimed: 1)
						(User canControl: 1)
						(while (!= evMOUSERELEASE ((= temp0 (Event new:)) type:))
							(GlobalToLocal temp0)
							(gEgo posn: (temp0 x:) (temp0 y:) setMotion: 0)
							(RedrawCast)
							(temp0 dispose:)
						)
						(temp0 dispose:)
					)
					((& (event modifiers:) emSHIFT)
						(event claimed: 1)
						(= temp1
							(Print
								(Format @temp5 801 0 (event x:) (event y:)) ; "%d/%d"
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
			)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_QUESTION
						(Print 801 1) ; "Key commands: ALT-S Show cast ALT-M Show memory ALT-T Teleport ALT-V Visual ALT-P Priority ALT-C Control ALT-I Get InvItem"
					)
					(KEY_ALT_s
						(for
							((= temp4 (gCast first:)))
							temp4
							((= temp4 (gCast next: temp4)))
							
							(= temp1 (NodeValue temp4))
							(Print
								(Format ; "view: %d x:%d y:%d %s %s illB=$%x"
									@temp5
									801
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
					(KEY_ALT_e
						(Format ; "ego x:%d y:%d loop:%d cel:%d"
							@temp5
							801
							3
							(gEgo x:)
							(gEgo y:)
							(gEgo loop:)
							(gEgo cel:)
						)
						(Print @temp5 82 (gEgo view:) 6 0 7 0)
					)
					(KEY_ALT_i
						(= temp4 (GetNumber {ID number of the object?}))
						((gInventory at: temp4) moveTo: gEgo)
						(if (== temp4 1)
							(= [global215 1] 7)
							(= [global215 2] 7)
						)
					)
					(KEY_ALT_t
						(gCurRoom newRoom: (GetNumber {Which room number?}))
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
					(KEY_ALT_m
						(gGame showMem:)
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

