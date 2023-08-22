;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room1 0
)

(local
	local0
	local1
	local2
	local3
)

(instance waves of List
	(properties)
)

(instance wave1 of Prop
	(properties)
)

(instance wave2 of Prop
	(properties)
)

(instance wave3 of Prop
	(properties)
)

(instance Room1 of Rm
	(properties
		picture 1
	)

	(method (init)
		(= north 25)
		(= south 7)
		(= west 31)
		(= east 2)
		(= horizon 100)
		(= gIndoors 0)
		(gEgo edgeHit: EDGE_NONE)
		(gGSound play: 606)
		(super init:)
		(if gNight
			(gCurRoom overlay: 101)
		)
		(self setRegions: 503 501 504 506) ; beachReg, waterReg, Gull_Region, meadReg
		(= local3 (gEgo viewer:))
		(if (== gPrevRoomNum 2)
			(= global105 0)
		)
		(= local1 (Prop new:))
		(wave1
			isExtra: 1
			view: 665
			loop: 0
			cel: 0
			posn: 203 75
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave2
			isExtra: 1
			view: 665
			loop: 1
			cel: 0
			posn: 191 115
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave3
			isExtra: 1
			view: 665
			loop: 2
			cel: 0
			posn: 191 188
			setPri: 0
			ignoreActors:
			init:
			cycleSpeed: 3
			init:
		)
		(local1
			isExtra: 1
			view: 650
			loop: 1
			cel: 1
			posn: 69 61
			setPri: 0
			ignoreActors:
			setCycle: Fwd
			init:
		)
		(waves add: wave1 wave2 wave3)
		(wave1 setScript: waveActions)
		(switch global105
			(0
				(switch gPrevRoomNum
					(south
						(if (> (gEgo x:) 128)
							(gEgo posn: 300 187)
						else
							(gEgo posn: 225 187)
						)
					)
					(north
						(gEgo x: 225 y: (+ horizon (gEgo yStep:) 1))
					)
					(0
						(gEgo x: 220 y: 135)
					)
					(east
						(if (<= (gEgo y:) horizon)
							(gEgo x: 318 y: (+ horizon (gEgo yStep:) 1))
						else
							(gEgo x: 318)
						)
					)
				)
			)
			(1
				(switch gPrevRoomNum
					(south
						(gEgo x: 186 y: 187)
					)
					(north
						(gEgo x: 180 y: (+ horizon (gEgo yStep:) 1))
					)
				)
			)
			(2
				(switch gPrevRoomNum
					(south
						(gEgo x: 145 y: 187)
					)
					(north
						(gEgo x: 167 y: (+ horizon (gEgo yStep:) 1))
					)
				)
			)
			(3
				(switch gPrevRoomNum
					(south
						(gEgo x: 100 y: 187)
					)
					(north
						(gEgo x: 149 y: (+ horizon (gEgo yStep:) 1))
					)
				)
			)
			(4
				(switch gPrevRoomNum
					(south
						(cond
							((> (gEgo x:) 78)
								(gEgo x: 30 y: 187)
							)
							((< (gEgo x:) 20)
								(gEgo x: 20 y: 187)
							)
							(else
								(gEgo x: (gEgo x:) y: 187)
							)
						)
					)
					(25
						(if (> (gEgo x:) 78)
							(gEgo x: 78 y: (+ horizon (gEgo yStep:) 1))
						else
							(gEgo x: 95 y: (+ horizon (gEgo yStep:) 1))
						)
					)
					(31
						(gEgo x: 1)
					)
				)
			)
			(14
				(= global205 0)
				(gEgo viewer: 0 view: 312 setScript: rideDolphin)
				(rideDolphin changeState: 1)
			)
		)
		(gEgo init:)
	)

	(method (dispose)
		(waves dispose:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((Said '/grass')
					(Print 1 0) ; "A flowery meadow stretches to the east."
				)
				((Said '/brook')
					(Print 1 1) ; "You see a river in the distance to the north."
				)
				((Said '[<around][/room]')
					(Print 1 2) ; "A narrow strip of beach borders a vast ocean which stretches off to the west. A pretty green meadow, dotted with bunches of wildflowers, goes to the east."
				)
			)
		)
	)
)

(instance rideDolphin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo setMotion: MoveTo 66 136 self)
			)
			(2
				(= local0 (Act new:))
				(= global105 4)
				(gEgo viewer: local3)
				(gEgo setStep: 3 2)
				(local0
					view: 311
					posn: (gEgo x:) (- (gEgo y:) 5)
					setLoop: 2
					xStep: 2
					yStep: 1
					setCycle: Fwd
					init:
				)
				(= seconds 4)
			)
			(3
				(local0
					xStep: 4
					yStep: 3
					setLoop: 5
					ignoreHorizon:
					ignoreActors:
					moveSpeed: 1
					setMotion: MoveTo -10 100 self
				)
				(HandsOn)
				(= global205 0)
			)
			(4
				(local0 dispose:)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance waveActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local2 0)) (< local2 (waves size:)) ((++ local2))
					((View new:)
						view: ((waves at: local2) view:)
						loop: ((waves at: local2) loop:)
						cel: 0
						setPri: 0
						ignoreActors:
						x: ((waves at: local2) x:)
						y: ((waves at: local2) y:)
						init:
						addToPic:
						yourself:
					)
				)
				(= local2 0)
				(self changeState: 1)
			)
			(1
				((waves at: local2) cel: 255 show: setCycle: End self)
			)
			(2
				((waves at: local2) hide:)
				(if (< local2 (- (waves size:) 1))
					(++ local2)
				else
					(= local2 0)
				)
				(waveActions changeState: 1)
			)
		)
	)
)

