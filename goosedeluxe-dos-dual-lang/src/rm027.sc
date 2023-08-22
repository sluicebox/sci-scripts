;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use Head)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm027 0
)

(local
	local0
	local1
	local2
)

(instance rm027 of MGRoom
	(properties
		picture 27
		north 20
		east 28
		south 34
		west 26
		edgeN 45
		edgeE 250
		edgeW 15
		edgeS 145
	)

	(method (init)
		(super init:)
		(= global305 outCode)
		(= global111 afterDog)
		(= global301 converse)
		(= local1 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 142 0 0 113 33 106 48 81 63 74 142
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 105 295 98 207 98 175 76 154 61 147 38 289 10
					yourself:
				)
		)
		(proc0_1)
		(boy init:)
		(if ((gGoals at: 3) egoReturned:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 146 111 146 124 102 124 102 111
						yourself:
					)
			)
			(boy setLoop: 5)
			(boyHead init: boy (CelHigh (boy view:) (boy loop:) (boy cel:)))
			(afterDog init:)
		else
			(gCurRoom
				addObstacle:
					(= local2
						((Polygon new:)
							type: PBarredAccess
							init: 134 110 134 124 103 124 103 110
							yourself:
						)
					)
			)
			(boy setCycle: Fwd)
			(boyCryS play:)
		)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 137 45)
				(self setScript: gStdClimbIn)
			)
			(south
				(gEgo
					posn:
						(proc0_13
							(gCurRoom edgeW:)
							(gEgo x:)
							(gCurRoom edgeE:)
						)
						139
				)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 26 (proc0_13 140 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 (proc0_13 119 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
				(if global172
					(gEgo posn: 150 120)
					(global129 posn: (- (gEgo x:) 8) (+ (gEgo y:) 5))
					(self setScript: converse)
				else
					(gEgo posn: global173 global174)
					(gGame handsOn:)
				)
			)
			(else
				(gEgo posn: 150 120 init:)
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
			((== (gEgo edgeHit:) EDGE_TOP)
				(self setScript: gStdClimbOut 0 1)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (dispose)
		(DisposeScript 327)
		(if ((gGoals at: 3) egoReturned:)
			(DisposeScript 609)
		)
		(super dispose: &rest)
	)
)

(instance gestureScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 5 15))
			)
			(1
				(= register (- (Random 1 (NumCels client)) 1))
				(if (!= register (client cel:))
					(client
						setCycle:
							CT
							register
							(if (< (client cel:) register) 1 else -1)
							self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance bark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(afterDog cel: 0)
				(= register (Random 1 3))
				(= seconds (Random 1 4))
			)
			(1
				(if (gCurRoom script:)
					(= state -1)
					(= cycles 1)
				else
					(gSfx number: (Random 19 22) play:)
					(afterDog setCycle: End self)
				)
			)
			(2
				(barkSnd stop:)
				(afterDog cel: 0)
				(if (-- register)
					(self changeState: 1)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance boy of Actor
	(properties
		x 117
		y 121
		view 73
		loop 6
		cycleSpeed 9
	)

	(method (init)
		(if (< global170 90)
			(super init:)
		else
			(super init: gestureScript)
		)
		(self ignoreActors: 1)
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

(instance boyHead of Head
	(properties
		view 73
		loop 2
	)

	(method (init)
		(super init: &rest)
		(= local0 1)
		(= global110 self)
	)

	(method (doit)
		(if local0
			(self
				setLoop:
					(cond
						((< (gEgo x:) (- (client x:) 20)) 3)
						((> (gEgo x:) (+ (client x:) 20)) 4)
						(else 2)
					)
			)
		)
		(super doit:)
	)
)

(instance afterDog of Prop
	(properties
		x 135
		y 117
		view 46
		loop 6
		cycleSpeed 9
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setScript: bark)
	)

	(method (onMe)
		(return 0)
	)
)

(instance boyCryS of Sound
	(properties
		flags 1
		number 606
		loop -1
	)

	(method (stop)
		(if handle
			(super stop: &rest)
		)
	)
)

(instance barkSnd of Sound
	(properties
		flags 1
		loop -1
	)

	(method (play)
		(switch (Random 0 1)
			(0
				(= number 19)
			)
			(1
				(= number 22)
			)
		)
		(super play: &rest)
	)

	(method (stop)
		(if handle
			(super stop: &rest)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(< (gEgo y:) (+ (boy y:) 10))
						(> (gEgo y:) (+ (boy y:) 40))
						(< (gEgo x:) (- (boy x:) 30))
						(> (gEgo x:) (+ (boy x:) 30))
					)
					(gEgo setMotion: PolyPath 117 135 self)
				else
					(= cycles 1)
				)
			)
			(1
				(boyCryS stop:)
				(boy setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo setLoop: 3)
				(boy setLoop: 5 setCycle: 0)
				(boyHead init: boy (CelHigh (boy view:) (boy loop:) (boy cel:)))
				(= cycles 2)
			)
			(3
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
				(boyHead dispose:)
				(boy setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(1
				(boy setLoop: 6 setCycle: Fwd)
				(boyCryS play:)
				(= cycles 2)
			)
			(2
				(= global131 (+ (boy x:) 13))
				(= global132 (- (boy y:) 52))
				(= global128 102)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(proc0_7 gEgo boy)
			(= temp0 (gGoals at: 3))
			(proc0_20)
			(cond
				(local1
					(switch local1
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
					(if (== global123 11)
						(= global123 0)
					)
					(= local1 3)
					(boyCryS stop:)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self)
					(= global123 11)
					(= local1 2)
				)
				(else
					(self setScript: converse1 self)
					(temp0 egoTold: 1)
					(= global123 11)
					(= local1 1)
				)
			)
		else
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(proc0_5)
			(if (< gScore gPossibleScore)
				(gGame handsOn:)
				(= gNarrator global516)
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
				(gMessager say: 13 1 2 0 self 27) ; "Oh, where, oh, where can he be?!"
			)
			(2
				(self setScript: atEaseScript self)
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
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 13 1 3 0 self 27) ; "My little dog isn't here! Maybe Mother Goose knows where he is. Go ask her. Here, Spot! Here, Spot!"
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global123 11)
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
				(gMessager say: 13 1 4 0 self 27) ; "Any luck finding my little dog?"
			)
			(2
				(self setScript: atEaseScript self)
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
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 13 1 5 0 self 27) ; "You're not going to find my little dog here. Try looking in the town."
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global123 11)
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
				(self setScript: attentionScript self)
			)
			(1
				(gLongSong fade:)
				(gMessager say: 13 1 6 0 self 27) ; "You found him! You found my little dog! Thanks!"
			)
			(2
				(= local0 0)
				(self setScript: (ScriptID 327) self) ; rhymeScript
			)
			(3
				((gCurRoom obstacles:) delete: local2)
				(local2 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 146 111 146 124 102 124 102 111
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
				(gMessager say: 13 1 7 0 self 27) ; "Is everything okay now?"
			)
			(1
				(boy setCel: 0)
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
				(if
					(or
						(< (gEgo y:) (+ (boy y:) 10))
						(> (gEgo y:) (+ (boy y:) 40))
						(< (gEgo x:) (- (boy x:) 30))
						(> (gEgo x:) (+ (boy x:) 30))
					)
					(gEgo setMotion: PolyPath 117 135 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setLoop: 3)
				(gMessager say: 13 1 8 0 self 27) ; "Hello."
			)
			(2
				(boy setCel: 0)
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
			(20
				(boyHead setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(20
				(boyHead cel: 0 setCycle: 0)
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
				(= temp0 (proc0_13 119 (gEgo x:) 137))
				(= temp1 44)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 101 (gEgo y:) 152))
			)
			(3
				(= temp0 (proc0_13 2 (gEgo x:) 258))
				(= temp1 158)
			)
			(4
				(= temp0 -10)
				(= temp1 (proc0_13 144 (gEgo y:) 156))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

