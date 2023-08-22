;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm004 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm004 of Rm
	(properties
		picture 4
		style 0
		horizon 97
		east 5
		south 11
		west 3
		picAngle 75
		vanishingY -99
	)

	(method (init)
		(Load rsSOUND 17)
		(Load rsSOUND 43)
		(Load rsSOUND 44)
		(Load rsVIEW 123)
		(Load rsVIEW 300)
		(super init:)
		(= global207 0)
		(= global125 -1)
		(door init: stopUpd:)
		(switch gPrevRoomNum
			(3
				(= local2 (+ (/ (* (- (gEgo y:) 127) 63) 62) 126))
				(= local3 (- 41 (/ (* (- local2 124) 33) 65)))
				(gEgo posn: local3 local2)
			)
			(5
				(if (not [global675 5])
					(gGlobalMGSound number: 1 priority: 5 loop: -1)
					(if (== global208 0)
						(gGlobalMGSound play:)
					)
				)
				(= local3
					(+
						(/
							(*
								(-
									(= local2
										(+
											(/ (* (- (gEgo y:) 125) 62) 64)
											127
										)
									)
									126
								)
								34
							)
							63
						)
						278
					)
				)
				(gEgo posn: local3 local2)
			)
			(11
				(cond
					((< (gEgo x:) 82)
						(gEgo x: (+ (/ (* (- (gEgo x:) 54) 36) 27) 6))
					)
					((< (gEgo x:) 101)
						(gEgo x: 42)
					)
					((< (gEgo x:) 119)
						(gEgo x: 93)
					)
					((< (gEgo x:) 203)
						(gEgo x: (+ (/ (* (- (gEgo x:) 116) 127) 84) 93))
					)
					((< (gEgo x:) 220)
						(gEgo x: 220)
					)
					((< (gEgo x:) 240)
						(gEgo x: 275)
					)
					((< (gEgo x:) 264)
						(gEgo x: (+ (/ (* (- (gEgo x:) 239) 39) 24) 275))
					)
				)
			)
			(37
				(gEgo
					loop: 2
					y: 126
					x: (+ (/ (* (- (gEgo x:) 98) 37) 129) 140)
					edgeHit: EDGE_NONE
				)
				(self setScript: closeDoorScript)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10 264 144)
		(gAddToPics
			add:
				crest
				flower
				((Clone flower) loop: 5 cel: 2 x: 89 y: 106)
				((Clone flower) loop: 5 cel: 0 x: 84 y: 99)
				((Clone flower) loop: 5 cel: 2 x: 103 y: 110)
				((Clone flower) loop: 5 cel: 0 x: 98 y: 103)
				((Clone flower) loop: 5 cel: 0 x: 115 y: 105)
				((Clone flower) loop: 5 cel: 1 x: 222 y: 96)
				((Clone flower) loop: 5 cel: 0 x: 201 y: 108)
				((Clone flower) loop: 5 cel: 2 x: 205 y: 100)
				((Clone flower) loop: 5 cel: 0 x: 222 y: 107)
				((Clone flower) loop: 5 cel: 2 x: 215 y: 102)
				((Clone flower) loop: 5 cel: 0 x: 236 y: 100)
				((Clone flower) loop: 5 cel: 0 x: 231 y: 107)
			eachElementDo: #init
			doit:
		)
	)

	(method (doit)
		(if (!= (= local0 (gEgo onControl: 1)) local1)
			(= local1 local0)
			(switch local0
				(2
					(gEgo edgeHit: EDGE_LEFT)
				)
				(4
					(if (not [global675 5])
						(gGlobalMGSound fade:)
					)
					(gEgo edgeHit: EDGE_RIGHT)
				)
				(16384
					(self setScript: openDoorScript)
				)
				(else 0)
			)
		)
		(super doit:)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGlobalMGSound number: 17 loop: 1 play:)
				(door setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 37)
			)
		)
	)
)

(instance closeDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door setCycle: Beg self)
				(gGlobalMGSound number: 43 loop: 1 play:)
			)
			(1
				(door stopUpd:)
				(gGlobalMGSound number: 44 loop: 1 play: self)
			)
			(2
				(if (== gScore gPossibleScore)
					(proc0_14 150 153)
				else
					(HandsOn)
					(gCurRoom setScript: 0)
					(gGlobalMGSound number: 1 priority: 5 loop: -1)
					(if (== global208 0)
						(gGlobalMGSound play:)
					)
				)
			)
		)
	)
)

(instance door of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 123
			setLoop: 1
			posn: 159 113
			setCel: (if (== gPrevRoomNum 37) species else 0)
			cycleSpeed: 1
		)
	)
)

(instance crest of View
	(properties
		y 39
		x 159
		view 123
	)
)

(instance flower of PV
	(properties
		y 109
		x 81
		view 300
		loop 5
	)
)

