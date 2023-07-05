;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room25 0
)

(synonyms
	(brook brook brook)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance wave1 of Prop
	(properties)
)

(instance wave2 of Prop
	(properties)
)

(instance waves of List
	(properties)
)

(instance Room25 of Rm
	(properties
		picture 25
	)

	(method (init)
		(= north 19)
		(= south 1)
		(= east 26)
		(= west 31)
		(= horizon 84)
		(= gIndoors 0)
		(= global224 0)
		(gEgo edgeHit: 0)
		(super init:)
		(if gNight
			(gCurRoom overlay: 125)
		)
		(self setRegions: 504 501 503 506) ; Gull_Region, waterReg, beachReg, meadReg
		(Load rsVIEW 2)
		(Load rsVIEW 5)
		(Load rsVIEW 6)
		(Load rsVIEW 7)
		(Load rsVIEW 8)
		(Load rsVIEW 21)
		(wave1
			isExtra: 1
			view: 666
			loop: 3
			cel: 3
			posn: 177 74
			setPri: 0
			ignoreActors:
			setCycle: Fwd
			cycleSpeed: 1
			init:
		)
		(wave2
			isExtra: 1
			view: 666
			loop: 4
			cel: 3
			posn: 164 116
			setPri: 0
			ignoreActors:
			setCycle: Fwd
			cycleSpeed: 1
			init:
		)
		(= local4 (Prop new:))
		(= local5 (Prop new:))
		(local4
			isExtra: 1
			view: 666
			loop: 6
			cel: 1
			posn: 254 182
			setPri: 0
			ignoreActors:
			setCycle: Fwd
			init:
		)
		(local5
			isExtra: 1
			view: 666
			loop: 7
			cel: 1
			posn: 226 164
			setPri: 0
			ignoreActors:
			setCycle: Fwd
			init:
		)
		(waves add: wave1 wave2)
		(wave1 setScript: waveActions)
		(if (or (== gPrevRoomNum 222) (== (gEgo view:) 2))
			(= global105 0)
		)
		(switch global105
			(0
				(switch gPrevRoomNum
					(1
						(if (== global105 4)
							(gEgo posn: 60 188)
						else
							(gEgo posn: 217 188)
						)
					)
					(19
						(if (> (gEgo x:) 265)
							(gEgo posn: 239 (+ horizon (gEgo yStep:) 1))
						else
							(gEgo x: 185 y: (+ horizon (gEgo yStep:) 1))
						)
					)
					(26
						(if (<= (gEgo y:) horizon)
							(gEgo posn: 318 (+ horizon 1))
						else
							(gEgo posn: 318 (gEgo y:))
						)
					)
					(31
						(gEgo posn: 1 (gEgo y:))
					)
					(else
						(gEgo posn: 229 125 setMotion: 0 loop: 1)
					)
				)
			)
			(1
				(switch gPrevRoomNum
					(1
						(gEgo x: 126 y: 188)
					)
					(19
						(gEgo x: 166 y: (+ horizon (gEgo yStep:) 1))
					)
					(26
						(gEgo posn: 318 (gEgo y:))
					)
				)
			)
			(2
				(switch gPrevRoomNum
					(1
						(gEgo x: 126 y: 188)
					)
					(19
						(gEgo x: 157 y: (+ horizon (gEgo yStep:) 1))
					)
					(26
						(gEgo posn: 318 (gEgo y:))
					)
				)
			)
			(3
				(switch gPrevRoomNum
					(1
						(gEgo x: 126 y: 188)
					)
					(19
						(gEgo x: 146 y: (+ horizon (gEgo yStep:) 1))
					)
					(26
						(gEgo posn: 318 (gEgo y:))
					)
				)
			)
			(4
				(switch gPrevRoomNum
					(1
						(gEgo x: 48 y: 188)
					)
					(19
						(gEgo posn: 88 (+ horizon (gEgo yStep:) 1))
					)
					(31
						(if (< (gEgo y:) horizon)
							(gEgo y: (+ horizon (gEgo yStep:) 1))
						)
					)
				)
			)
		)
		(gEgo xStep: 3 yStep: 2 init:)
		(HandsOn)
		(= local2 (gEgo viewer:))
	)

	(method (dispose)
		(waves dispose:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/brook')
							(Print 25 0) ; "The cold water of the river contrasts sharply with the warmer ocean water as the two converge."
						)
						((Said '/grass')
							(Print 25 1) ; "Eastward, you see a pretty green meadow."
						)
						((Said '[<around][/around,room,beach]')
							(Print 25 2) ; "A river, coming from the east, spills into the blue ocean before you. A lonely beach edges the ocean. From atop the bluff, a lovely meadow stretches eastward."
						)
					)
				)
				((or (Said 'drink[/water]') (Said 'get/drink'))
					(if (gEgo inRect: 185 150 319 180)
						(cond
							((!= global105 0)
								(Print 25 3) ; "Ahhh! It tastes good!"
							)
							(
								(or
									(& (= local1 (NearControl gEgo 12)) $0008)
									(& local1 $0800)
									(& local1 $0002)
									(& local1 $0200)
								)
								(= global164 (gEgo script:))
								(gEgo setScript: riverActions)
							)
							(else
								(Print 25 4) ; "You're not close enough."
							)
						)
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance riverActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 (gEgo viewer:))
				(gEgo viewer: 0 view: 21 cel: 0 setCycle: End self)
			)
			(1
				(Timer setReal: self 5)
				(= global120 (Print 25 3 #at -1 20 #dispose)) ; "Ahhh! It tastes good!"
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(cls)
				(HandsOn)
				(gEgo view: 2 setCycle: Walk)
				(gEgo script: global164 viewer: local2)
			)
		)
	)
)

(instance waveActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local3 0)) (< local3 (waves size:)) ((++ local3))
					((View new:)
						view: ((waves at: local3) view:)
						loop: ((waves at: local3) loop:)
						cel: 0
						setPri: 0
						ignoreActors:
						x: ((waves at: local3) x:)
						y: ((waves at: local3) y:)
						init:
						addToPic:
						yourself:
					)
				)
				(= local3 0)
				(self changeState: 1)
			)
			(1
				((waves at: local3) cel: 0 show: setCycle: End self)
			)
			(2
				((waves at: local3) hide:)
				(if (< local3 (- (waves size:) 1))
					(++ local3)
				else
					(= local3 0)
				)
				(waveActions changeState: 1)
			)
		)
	)
)

