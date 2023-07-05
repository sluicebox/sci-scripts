;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 83)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Menu)
(use Actor)

(public
	Rm83 0
)

(local
	[local0 7]
	[local7 7]
	[local14 7]
	[local21 7]
	[local28 13] = [0 28 63 55 248 285 258 193 157 156 232 83 119]
	[local41 13] = [0 130 130 180 130 130 180 113 63 164 63 63 113]
	[local54 13] = [0 28 63 55 248 285 258 28 63 55 248 285 258]
	[local67 13] = [0 130 130 180 130 130 180 130 130 180 130 130 180]
	[local80 13] = [0 193 157 156 232 83 119 193 157 156 232 83 119]
	[local93 13] = [0 113 63 164 63 63 113 113 63 164 63 63 113]
	[local106 13] = [2 11 11 2 10 10 4 8 8 7 10 11 8]
	[local119 13] = [2 2 12 9 5 5 6 4 10 6 10 8 7]
	[local132 13] = [2 3 3 3 6 6 6 9 12 9 4 2 9]
	[local145 13] = [2 1 1 3 7 4 9 12 11 3 8 11 2]
	[local158 13] = [2 11 11 2 4 5 5 10 8 7 10 11 8]
	[local171 13] = [2 3 9 3 6 5 6 6 7 6 5 12 9]
	[local184 13] = [2 1 2 1 10 10 4 8 8 12 10 11 11]
	[local197 13] = [2 1 3 3 9 6 6 9 12 9 7 1 3]
	local210
	local211
	local212
	local213
	local214
	local215
	local216
	[local217 25]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 1)) (< temp0 7) ((++ temp0))
		(= [local0 temp0] (Tile new:))
		([local0 temp0]
			setLoop: (- temp0 1)
			setCel: 0
			setStep: 9 6
			setPri: 15
			posn: [local54 (+ temp0 local215)] [local67 (+ temp0 local215)]
			ignoreActors: 1
			illegalBits: 0
			init:
		)
		(= [local7 temp0] (TileHole new:))
		([local7 temp0]
			init:
			setLoop: 6
			setCel: 0
			posn: [local54 (+ temp0 local215)] [local67 (+ temp0 local215)]
			signal: 16512
			setPri: 9
			stopUpd:
		)
		(= [local14 temp0] (Niche new:))
		([local14 temp0]
			init:
			setLoop: 6
			setCel: 0
			posn: [local80 (+ temp0 local215)] [local93 (+ temp0 local215)]
			signal: 16512 66 9
			stopUpd:
		)
		(= [local21 temp0] (+ (* (- temp0 1) 6) (Random 1 6)))
	)
	(kCursor setLoop: 6 cel: 1 setPri: 15 ignoreActors: 1 posn: 500 500 init:)
	(gCursor
		init:
		setLoop: 6
		setCel: 0
		setPri: 15
		setStep: 9 6
		ignoreActors: 1
		posn: 500 500
	)
)

(procedure (localproc_1)
	(if local211
		(gCursor posn: 500 500)
	)
	(if (== local210 local211)
		(= local211 0)
	else
		(= local211 local210)
		([local0 local211] setPri: 15)
		(gCursor setPri: 15 posn: ([local0 local211] x:) ([local0 local211] y:))
	)
)

(procedure (localproc_2)
	(if local211
		(= local216 15)
		([local0 local211]
			setMotion:
				MoveTo
				([local7 local210] x:)
				([local7 local210] y:)
				[local0 local211]
			setPri: 15
		)
		(gCursor
			setMotion:
				MoveTo
				([local7 local210] x:)
				([local7 local210] y:)
				gCursor
		)
	)
)

(procedure (localproc_3)
	(if local211
		(= local216 10)
		([local0 local211]
			setMotion:
				MoveTo
				([local14 local210] x:)
				([local14 local210] y:)
				[local0 local211]
			setPri: 15
		)
		(gCursor
			setMotion:
				MoveTo
				([local14 local210] x:)
				([local14 local210] y:)
				gCursor
		)
	else
		(Print 805 [local21 local210] #window fatimaWindow #font 4 #title {Fatima} #time 5)
	)
)

(procedure (localproc_4)
	(= local214 0)
	(for ((= local210 1)) (< local210 7) ((++ local210))
		(if
			(and
				(== ([local0 local210] x:) [local80 (+ local210 local215)])
				(== ([local0 local210] y:) [local93 (+ local210 local215)])
			)
			(++ local214)
		)
	)
	(SetFlag 327)
	(cond
		((== local214 6)
			(Print 83 8 #window fatimaWindow #title {Fatima}) ; "Your wisdom is great. You have passed my test."
			(SetScore 280 1 30)
			(SetFlag 157)
			(gCurRoom newRoom: 64)
		)
		(
			(==
				(Print ; "You have not passed my test. Will you try again?"
					83
					9
					#button
					{Aye}
					1
					#button
					{Nay}
					2
					#window
					fatimaWindow
					#font
					4
					#title
					{Fatima}
				)
				2
			)
			(gCurRoom newRoom: 64)
		)
		(else
			(gCast eachElementDo: #dispose 84)
			(RedrawCast)
			(= local211 (= local216 (= local213 0)))
			(= local215 (Random 0 5))
			(localproc_0)
		)
	)
)

(instance fatimaWindow of SysWindow
	(properties
		color 15
		back 5
		priority 15
		brLeft 50
		brBottom 100
		brRight 270
	)
)

(instance Tile of Act
	(properties
		view 527
		signal 1
	)

	(method (cue)
		([local0 local211] setCel: 0 stopUpd:)
		(if (> local213 6)
			([local0 local211] setPri: local216)
		)
		(= local211 0)
		(= local216 0)
	)
)

(instance TileHole of View
	(properties
		view 527
	)
)

(instance Niche of View
	(properties
		view 527
		signal 1
	)
)

(instance kCursor of View
	(properties
		view 527
		signal 1
	)
)

(instance gCursor of Act
	(properties
		view 527
		signal 1
	)

	(method (cue)
		(self posn: 500 500)
	)
)

(instance Rm83 of Rm
	(properties
		picture 83
		style 0
	)

	(method (init)
		(Load rsVIEW 527)
		(super init:)
		(gEgo posn: 500 500 init:)
		(HandsOff)
		(= local215 (Random 0 5))
		(localproc_0)
		(MenuBar state: 0)
		(= local211 (= local216 0))
		(Display 83 0 dsCOORD 102 173 dsCOLOR 0 dsBACKGROUND 7 dsFONT 4) ; "PRESS F6 WHEN FINISHED"
		(Print 83 1 #window fatimaWindow #font 4 #title {Fatima} #time 12) ; "Here is the challenge placed before you. There are six Tablets engraved with a symbol, one for each of the Six Goddesses."
		(Print 83 2 #window fatimaWindow #font 4 #title {Fatima} #time 12) ; "There are six Niches for the tablets. Choose a Niche and I will pose a question, one question for each of the Six Goddesses."
		(Print 83 3 #window fatimaWindow #font 4 #title {Fatima} #time 10) ; "You must know which Goddess answers the question, then move the Tablet with her symbol into the Niche."
		(Print 83 4 #window fatimaWindow #font 4 #title {Fatima} #time 10) ; "When you have answered all six questions, only then will I tell you whether you have passed or failed."
		(Print 83 5 #window fatimaWindow #font 4 #title {Fatima} #time 5) ; "I bid you to begin and may Aphrodite smile upon you."
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if local216
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(for ((= local210 1)) (< local210 7) ((++ local210))
					(if (MousedOn [local0 local210] event)
						(kCursor posn: 500 500)
						(localproc_1)
						(return)
					)
				)
				(for ((= local210 1)) (< local210 7) ((++ local210))
					(if
						(and
							(MousedOn [local7 local210] event)
							(< 63 (gCursor x:) 248)
						)
						(localproc_2)
						(return)
					)
				)
				(for ((= local210 1)) (< local210 7) ((++ local210))
					(if (MousedOn [local14 local210] event)
						(localproc_3)
						(return)
					)
				)
				(if (OnButton event 102 173 210 183)
					(localproc_4)
				)
			)
			(evKEYBOARD
				(cond
					((== (event message:) KEY_RETURN)
						(for ((= local210 1)) (< local210 7) ((++ local210))
							(if
								(and
									(== (kCursor x:) ([local0 local210] x:))
									(== (kCursor y:) ([local0 local210] y:))
								)
								(kCursor cel: 0)
								(localproc_1)
								(if (not local211)
									(kCursor cel: 1)
								)
								(return)
							)
						)
						(for ((= local210 1)) (< local210 7) ((++ local210))
							(if
								(and
									(==
										(kCursor x:)
										[local54 (+ local210 local215)]
									)
									(==
										(kCursor y:)
										[local67 (+ local210 local215)]
									)
									(< 63 (gCursor x:) 248)
								)
								(localproc_2)
								(return)
							)
						)
						(for ((= local210 1)) (< local210 7) ((++ local210))
							(if
								(and
									(==
										(kCursor x:)
										[local80 (+ local210 local215)]
									)
									(==
										(kCursor y:)
										[local93 (+ local210 local215)]
									)
								)
								(localproc_3)
								(return)
							)
						)
					)
					((== (event message:) KEY_F1)
						(Print ; "Click on an empty Niche to see the clue. Click on a Tablet to select it. Click on a destination to move the selected Tablet. PRESS F6 WHEN ALL TABLETS HAVE BEEN PLACED."
							83
							6
							#at
							45
							160
							#width
							220
							#title
							{Mouse Help}
							#font
							4
							#window
							SysWindow
						)
						(Print ; "USE ARROW KEYS TO POSITION CURSOR BOX. On an empty Niche: press "Enter" to see clue. On a Tablet: press "Enter" to select. Position cursor box on destination, and press "Enter" again to move the selected Tablet. PRESS F6 WHEN ALL TABLETS HAVE BEEN PLACED."
							83
							7
							#at
							45
							160
							#width
							220
							#title
							{Keyboard Help}
							#font
							4
							#window
							SysWindow
						)
					)
					((== (event message:) KEY_F6)
						(localproc_4)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			($0040 ; direction
				(event claimed: 1)
				(kCursor cel: 1)
				(switch (event message:)
					(JOY_UP
						(= local213 [local106 local213])
					)
					(JOY_RIGHT
						(= local213 [local119 local213])
					)
					(JOY_DOWN
						(= local213 [local132 local213])
					)
					(JOY_LEFT
						(= local213 [local145 local213])
					)
					(JOY_UPRIGHT
						(= local213 [local158 local213])
					)
					(JOY_DOWNRIGHT
						(= local213 [local171 local213])
					)
					(JOY_UPLEFT
						(= local213 [local184 local213])
					)
					(JOY_DOWNLEFT
						(= local213 [local197 local213])
					)
				)
				(kCursor posn: [local28 local213] [local41 local213])
			)
		)
	)
)

