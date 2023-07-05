;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use Head)
(use MoveProp)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Path)
(use Motion)
(use Actor)
(use System)

(public
	rm033 0
)

(local
	local0
	[local1 19] = [232 131 202 134 161 142 131 149 112 151 86 151 47 149 16 147 -4 148 32768]
	local20
)

(instance rm033 of MGRoom
	(properties
		picture 33
		north 26
		east 34
		west 32
		edgeN 89
		edgeE 245
		edgeS 255
	)

	(method (init)
		(Load rsVIEW 146)
		(Load rsVIEW 88)
		(= local0 0)
		(proc0_1)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 130 7 130 10 128 23 129 34 132 48 135 56 136 72 139 89 142 111 141 117 142 128 142 178 127 196 125 218 120 256 120 256 155 0 155
					yourself:
				)
		)
		(jack init:)
		(jackHead init: jack (CelHigh (jack view:) (jack loop:) (jack cel:)))
		(leaf init:)
		(smoke init:)
		((MoveProp new:) init: 146 0 72 155 12 setPri: 189 yourself:)
		((MoveProp new:) init: 146 1 172 140 12 setPri: 189 yourself:)
		((MoveProp new:) init: 146 2 20 154 12 setPri: 189 yourself:)
		(candle init:)
		(candle hide:)
		(if ((gGoals at: 12) egoReturned:)
			(candle ignoreActors: 1 show: posn: 144 109)
			(gCurRoom
				addObstacle:
					(= local20
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 86 0 86 79 98 79 142 100 158 100 158 112 100 118 73 119 39 122 0 121
							yourself:
						)
					)
			)
		else
			(gCurRoom
				addObstacle:
					(= local20
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 86 0 86 79 98 79 142 98 138 116 100 116 73 119 39 122 0 121
							yourself:
						)
					)
			)
		)
		(= global305 outCode)
		(= global301 converse)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 147 (gEgo x:) 243) 101)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 26 124)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 (proc0_13 95 (gEgo y:) 117))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
				(if global172
					(gEgo posn: 150 115)
					(self setScript: converse)
				else
					(gGame handsOn:)
				)
			)
			(else
				(gEgo posn: 150 115 init:)
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
			((== (gEgo edgeHit:) 1)
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (dispose)
		(DisposeScript 402)
		(DisposeScript 64983)
		(DisposeScript 333)
		(super dispose:)
	)
)

(instance float of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leaf posn: 262 131)
				(= seconds (Random 7 30))
			)
			(1
				(= state -1)
				(leaf setMotion: floatDown self leaf)
			)
		)
	)
)

(instance jack of Actor
	(properties
		x 124
		y 112
		priority 8
		view 88
		cycleSpeed 5
		illegalBits 0
	)

	(method (init)
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

(instance jackHead of Head
	(properties
		view 88
	)

	(method (init)
		(super init: &rest)
		(= x (client x:))
		(if (> (gEgo x:) x)
			(= loop 2)
		else
			(= loop 3)
		)
		(= z (client z:))
		(= y (- (client y:) 17))
		(= global110 self)
	)

	(method (doit &tmp temp0)
		(cond
			((< (gEgo x:) (- (jack x:) 20))
				(= temp0 3)
			)
			((> (gEgo x:) (+ (jack x:) 20))
				(= temp0 1)
			)
			(else
				(= temp0 2)
			)
		)
		(if (== view 89)
			(-- temp0)
		)
		(self setPri: (+ (client priority:) 1))
		(self setLoop: temp0 1)
		(super doit: &rest)
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

(instance leaf of Actor
	(properties
		x 262
		y 131
		fixPriority 1
		view 144
		loop 1
		cycleSpeed 15
		illegalBits 0
		xStep 2
	)

	(method (cue)
		(= cycleSpeed (Random 12 24))
	)

	(method (init)
		(super init:)
		(self setPri: 190 ignoreActors: 1 setCycle: Fwd setScript: float)
	)

	(method (onMe)
		(return 0)
	)
)

(instance floatDown of Path
	(properties)

	(method (at param1)
		(return [local1 param1])
	)
)

(instance smoke of Prop
	(properties
		x 162
		y 52
		view 144
		cycleSpeed 20
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (onMe)
		(return 0)
	)
)

(instance candle of Prop
	(properties
		x 60
		y 40
		view 55
		cycleSpeed 8
	)

	(method (init)
		(= global111 candle)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (onMe)
		(return 0)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_7 gEgo jack)
				(= cycles 2)
			)
			(1
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
				(= cycles 2)
			)
			(1
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 52))
				(= global128 111)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(2
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
			(= temp0 (gGoals at: 12))
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
					(temp0 egoReturned: 1)
					(self setScript: converse5 self)
					(if (== global123 12)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self)
					(= global123 12)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self)
					(temp0 egoTold: 1)
					(= local0 1)
					(= global123 12)
				)
			)
		else
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(proc0_5)
			(= gNarrator global516)
			(gGame handsOn:)
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
				(gMessager say: 15 1 2 0 self) ; "Hi. What's your name?"
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
				(gMessager say: 15 1 3 0 self) ; "You're not going to find my candlestick by hanging around here! Hurry up! I'll be waiting."
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global123 12)
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
				(gMessager say: 15 1 4 0 self) ; "Well? What's the news? Do you have my candlestick?"
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
				(gMessager say: 15 1 5 0 self) ; "Come on! Hurry up, will you! I need my candlestick!"
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

(instance converse5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(jackHead hide:)
				(jack
					illegalBits: 0
					ignoreActors: 1
					view: 89
					setLoop: 4 1
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gLongSong fade:)
				(gMessager say: 15 1 6 1 self) ; "I've got your candlestick, Jack!"
			)
			(3
				(self setScript: (ScriptID 333) self) ; rhymeScript
			)
			(4
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
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 15 1 7 0 self) ; "You okay, Jack?"
			)
			(2
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
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 15 1 8 0 self) ; "Hi, Jack."
			)
			(2
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
				(jackHead setCycle: ROsc 10000 0)
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
				(jackHead cel: 0 setCycle: 0)
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
				(= temp0 (proc0_13 109 (gEgo x:) 255))
				(= temp1 88)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 91 (gEgo y:) 115))
			)
			(3
				(= temp0 (proc0_13 29 (gEgo x:) 179))
				(= temp1 137)
			)
			(4
				(= temp0 0)
				(= temp1 (proc0_13 126 (gEgo y:) 131))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

