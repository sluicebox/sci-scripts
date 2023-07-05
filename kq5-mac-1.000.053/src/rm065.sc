;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use Interface)
(use castle)
(use DLetter)
(use KQ5Room)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use RFeature)
(use Path)
(use Motion)
(use Actor)
(use System)

(public
	rm065 0
)

(local
	local0
	[local1 106] = [0 154 12 154 10 160 10 176 24 177 13 186 298 186 293 181 93 181 101 171 145 171 156 175 314 175 309 170 254 169 239 153 288 153 280 146 187 145 182 131 165 129 155 120 120 119 119 114 76 115 76 122 88 123 64 145 45 133 39 122 71 98 71 93 46 85 45 70 63 70 70 73 270 73 270 67 72 67 66 63 11 63 12 68 35 69 39 86 67 95 34 118 37 131 60 150 0 149 0 0 319 0 319 189 0 189]
	[local107 10] = [127 126 160 126 164 131 162 137 121 137]
	[local117 7] = [50 139 39 129 37 120 -32768]
	[local124 5] = [39 114 52 107 -32768]
	[local129 3] = [68 99 -32768]
	[local132 3] = [64 91 -32768]
	[local135 9] = [50 89 39 84 37 75 39 69 -32768]
	[local144 9] = [40 76 39 84 50 89 64 91 -32768]
	[local153 5] = [68 99 52 107 -32768]
	[local158 3] = [39 114 -32768]
	[local161 9] = [37 120 39 129 50 139 65 147 -32768]
)

(instance rm065 of KQ5Room
	(properties
		picture 65
		west 62
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 4 2 712)
		(poly1 points: @local1 size: 53)
		(poly2 points: @local107 size: 5)
		(self
			setRegions: 550 ; castle
			setFeatures:
				stairs
				((Clone stairs)
					nsLeft: 29
					nsTop: 109
					nsRight: 63
					nsBottom: 149
					yourself:
				)
				bottle
				firePlace
				machine
				doorWay
				room
			addObstacle: poly1 poly2
		)
		(coals setCycle: RandCycle init:)
		(switch gPrevRoomNum
			(66
				(gEgo view: 4 loop: 1 setStep: 1 1 posn: 200 72)
			)
			(else
				(gCurRoom setScript: enterLeft)
			)
		)
		(gEgo init:)
		(if
			(and
				(< (Random 1 100) 30)
				(not global352)
				(not global353)
				(not (== gPrevRoomNum 66))
			)
			((ScriptID 550 7) ; theWizard
				init:
				illegalBits: 0
				ignoreActors: 1
				view: 702
				setScript: mordacksHere
				show:
			)
			(= local0 1)
		)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			(script
				(script doit:)
			)
			((gEgo inRect: 0 148 12 154)
				(gCurRoom setScript: exitLeft)
			)
			((& (= temp1 (gEgo onControl: 0)) $0002)
				(gCurRoom newRoom: 66)
			)
			((& temp1 $0010)
				(proc550_17)
				(self setScript: upStairScript)
			)
			((& temp1 $0080)
				(proc550_17)
				(self setScript: downStairScript)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				(gCurRoom newRoom: temp0)
			)
			(
				(and
					(== global331 3)
					(or (gEgo inRect: 75 142 191 171) (== local0 1))
				)
				(if (< (gEgo x:) 144)
					(= global349 185)
					(= global350 136)
					(= global351 225)
					(= global354 135)
				else
					(= global349 105)
					(= global350 124)
					(= global351 135)
					(= global354 315)
				)
				((ScriptID 550 7) init: setScript: (ScriptID 550 12)) ; theWizard, theWizardScript
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

	(method (dispose)
		(DisposeScript 983)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance lookBottleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 95 186 self)
			)
			(1
				(if (IsObject (gEgo head:))
					((gEgo head:) hide:)
				)
				(gEgo
					normal: 0
					view: 712
					setLoop: 0
					cel: 0
					z: 6
					setPri: 15
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(PrintDC 65 0) ; "Looking at his frantically waving family inside their glass prison makes Graham's heart break as he realizes his inability to save them from their terrible predicament."
				(if (IsObject (gEgo head:))
					((gEgo head:) show:)
				)
				(gEgo
					normal: 1
					view: 2
					setLoop: -1
					loop: 2
					z: 0
					setPri: -1
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				(proc550_18)
				(= global103 0)
				(self dispose:)
			)
		)
	)
)

(instance upStairScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 10 setMotion: upStair1 self)
			)
			(1
				(gEgo setPri: 9 setMotion: upStair2 self)
			)
			(2
				(gEgo view: 4 setStep: 1 1 setMotion: upStair3 self)
			)
			(3
				(gEgo setPri: 10 setLoop: 2 setMotion: upStair4 self)
			)
			(4
				(gEgo setLoop: -1 setMotion: upStair5 self)
			)
			(5
				(gEgo setPri: -1)
				(proc550_18)
				(self dispose:)
			)
		)
	)
)

(instance downStairScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 10 setMotion: downStair1 self)
			)
			(1
				(gEgo setPri: 9 setLoop: 3 setMotion: downStair2 self)
			)
			(2
				(gEgo
					setLoop: -1
					view: 2
					setStep: 2 2
					setMotion: downStair3 self
				)
			)
			(3
				(gEgo setPri: 10 setMotion: downStair4 self)
			)
			(4
				(gEgo setPri: -1)
				(proc550_18)
				(self dispose:)
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
					view: 2
					setStep: 2 2
					posn: -7 152
					setMotion: MoveTo 23 152 self
				)
			)
			(1
				(if (not local0)
					(gGlobalSound number: 891 loop: -1 playBed:)
					(proc550_18)
				else
					(gEgo normal: 0)
					(mordacksHere cue:)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance exitLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc550_17)
				(gGlobalSound fade:)
				(gEgo setMotion: MoveTo -7 152 self)
			)
			(1
				(gCurRoom newRoom: 62)
			)
		)
	)
)

(instance upStair1 of Path
	(properties)

	(method (at param1)
		(return [local117 param1])
	)
)

(instance upStair2 of Path
	(properties)

	(method (at param1)
		(return [local124 param1])
	)
)

(instance upStair3 of Path
	(properties)

	(method (at param1)
		(return [local129 param1])
	)
)

(instance upStair4 of Path
	(properties)

	(method (at param1)
		(return [local132 param1])
	)
)

(instance upStair5 of Path
	(properties)

	(method (at param1)
		(return [local135 param1])
	)
)

(instance downStair1 of Path
	(properties)

	(method (at param1)
		(return [local144 param1])
	)
)

(instance downStair2 of Path
	(properties)

	(method (at param1)
		(return [local153 param1])
	)
)

(instance downStair3 of Path
	(properties)

	(method (at param1)
		(return [local158 param1])
	)
)

(instance downStair4 of Path
	(properties)

	(method (at param1)
		(return [local161 param1])
	)
)

(instance coals of Prop
	(properties
		x 281
		y 152
		view 712
		loop 1
		priority 12
		signal 16400
		cycleSpeed 2
		detailLevel 3
	)

	(method (handleEvent))
)

(instance stairs of RFeature
	(properties
		nsTop 72
		nsLeft 29
		nsBottom 108
		nsRight 80
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 65 1) ; "A spiral staircase leads up to an upper level where a very bizarre machine captures Graham's curiosity."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance doorWay of RFeature
	(properties
		nsTop 91
		nsLeft 5
		nsBottom 155
		nsRight 20
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 65 2) ; "Graham can see part of the upstairs hallway through the doorway."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance firePlace of RFeature
	(properties
		nsTop 138
		nsLeft 253
		nsBottom 165
		nsRight 314
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 65 3) ; "Hot coals burn in an open-pit fireplace built against a side wall."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 65 4) ; "There is nothing but burning coals inside the open-pit fireplace."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bottle of RFeature
	(properties
		nsTop 159
		nsLeft 71
		nsBottom 186
		nsRight 93
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 65 5) ; "Tears come to Graham's eyes as he sees his beloved family and castle held captive inside a large glass bottle."
					(event claimed: 1)
				)
				(3 ; Do
					(if (< (gEgo y:) 100)
						(PrintDC 65 6) ; "Graham can't get a clear view from up here."
						(event claimed: 1)
					else
						(proc550_17)
						(= global103 1)
						(gCurRoom setScript: lookBottleScript)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance machine of RFeature
	(properties
		nsLeft 225
		nsBottom 59
		nsRight 261
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 65 7) ; "An odd machine of tubes, gears, weights, and tiny figures surrounding an unusual sphere-like object attracts Graham's attention."
					(event claimed: 1)
				)
				(3 ; Do
					(if (< (gEgo y:) 100)
						(gEgo setMotion: PolyPath 214 69)
					else
						(PrintDC 65 8) ; "Graham will have to go up the stairs to do that."
					)
					(event claimed: 1)
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

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 65 9) ; "Graham has found himself in a large room filled with many unusual contraptions and magical implements. His heart feels like bursting when he notices his family imprisoned within a large glass bottle sitting upon a corner table."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance mordacksHere of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gGlobalSound number: 835 loop: 1 playBed:)
				(switch (Random 0 2)
					(0
						((ScriptID 550 7) setLoop: 11 posn: 294 177 cel: 0) ; theWizard
						((ScriptID 550 1) init: posn: 278 149 hide:) ; theAura
					)
					(1
						((ScriptID 550 7) setLoop: 9 posn: 242 147 cel: 0) ; theWizard
						((ScriptID 550 1) init: posn: 226 118 hide:) ; theAura
					)
					(2
						((ScriptID 550 7) setLoop: 9 posn: 185 140 cel: 0) ; theWizard
						((ScriptID 550 1) init: posn: 169 111 hide:) ; theAura
					)
				)
			)
			(1
				(proc0_28 73 65 10 67 30 10 25 6) ; "Good-bye, KING Graham of Daventry...heh, heh, heh!"
				(= cycles 1)
			)
			(2
				((ScriptID 550 7) cycleSpeed: 1 setCycle: CT 6 1 self) ; theWizard
			)
			(3
				((ScriptID 550 1) show: setCycle: Fwd setPri: 15) ; theAura
				(= seconds 2)
			)
			(4
				((gEgo head:) hide:)
				(gEgo view: 127 setLoop: 0 setCycle: End self cycleSpeed: 3)
			)
			(5
				(gEgo setLoop: 2 setCycle: Fwd cycleSpeed: 3)
				(= seconds 4)
			)
			(6
				((ScriptID 550 1) hide:) ; theAura
				((ScriptID 550 7) setCel: 255) ; theWizard
				(gEgo setLoop: 4 cel: 0 setCycle: End self)
			)
			(7
				((ScriptID 550 7) setCycle: Beg) ; theWizard
				(= seconds 3)
				(= global103 0)
			)
			(8
				(= global330 {Poor Graham. Mordack shows no mercy.})
				(EgoDead 73 0 -1)
			)
		)
	)
)

