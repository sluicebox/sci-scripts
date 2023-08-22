;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm020 0
)

(local
	local0
	local1
)

(instance rm020 of Rm
	(properties
		picture 20
		style 0
		horizon 105
		east 21
		west 19
		picAngle 70
	)

	(method (init)
		(Load rsSOUND 9)
		(Load rsVIEW 300)
		(Load rsVIEW 126)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(13
				(cond
					((or (> (gEgo x:) 109) (< (gEgo x:) 55))
						(gEgo y: (+ horizon 1))
					)
					((< (gEgo x:) 83)
						(gEgo x: 54)
					)
					(else
						(gEgo x: 110)
					)
				)
			)
			(19
				(gEgo x: 16 y: 117)
			)
			(21
				(if (< (gEgo y:) 107)
					(gEgo
						setPri: -1
						y: (+ (/ (* (- (gEgo y:) 96) 12) 10) 106)
					)
				else
					(gEgo
						setPri: -1
						y: (+ (/ (* (- (gEgo y:) 107) 56) 41) 130)
					)
				)
			)
			(26
				(gEgo x: (+ (/ (* (- (gEgo x:) 277) 51) 41) 22) y: 184)
			)
			(27
				(gEgo posn: 152 184)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10 80 150)
		(gAddToPics
			add:
				flower
				((Clone flower) loop: 6 cel: 1 x: 6 y: 151)
				((Clone flower) loop: 7 cel: 1 x: 13 y: 154)
				((Clone flower) loop: 6 cel: 1 x: 2 y: 143)
				((Clone flower) loop: 6 cel: 1 x: 8 y: 140)
				((Clone flower) loop: 6 cel: 1 x: 9 y: 165)
				((Clone flower) loop: 7 cel: 1 x: 215 y: 155)
			eachElementDo: #init
			doit:
		)
		(if global131
			(flag cycleSpeed: 1 setCycle: Fwd init:)
			(bell cycleSpeed: 3 setScript: bellScript init:)
		else
			(flag init: addToPic:)
			(bell init: addToPic:)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if
					(and
						(> global131 0)
						(& temp0 emSHIFT)
						(proc0_16 event 175 26 183 34)
						(!= local1 1)
					)
					(bellScript changeState: 1)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) EDGE_TOP)
				(if (== global111 47)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 13)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(if (== global111 46)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 27)
			)
		)
		(super doit:)
	)
)

(instance bellScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(bell setCycle: ForwardCounter 2 self)
				(= local1 1)
				(bellSound number: 9 loop: 2 play:)
			)
			(2
				(= local1 0)
				(RedrawCast)
				(self init:)
			)
		)
	)
)

(instance bellSound of Sound
	(properties
		priority 7
	)
)

(instance flower of View
	(properties
		x 10
		y 158
		view 300
		loop 6
	)
)

(instance flag of Prop
	(properties
		x 133
		y 28
		view 126
		loop 8
	)
)

(instance bell of Prop
	(properties
		x 179
		y 24
		view 126
		loop 9
	)
)

