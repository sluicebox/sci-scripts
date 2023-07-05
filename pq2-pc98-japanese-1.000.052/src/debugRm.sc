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
								801
								1
								67
								150
								100
								33
								999
								91
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
						(Print 801 2 801 1) ; "Key commands: ALT-V Set Global Var CTRL-N Show cast CTRL-F Show memory CTRL-T Teleport CTRL-B Visual CTRL-O Priority CTRL-C Control CTRL-G Get InvItem"
					)
					(KEY_ALT_v
						(= temp4 (GetNumber {global #?}))
						(= [gEgo temp4] (GetNumber {value:} [gEgo temp4]))
					)
					($000e
						(for
							((= temp4 (gCast first:)))
							temp4
							((= temp4 (gCast next: temp4)))
							
							(= temp1 (NodeValue temp4))
							(Print
								(Format ; "view: %d x:%d y:%d %s %s illB=$%x"
									@temp5
									801
									3
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
								801
								1
								80
								(temp1 name:)
								82
								(temp1 view:)
								(temp1 loop:)
								(temp1 cel:)
							)
						)
					)
					(JOY_DOWN
						(Format ; "ego x:%d y:%d loop:%d cel:%d"
							@temp5
							801
							4
							(gEgo x:)
							(gEgo y:)
							(gEgo loop:)
							(gEgo cel:)
						)
						(Print @temp5 801 1 82 (gEgo view:) 6 0 7 0)
					)
					(JOY_LEFT
						(= temp4 (GetNumber {ID number of the object?}))
						((gInventory at: temp4) moveTo: gEgo)
						(if (== temp4 1)
							(= [global215 1] 7)
							(= [global215 2] 7)
						)
					)
					(KEY_CAPITAL
						(gCurRoom newRoom: (GetNumber {room #}))
					)
					(JOY_UPRIGHT
						(Show 1)
					)
					($000f
						(Show 2)
					)
					(JOY_RIGHT
						(Show 4)
					)
					(JOY_DOWNLEFT
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

