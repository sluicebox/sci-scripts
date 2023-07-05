;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use Head)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm007 0
)

(local
	local0
	local1
)

(instance rm007 of MGRoom
	(properties
		picture 7
		south 14
		west 6
		edgeN -1
		edgeE 320
	)

	(method (init &tmp temp0 temp1)
		(super init:)
		(= global305 outCode)
		(proc0_1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 95 135 73 116 80 109 101 108 138 107 143 108 150 113 156 120 130 135
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 0 170 0 95 58 138 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 300 0 296 176 210 177 210 150 226 150 220 121 239 86 232 74 220 70 53 64 20 81 0 81
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 25 91 58 96 57 104 31 105
					yourself:
				)
		)
		(gCurRoom
			addObstacle:
				(= local1
					((Polygon new:)
						type: PBarredAccess
						init: 232 82 232 93 160 93 160 82
						yourself:
					)
				)
		)
		(Load rsVIEW 86)
		(theCat init:)
		(catHead
			init: theCat (CelHigh (theCat view:) (theCat loop:) (theCat cel:))
		)
		(dog init:)
		(moon init:)
		(cow init:)
		(= global301 converse)
		(= temp0 (gEgo x:))
		(= temp1 (gEgo y:))
		(switch gPrevRoomNum
			(west
				(= temp1 (proc0_13 69 temp1 111))
				(gEgo posn: 26 temp1 init:)
				(self setScript: gStdWalkIn 0 5)
			)
			(south
				(= temp0 (proc0_13 51 temp0 201))
				(gEgo setPri: -1 posn: temp0 139 init:)
				(self setScript: gStdWalkIn 0 5)
			)
			(45 ; mapRoom
				(if global172
					(gEgo posn: 150 135 init:)
					(self setScript: converse)
				else
					(gEgo posn: global173 global174 init:)
					(gGame handsOn:)
				)
			)
			(else
				(gEgo posn: 150 135 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(DisposeScript 307)
		(super dispose: &rest)
	)
)

(instance tapScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (proc0_13 80 (gEgo x:) 150) 138 self
				)
			)
			(1
				(proc0_7 gEgo theCat)
				(catHead hide:)
				(theCat setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(theCat setCycle: End self)
			)
			(3
				(theCat setCycle: End self)
			)
			(4
				(theCat setLoop: 14 setCel: 0)
				(catHead show:)
				(= cycles 2)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance theCat of Actor
	(properties
		x 113
		y 107
		view 86
		loop 14
		illegalBits 0
	)

	(method (init)
		(self setPri: 125)
		(if ((gGoals at: 5) egoReturned:)
			(= cel 1)
		else
			(= cel 0)
		)
		(super init:)
		(= global109 self)
	)

	(method (doVerb)
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: converse)
			)
		)
	)
)

(instance catHead of Head
	(properties
		view 86
		loop 1
	)

	(method (init)
		(super init: &rest)
		(= global113 self)
	)

	(method (doVerb)
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: converse)
			)
		)
	)

	(method (doit)
		(self
			setLoop:
				(cond
					((< (gEgo x:) (- (client x:) 20)) 3)
					((> (gEgo x:) (+ (client x:) 20)) 1)
					(else 2)
				)
		)
		(super doit:)
	)
)

(instance cow of Actor
	(properties
		x 208
		y 90
		view 86
		loop 5
		cel 4
		yStep 8
		cycleSpeed 15
		illegalBits 0
		xStep 8
		moveSpeed 15
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
		(= global110 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance dog of Actor
	(properties
		x 50
		y 100
		view 86
		loop 9
		cycleSpeed 10
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
		(= global111 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance moon of View
	(properties
		x 107
		y 37
		view 86
		loop 8
		cel 2
	)

	(method (init)
		(super init:)
		(self setPri: 0)
		(= global112 self)
	)

	(method (doit)
		(= cel (if (< (cow y:) y) 3 else 2))
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(proc0_7 gEgo theCat)
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(= temp0 (gGoals at: 5))
			(proc0_20)
			(cond
				(local0
					(switch local0
						(1
							(self setScript: converse2 self)
						)
						(2
							(self setScript: converse4 self)
						)
						(else
							(self setScript: converse6 self)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse7 self)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self)
					(if (== global123 2)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self)
					(= global123 2)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self)
					(temp0 egoTold: 1)
					(= global123 2)
					(= local0 1)
				)
			)
		else
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(proc0_5)
			(= gNarrator global516)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: tapScript self)
			)
			(1
				(gMessager say: 5 1 2 0 self) ; "Well, howdy do! You haven't seen a fiddle lying about in these parts, have you?"
			)
			(2
				(= global131 (+ (theCat x:) 1))
				(= global132 (- (theCat y:) 75))
				(= global128 104)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance converse2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: tapScript self)
			)
			(1
				(gMessager say: 5 1 3 0 self) ; "Well, now! Are you keeping your eyes open for my fiddle? Thank you much, partner."
			)
			(2
				(= global131 (+ (theCat x:) 1))
				(= global132 (- (theCat y:) 75))
				(= global128 104)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(= global123 2)
				(self dispose:)
			)
		)
	)
)

(instance converse3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: tapScript self)
			)
			(1
				(gMessager say: 5 1 4 0 self) ; "There you are. No fiddle yet, I see."
			)
			(2
				(= global131 (+ (theCat x:) 1))
				(= global132 (- (theCat y:) 75))
				(= global128 104)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance converse4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: tapScript self)
			)
			(1
				(gMessager say: 5 1 5 0 self) ; "Hey, there! You're not going to find my fiddle around here! Perhaps that little dog made off with it again."
			)
			(2
				(= global131 (+ (theCat x:) 1))
				(= global132 (- (theCat y:) 75))
				(= global128 104)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(= global123 2)
				(self dispose:)
			)
		)
	)
)

(instance converse5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cow setScript: 0)
				(self setScript: tapScript self)
			)
			(1
				(gLongSong fade:)
				(gMessager say: 5 1 6 0 self) ; "Hey, Mr. Cat. I found your fiddle!"
			)
			(2
				(catHead setPri: (- (theCat priority:) 1))
				(self setScript: (ScriptID 307) self) ; rhymeScript
			)
			(3
				(catHead setPri: (theCat priority:))
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 5 1 7 0 self) ; "Gosh! My fiddle sounds as good as ever, don't you think? Thank you, friend!"
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance converse7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 5 1 8 0 self) ; "I see you're back again. I've still got my fiddle, thanks to you."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance mgNarrator of MGNarrator
	(properties
		modeless 2
	)

	(method (startAudio param1)
		(switch global515
			(11
				(catHead setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(11
				(catHead cel: 0 setCycle: 0)
			)
			(9
				(self doEgoQuiet:)
			)
		)
		(super dispose:)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 17 (gEgo x:) 229))
				(= temp1 53)
			)
			(2
				(= temp0 248)
				(= temp1 (proc0_13 73 (gEgo y:) 149))
			)
			(3
				(= temp0 (proc0_13 18 (gEgo x:) 210))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 69 (gEgo y:) 104))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

