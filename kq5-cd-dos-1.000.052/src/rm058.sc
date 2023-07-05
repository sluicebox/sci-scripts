;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
(include sci.sh)
(use Main)
(use castle)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm058 0
)

(local
	local0
	local1
	local2
	[local3 16] = [0 136 50 136 38 169 278 168 275 140 319 137 319 189 0 189]
	[local19 36] = [0 0 319 0 319 124 270 125 266 115 249 114 242 107 232 112 217 104 207 115 111 114 97 105 87 111 77 105 70 115 56 117 52 125 0 126]
)

(instance rm058 of KQ5Room
	(properties
		picture 58
		east 59
		west 57
	)

	(method (init)
		(super init:)
		(gEgo view: 34 init: setPri: 10)
		((gEgo head:) setPri: (gEgo priority:))
		(= global345 260)
		(= global346 140)
		(= global347 159)
		(= global348 116)
		(Load rsVIEW 34)
		(Load rsVIEW 692)
		(Load rsVIEW 906)
		(self
			setFeatures: organ angel doorWay1 doorWay2
			setRegions: 550 ; castle
			addObstacle: poly1 poly2
		)
		(switch gPrevRoomNum
			(west
				(gCurRoom setScript: enterLeft)
			)
			(else
				(gCurRoom setScript: enterRight)
			)
		)
		(rightSnake init: stopUpd:)
		(leftSnake init: stopUpd:)
		(evilMask init:)
		(cond
			((== global333 3)
				((ScriptID 550 3) init:) ; theHenchMan
			)
			((and (not global353) (not global352) (> (Random 0 100) 50))
				((ScriptID 550 3) init:) ; theHenchMan
			)
		)
		(poly1 points: @local3 size: 8)
		(poly2 points: @local19 size: 18)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((and (== global331 3) (gEgo inRect: 131 95 210 198))
				(if (Random 0 1)
					(= global349 78)
					(= global350 130)
					(= global351 270)
					(= global354 90)
				else
					(= global349 246)
					(= global350 125)
					(= global351 90)
					(= global354 270)
				)
				((ScriptID 550 7) init: setScript: (ScriptID 550 12)) ; theWizard, theWizardScript
			)
			((gEgo inRect: -10 111 35 140)
				(gCurRoom setScript: exitLeft)
			)
			((gEgo inRect: 286 123 330 145)
				(evilMask addToPic:)
				(gCurRoom setScript: exitRight)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)
)

(instance rightSnake of Prop
	(properties
		x 96
		y 8
		view 692
		loop 1
		detailLevel 3
	)
)

(instance leftSnake of Prop
	(properties
		x 215
		y 7
		view 692
		loop 2
		detailLevel 3
	)
)

(instance evilMask of Prop
	(properties
		x 160
		y 17
		view 692
		loop 3
		detailLevel 3
	)

	(method (doit)
		(super doit:)
		(if (< 145 (gEgo x:) 175)
			(self loop: 4 cel: (/ (- 154 (gEgo y:)) 14))
		else
			(self loop: 3 cel: (/ (gEgo x:) 35))
		)
	)
)

(instance keys1 of Prop
	(properties
		x 141
		y 89
		view 692
	)
)

(instance keys2 of Prop
	(properties
		x 173
		y 89
		view 692
	)
)

(instance keys3 of Prop
	(properties
		x 158
		y 93
		view 692
	)
)

(instance organ of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0008))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 617)
					(event claimed: 1)
				)
				(3 ; Do
					(cond
						(local2
							(event claimed: 0)
						)
						((and (not local0) (not (gCurRoom script:)))
							(++ local2)
							(if (== global333 1)
								((ScriptID 550 3) setScript: 0 setMotion: 0) ; theHenchMan
							)
							(evilMask setScript: playOrgan)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance angel of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 618)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 621)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance doorWay1 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 619)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance doorWay2 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 620)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance enterLeft of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo
					illegalBits: 0
					posn: -4 130
					setMotion: MoveTo 42 130 self
				)
			)
			(1
				(proc550_18)
				(self dispose:)
			)
		)
	)
)

(instance enterRight of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo
					illegalBits: 0
					posn: 317 130
					setMotion: MoveTo 280 130 self
				)
			)
			(1
				(proc550_18)
				(self dispose:)
			)
		)
	)
)

(instance exitRight of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(if local0
					(gGlobalSound fade:)
				)
				(gEgo illegalBits: 0 setMotion: MoveTo 317 130 self)
			)
			(1
				(if local0
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo view: 0)
				(= global333 0)
				(if local0
					(= global352 10)
				)
				(gCurRoom newRoom: 59)
			)
		)
	)
)

(instance exitLeft of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(if (!= global333 3)
					(gGlobalSound fade:)
				)
				(gEgo illegalBits: 0 setMotion: MoveTo -4 130 self)
			)
			(1
				(if local0
					(= seconds 2)
				else
					(= cycles 1)
				)
			)
			(2
				(if (or (< global333 3) (== global333 7))
					(= global333 0)
					(gEgo view: 0)
					(if local0
						(= global352 10)
					)
					(gCurRoom newRoom: 57)
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance playOrgan of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (== global333 2)
					(Say 616)
				else
					(proc550_17)
					(= local0 1)
					(gGlobalSound fade:)
					(gEgo setMotion: PolyPath 158 114 self)
				)
			)
			(1
				(proc0_7 gEgo evilMask 5)
				(RedrawCast)
				(Say 622)
				(gGlobalSound number: 128 loop: 1 play: self)
				(leftSnake
					setCycle: (if (== (gGame detailLevel:) 3) Fwd else 0)
					cycleSpeed: 5
				)
				(rightSnake
					setCycle: (if (== (gGame detailLevel:) 3) Fwd else 0)
					cycleSpeed: 5
				)
				(keys1
					init:
					cycleSpeed: (Random 2 8)
					setCycle: (if (> (gGame detailLevel:) 1) Fwd else 0)
					setCycle: Fwd
				)
				(keys2
					init:
					cycleSpeed: (Random 2 8)
					setCycle: (if (> (gGame detailLevel:) 1) Fwd else 0)
				)
				(keys3
					init:
					cycleSpeed: (Random 2 8)
					setCycle: (if (> (gGame detailLevel:) 1) Fwd else 0)
				)
				(proc550_18)
			)
			(2
				(leftSnake stopUpd:)
				(rightSnake stopUpd:)
				(keys1 hide: stopUpd:)
				(keys2 hide: stopUpd:)
				(keys3 hide: stopUpd:)
				(if (or (== global333 3) (== global333 2))
					((ScriptID 550 3) setScript: 0 setMotion: 0 stopUpd:) ; theHenchMan
				)
				(if (!= global333 3)
					(= global352 3)
				)
				(client setScript: 0)
			)
		)
	)
)

