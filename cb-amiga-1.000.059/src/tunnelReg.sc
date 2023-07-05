;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 242)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use System)

(public
	tunnelReg 0
)

(instance myMusic of Sound
	(properties)
)

(instance tunnelReg of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (!= gCurRoomNum 52)
			(myMusic number: 61 loop: -1 play:)
		)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				(== (event type:) evMOUSEBUTTON)
				(not (& (event modifiers:) emSHIFT))
				(or
					(== gCurRoomNum 51)
					(== gCurRoomNum 55)
					(and (== gCurRoomNum 56) (& (gEgo onControl:) $0004))
				)
			)
			(event claimed: 1)
			(while (!= evMOUSERELEASE ((= temp0 (Event new:)) type:))
				(gEgo setMotion: MoveTo (temp0 x:) (gEgo y:))
				(temp0 dispose:)
			)
			(temp0 dispose:)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(= temp1 (= temp2 0))
					(for ((= temp3 (gCast first:))) temp3 ((= temp3 temp4))
						(= temp4 (gCast next: temp3))
						(if
							(and
								(IsObject (= temp5 (NodeValue temp3)))
								(== (temp5 view:) 155)
								(not (& (temp5 signal:) $0080))
							)
							(if (== (temp5 loop:) 0)
								(= temp2 1)
							else
								(= temp1 1)
							)
						)
					)
					(cond
						((Said '/beam')
							(if (or temp2 (== gCurRoomNum 51))
								(Print 242 0) ; "Old, splintery beams support the underground passage."
							else
								(NotHere) ; "You don't see it here."
							)
						)
						((or (Said '/dirt') (Said '<down[/!*]'))
							(Print 242 1) ; "There is nothing but dirt on the ground."
						)
						((Said '/wall')
							(Print 242 2) ; "These are bare, earthen walls."
						)
						((Said '/boulder')
							(if (and (== gCurRoomNum 55) temp1)
								(Print 242 3) ; "The slime-coated rocks glisten in the lantern's glow."
							else
								(NotHere) ; "You don't see it here."
							)
						)
						((Said '/eye')
							(Print 242 4) ; "Small, beady eyes glaring from beyond the lantern's glow remind you that you are not alone!"
						)
						((Said '/mouse')
							(NotHere) ; "You don't see it here."
						)
					)
				)
				((Said 'listen')
					(Print 242 5) ; "You hear the squeaking of rats as they scurry about in the darkness."
				)
				((Said 'extinguish,extinguish,(rotate<off)')
					(Print 242 6) ; "This is not the place to be stumbling around in the dark."
				)
			)
		)
	)
)

