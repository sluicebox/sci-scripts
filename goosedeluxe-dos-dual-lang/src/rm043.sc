;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use Head)
(use MoveProp)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm043 0
)

(local
	local0
	local1
	local2 = 26
	local3
)

(instance rm043 of MGRoom
	(properties
		picture 43
		south 26
		edgeN -1
		edgeE 320
		edgeW -1
		edgeS 133
	)

	(method (init)
		(super init:)
		(= local3 0)
		(= local0 0)
		(= global305 outCode)
		(gEgo init:)
		(= global110 jackHead)
		(proc0_8 154 94 133 142)
		(= global301 converse)
		((MoveProp new:) init: 71 0 186 113 10 setPri: 4 yourself:)
		((MoveProp new:) init: 71 11 194 84 12 setPri: 12 yourself:)
		((MoveProp new:) init: 71 12 60 134 12 setPri: 120 yourself:)
		(jack init:)
		(if ((gGoals at: 6) egoReturned:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 146 170 138 135 208 135 199 127 179 127 161 89 143 89 140 99 91 100 86 104 68 104 67 114 89 122 89 135 123 135 118 170
						yourself:
					)
			)
			(jack posn: 79 101 setLoop: 15 1 setCel: 0 setCycle: 0)
		else
			(gCurRoom
				addObstacle:
					(= local1
						((Polygon new:)
							type: PContainedAccess
							init: 146 170 138 135 208 135 199 127 179 127 174 113 159 113 159 104 172 104 172 89 143 89 140 99 91 100 86 104 68 104 67 114 89 122 89 135 123 135 118 170
							yourself:
						)
					)
			)
		)
		(if (== gPrevRoomNum 45) ; mapRoom
			(gEgo posn: 135 132)
			(if global172
				(self setScript: converse)
			else
				(gGame handsOn:)
			)
		else
			(gEgo posn: 135 132)
			(= gPrevRoomNum 26)
			(self setScript: sHornerWalkIn)
		)
		(fireSound play:)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((> (gEgo y:) 136)
				(fireSound stop:)
				(gCurRoom newRoom: local2)
			)
		)
	)

	(method (dispose)
		(DisposeScript 343)
		(super dispose: &rest)
	)
)

(instance sHornerWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 132 142
					init:
					setLoop: -1
					ignoreActors: 1
					edgeHit: EDGE_NONE
					setMotion: MoveTo 132 132 self
				)
			)
			(1
				(gGame handsOn:)
				(gEgo ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jack setLoop: 2 setCel: 0 setCycle: CT 4 1 self)
			)
			(1
				(jackHead
					init: jack (CelHigh (jack view:) (jack loop:) (jack cel:))
				)
				(jack cel: 255)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance atEaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jackHead dispose:)
				(jack setLoop: 2 1 cel: 4 setCycle: CT 0 -1 self)
			)
			(1
				(jack setLoop: 1 1 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance jack of Actor
	(properties
		x 172
		y 110
		view 71
		loop 1
		cycleSpeed 9
		moveSpeed 3
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
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

(instance jackHead of Head
	(properties
		view 71
		loop 5
	)

	(method (doit)
		(self setPri: (client priority:))
		(if (not script)
			(self setPri: (client priority:))
			(= x (client x:))
			(= y (client y:))
			(= z
				(-
					(+
						(client z:)
						(CelHigh (client view:) (client loop:) (client cel:))
					)
					1
				)
			)
			(self
				setLoop:
					(cond
						((< (gEgo y:) (- (client y:) 20)) 6)
						((< (gEgo y:) (+ (client y:) 1)) 5)
						((> (gEgo y:) (+ (client y:) 20)) 3)
						(else 4)
					)
			)
		)
		(super doit:)
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

(instance fireSound of Sound
	(properties
		flags 1
		number 590
		loop -1
	)

	(method (init)
		(= global111 self)
		(super init:)
	)

	(method (stop)
		(if handle
			(super stop: &rest)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(gGame handsOff:)
			(fireSound fade: 0 4 4 1)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(proc0_7 gEgo jack)
			(= temp0 (gGoals at: 6))
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
					(temp0 egoReturned: 1)
					(if (== global123 3)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self)
					(= global123 3)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self)
					(= global123 3)
					(temp0 egoTold: 1)
					(= local0 1)
				)
			)
		else
			(fireSound play: setVol: 0 fade: 127 4 4 0)
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(proc0_5)
			(if (< gScore gPossibleScore)
				(= gNarrator global516)
				(gGame handsOn:)
			)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 19 1 2 0 self) ; "Hi. Who are you?"
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 52))
				(= global128 105)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
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
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 19 1 3 0 self) ; "Come on! I don't want someone else to get it first! Please hurry and find it!"
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 52))
				(= global128 105)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(= global123 3)
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
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 19 1 4 0 self) ; "Hi, Jack."
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 52))
				(= global128 105)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
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
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 19 1 5 0 self) ; "Hurry up! I want my Christmas pie! Please get it for me!"
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 52))
				(= global128 105)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(= global123 3)
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
				(gEgo setMotion: PolyPath 141 121 self)
			)
			(1
				(= global247 gCast)
				(proc0_7 gEgo jack)
				(self setScript: attentionScript self)
			)
			(2
				(gLongSong fade:)
				(gMessager say: 19 1 6 0 self) ; "Here's your Christmas pie, Jack!"
			)
			(3
				(self setScript: (ScriptID 343) self) ; rhymeScript
			)
			(4
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 146 170 143 135 208 135 199 127 179 127 161 89 143 89 140 99 91 100 86 104 68 104 67 114 89 122 89 135 129 135 118 170
							yourself:
						)
				)
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
				(jack setLoop: 14)
				(= cycles 1)
			)
			(1
				(gMessager say: 19 1 7 0 self) ; "Mmmmmmm. That Christmas pie sure filled me up! And wasn't that plum a dandy? Thanks for bringing it back to me."
			)
			(2
				(jack setLoop: 13 1 setCycle: Fwd)
				(= cycles 1)
			)
			(3
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
				(= local3 1)
				(gMessager say: 19 1 8 0 self) ; "My Christmas pie is all gone and I'm not hungry anymore. I think I'll just sit here in the corner and relax for awhile."
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
			(17
				(if local3
					(jack loop: 15 setCycle: ROsc 10000 0)
				else
					(jackHead setCycle: ROsc 10000 0)
				)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(17
				(if local3
					(jack cel: 0 setCycle: 0)
				else
					(jackHead cel: 0 setCycle: 0)
				)
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
				(= temp0 (proc0_13 72 (gEgo x:) 177))
				(= temp1 87)
			)
			(2
				(= temp0 207)
				(= temp1 (proc0_13 87 (gEgo y:) 135))
			)
			(3
				(= temp0 (proc0_13 118 (gEgo x:) 601))
				(= temp1 150)
			)
			(4
				(= temp0 48)
				(= temp1 (proc0_13 102 (gEgo y:) 125))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

