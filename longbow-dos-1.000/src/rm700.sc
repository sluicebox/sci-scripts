;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Blk)
(use Feature)
(use LoadMany)
(use SmoothLooper)
(use Rev)
(use Wander)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm700 0
	longPole 1
	theBow 2
	theBoat 3
	quiver 4
)

(local
	local0
	[local1 8]
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	[local21 26]
	[local47 26] = [133 175 137 153 157 132 157 170 168 134 133 147 135 162 159 133 134 174 172 170 174 160 178 176 138 158]
	[local73 26] = [89 79 66 53 42 32 70 28 104 108 18 97 63 75 39 73 45 110 94 74 55 30 9 28 21 15]
	[local99 26] = [3 0 1 3 3 3 0 0 0 1 1 1 2 2 2 3 3 0 0 0 0 3 2 2 1 3]
	[local125 12]
	[local137 13] = [252 0 249 126 71 295 259 195 232 26 291 170 7]
	[local150 13] = [169 184 74 175 158 62 189 165 148 168 137 154 155]
	[local163 4] = [1700 42 1 0]
)

(procedure (localproc_0 &tmp temp0)
	(wispHolder init:)
	(switch gHowFast
		(0
			(= local0 4)
		)
		(1
			(= local0 6)
		)
		(else
			(= local0 8)
		)
	)
	(for ((= temp0 0)) (< temp0 local0) ((++ temp0))
		(= [local1 temp0] (wisp new:))
		([local1 temp0]
			x: (Random 15 305)
			y: (Random 166 203)
			setLoop: (Random 0 2)
			setStep: 2 2
			init:
			ignoreActors: 1
			observeBlocks: wispHolder
			setCycle: Fwd
			setMotion: Wander 230
		)
	)
	(gRgnMusic2 number: 582 loop: -1 play:)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 12) ((++ temp0))
		((= [local125 temp0] (wave new:))
			x: [local137 temp0]
			y: [local150 temp0]
			init:
		)
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 26) ((++ temp0))
		(= [local21 temp0] (clIvy new:))
		([local21 temp0]
			x: [local47 temp0]
			y: [local73 temp0]
			setLoop: [local99 temp0]
			setCel: 221
			ignoreActors: 1
			init:
			stopUpd:
		)
	)
)

(procedure (localproc_3 param1)
	(if (gCurRoom obstacles:)
		((gCurRoom obstacles:) dispose:)
		(gCurRoom obstacles: 0)
	)
	(gCurRoom
		addObstacle:
			(if param1
				((Polygon new:) type: PBarredAccess init: 0 0 319 0 319 153 0 153 yourself:)
			else
				((Polygon new:)
					type: PBarredAccess
					init: 0 113 57 123 136 126 221 120 256 111 239 107 197 115 149 118 92 118 34 112 0 104 0 0 319 0 319 189 0 189
					yourself:
				)
			)
	)
)

(instance rm700 of Rm
	(properties
		picture 700
		horizon 30
	)

	(method (notify param1)
		(switch param1
			(1
				(= local16 1)
				(= local15 0)
			)
			(2
				(if (and (== global115 1) (not local12))
					(= local12 1)
					(= local11 3)
					(gCurRoom setScript: (naiadPrinter new:) 0 9)
				)
			)
		)
	)

	(method (init)
		(LoadMany rsVIEW 700 703 708 711 709 21 587 15 702)
		(= local20 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(if (== gPrevRoomNum 701)
			(self style: 13)
			(gEgo
				view: 709
				loop: 2
				setPri: 12
				actions: unusualDoVerb
				ignoreHorizon: 1
				y: 31
				setCycle: Walk
				init:
			)
		else
			(self style: 10)
		)
		(super init:)
		(if (and (== global115 1) (not (gCast contains: local1)))
			(localproc_0)
		)
		(if (!= (gRgnMusic number:) 585)
			(gRgnMusic number: 585 loop: -1 play:)
		)
		(if (!= (gSFX number:) 581)
			(gSFX number: 581 loop: -1 play:)
		)
		(if (not (IsFlag 0))
			(localproc_1)
		)
		(AddToFeatures sky theReeds theIvy bottomTower clFog theWater)
		(if (== gPrevRoomNum 701)
			(= global124 21)
			(= local17 1)
			(= local16 1)
			(localproc_2)
			(theBow posn: 149 122 init:)
			(quiver init:)
			(longPole init:)
			(theBoat
				view: 21
				loop: 2
				cel: 2
				setPri: 11
				posn: 110 124
				ignoreActors: 1
				init:
				stopUpd:
			)
			(HandsOn)
			(gTheIconBar disable: 0 4)
			((gTheIconBar at: 2) message: 1)
		else
			(gEgo
				view: 587
				loop: 0
				cel: 0
				posn: 20 175
				setStep: 4 4
				cycleSpeed: 18
				actions: unusualDoVerb
				looper: boatLooper
				signal: (| (gEgo signal:) $1000)
				init:
				setScript: egoTogether
			)
			(localproc_3 1)
		)
	)

	(method (reflectPosn)
		(return 0)
	)

	(method (doit &tmp temp0)
		(if (< (gEgo y:) 118)
			(gRgnMusic setVol: (+ (/ (gEgo y:) 4) 95))
			(gSFX setVol: (+ (/ (gEgo y:) 4) 95))
		)
		(if (not (IsFlag 115))
			(++ local14)
			(if (and (> (gGame detailLevel:) 2) (== (mod local14 5) 0))
				(Palette palANIMATE 225 255 -1)
			)
		)
		(if (IsFlag 110)
			(ClearFlag 110)
			(if (== global124 21)
				(if (not (gCast contains: clIvy))
					(SetScore 25 84)
					(gEgo setScript: ivyDoubled)
				)
			else
				(Say 1700 7 1) ; "Zounds, I forgot. The plants will answer only to their Druid names."
			)
		)
		(cond
			(
				(and
					(== global115 1)
					(!= gTheCursor 5)
					(not (gCast contains: local1))
				)
				(localproc_0)
			)
			((and (!= global115 1) (gCast contains: local1))
				(gRgnMusic2 stop:)
				(wispHolder dispose:)
				(for ((= temp0 0)) (< temp0 local0) ((++ temp0))
					(if (IsObject [local1 temp0])
						([local1 temp0] dispose:)
					)
				)
			)
			((gEgo script:))
			((gEgo edgeHit:)
				(if (== (gEgo edgeHit:) EDGE_TOP)
					(gEgo setScript: N)
				else
					(gEgo setScript: outtaHere)
				)
			)
			((and (> (gEgo y:) 75) local17)
				(= local17 0)
				(gTheIconBar enable: 0)
				((gTheIconBar at: 2) message: 3)
				(gEgo setScript: (ScriptID 704 3)) ; getOffVines
				(localproc_3 0)
			)
			((and (not (<= 130 (gEgo x:) 170)) (not local15) local17)
				(= local15 1)
				(gEgo setMotion: 0 setScript: (ScriptID 704 2)) ; climbGoThere
			)
			(else
				(super doit: &rest)
			)
		)
		(if (gCast contains: local1)
			(gRgnMusic2 setVol: (- 127 (/ (gEgo distanceTo: local1) 3)))
		else
			(gRgnMusic2 stop:)
		)
	)

	(method (dispose &tmp temp0)
		(for ((= temp0 0)) (< temp0 26) ((++ temp0))
			(if
				(and
					(gCast contains: [local21 temp0])
					(IsObject [local21 temp0])
				)
				([local21 temp0] dispose:)
			)
		)
		(gRgnMusic2 fade: 0 20 12 1)
		(LoadMany 0 968 970 949)
		(if (gCast contains: chIvy)
			(chIvy dispose: delete:)
		)
		(= global124 0)
		(= gUseSortedFeatures local20)
		(super dispose:)
	)
)

(instance boatLooper of SmoothLooper
	(properties
		cycleSpeed 18
		vChangeDir 588
	)
)

(instance wispHolder of Cage
	(properties)

	(method (init)
		(self top: 165 bottom: 195 left: 15 right: 305)
		(super init:)
	)
)

(instance unusualDoVerb of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(3 ; Do
					(cond
						((== (gEgo view:) 587)
							(Say 1601 99 1) ; "That would serve no purpose."
							1
						)
						((and (not (gCast contains: clIvy)) (== global124 21))
							(Say 1700 8 1) ; "I'll accomplish nothing more with the Hand Code here."
							1
						)
					)
				)
				(4 ; Inventory
					(cond
						(local17
							(Say 1700 31 1) ; "If I let go of these vines, I'm a dead man."
							1
						)
						((== invItem 1) ; horn
							(Say 1700 32 1) ; "I'm not that eager to die!"
							1
						)
					)
				)
			)
		)
	)
)

(instance sky of Feature
	(properties
		x 273
		y 25
		nsLeft 227
		nsBottom 50
		nsRight 319
		lookStr 47 ; "A perpetual gloom hangs over these fens."
	)
)

(instance bottomTower of Feature
	(properties
		x 118
		y 52
		nsBottom 137
		nsRight 236
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if local17
					(Say 1700 14 1) ; "I can see a single window near the top of the tower."
				else
					(Say 1700 15 1) ; "These stones are closely set. There's not the least handhold I could use for climbing them."
				)
			)
			(3 ; Do
				(if (or local17 local16)
					(Say 1700 16 1) ; "I cannot climb on bare stone."
				else
					(= local16 1)
					(localproc_3 0)
					(gEgo setScript: (ScriptID 704 0)) ; egoDock
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theReeds of Feature
	(properties
		x 92
		y 84
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1700 17 1) ; "They're common reeds."
			)
			(3 ; Do
				(Say 1700 18 1) ; "The reeds are of no use to me."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 116 18 98 34 98 40 119 68 102 85 122 100 118 103 99 136 128 148 118 171 117 180 127 194 113 206 104 219 101 236 117 247 86 271 94 278 84 309 111 304 129 250 146 141 150 0 149
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance clFog of Feature
	(properties
		x 278
		y 74
		nsTop 47
		nsLeft 237
		nsBottom 101
		nsRight 319
		lookStr 33 ; "The thick fog both hinders and protects me on the water, but quickly thins out overhead."
	)
)

(instance theWater of Feature
	(properties
		x 159
		y 145
		nsTop 101
		nsBottom 189
		nsRight 319
		lookStr 19 ; "Blessed Mary, save me from drowning and becoming a Will-o-th'Wisp!"
	)
)

(instance theIvy of Feature
	(properties
		y 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (gCast contains: chIvy)
					(chIvy dispose:)
				else
					(chIvy init:)
				)
			)
			(3 ; Do
				(cond
					((== global124 21)
						(gEgo setScript: egoClimbQuiverBow)
					)
					(local17
						(Say 1700 21 1) ; "For my dear life's sake, I'm clinging to this ivy as tightly as I can."
					)
					(local16
						(if (not local19)
							(= local19 1)
							(= local18 1)
							(gEgo setScript: egoClimbQuiverBow)
						else
							(Say 1700 34 1) ; "Clearly, the ivy cannot bear my weight, yet I can see no other way to scale this tower."
						)
					)
					(else
						(= local16 1)
						(localproc_3 0)
						(gEgo setScript: (ScriptID 704 0)) ; egoDock
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 148 0 186 0 190 12 190 43 173 55 172 70 151 84 165 107 160 119 152 118 118 100 98 82 113 59 138 48 163 56 171 27
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance chIvy of View
	(properties
		x 30
		y 25
		view 700
		loop 4
		signal 16385
	)

	(method (doVerb)
		(if (gCast contains: chIvy)
			(self dispose:)
		)
	)
)

(instance quiver of View
	(properties
		x 157
		y 123
		lookStr 30 ; "'Tis my quiver."
		view 15
		loop 4
		cel 6
		priority 9
		signal 17
	)
)

(instance wave of Prop
	(properties
		view 700
		loop 6
		signal 16384
		cycleSpeed 18
		detailLevel 2
	)

	(method (init)
		(if (Random 0 1)
			(self setCel: (Random 0 2) setCycle: Fwd)
		else
			(self setCel: (Random 0 2) setCycle: Rev)
		)
		(super init:)
	)
)

(instance clIvy of Prop
	(properties
		view 700
		signal 24576
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1700 25 1) ; "The ivy now looks more than strong enough to bear my weight."
			)
			(3 ; Do
				(cond
					((and (== global124 21) local16 (not local17))
						(gEgo setScript: egoClimbQuiverBow)
					)
					(local17
						(Say 1700 21 1) ; "For my dear life's sake, I'm clinging to this ivy as tightly as I can."
					)
					(local16
						(if (not local19)
							(= local19 1)
							(gEgo setScript: egoClimbQuiverBow)
						else
							(Say 1700 34 1) ; "Clearly, the ivy cannot bear my weight, yet I can see no other way to scale this tower."
						)
					)
					(else
						(= local16 1)
						(localproc_3 0)
						(gEgo setScript: (ScriptID 704 0)) ; egoDock
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance longPole of Prop
	(properties
		x 142
		y 148
		lookStr 28 ; "'Tis the pole I used to push the boat."
		view 15
		loop 5
		cel 3
		priority 12
		signal 16401
	)

	(method (doVerb theVerb)
		(theBoat doVerb: theVerb)
	)
)

(instance wisp of Actor
	(properties
		x 160
		y 100
		z 15
		view 610
		signal 24576
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1601 0 0) ; "It makes me most uneasy to be so close to the spirits of those who drowned in these fens."
			)
			(10 ; Longbow
				(Say 1601 2 0) ; "The Will-o-th'Wisps cannot be touched."
			)
			(3 ; Do
				(Say 1601 1 0) ; "The Will-o-th'Wisps cannot be touched. As if one would want to touch a spirit of the dead!"
			)
			(5 ; Talk
				(if (== (gEgo view:) 587)
					(gCurRoom setScript: fraidyCat)
				else
					(= local11 3)
					(gEgo setScript: (naiadPrinter new:) 0 43)
				)
			)
			(4 ; Inventory
				(SetMessageColor 30)
				(Say ; "We have no use for mortal things."
					1601
					6
					1
					67
					(Random 15 200)
					(Random 5 100)
					80
					{Will-o-th'Wisps}
				)
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theBow of Prop
	(properties
		x 142
		y 150
		lookStr 29 ; "'Tis my longbow."
		view 15
		loop 6
		cel 3
		priority 12
		signal 18449
	)

	(method (doVerb theVerb invItem)
		(if (and local17 local16)
			(super doVerb: theVerb &rest)
		else
			(theBoat doVerb: theVerb &rest)
		)
	)
)

(instance theBoat of Prop
	(properties
		view 21
		loop 2
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if local16
					(Say 1700 27 1) ; "At least I know the boat will be here when I return."
				else
					(Say 1700 26 1) ; "I hope the Monks won't notice their missing boat too soon."
				)
			)
			(3 ; Do
				(gEgo setScript: egoBoat)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 144 124 self)
			)
			(1
				(gEgo setPri: 10 setMotion: MoveTo 142 148 self)
			)
			(2
				(gEgo y: 150 setHeading: 135 self)
			)
			(3
				(gEgo
					view: 15
					setLoop: 2
					setCel: 0
					ignoreActors: 1
					cycleSpeed: 12
					setCycle: End self
				)
				(theBow
					posn: 142 150
					setPri: (+ (gEgo priority:) 2)
					init:
					setCycle: End
				)
			)
			(4
				(= cycles 24)
			)
			(5
				(theBow dispose:)
				(gEgo setCycle: Beg)
				(longPole setCycle: Beg self)
			)
			(6
				(longPole dispose:)
				(gEgo posn: 133 149 setLoop: 1 setPri: 11 setCel: 3)
				(= ticks 12)
			)
			(7
				(gEgo posn: 136 149 setLoop: 7 setCel: 4)
				(= ticks 12)
			)
			(8
				(theBoat dispose:)
				(gEgo view: 587 setLoop: 0 cel: 0 posn: 148 146)
				(= ticks 12)
			)
			(9
				(gEgo
					setStep: 4 4
					cycleSpeed: 18
					setCycle: Walk
					actions: unusualDoVerb
					looper: boatLooper
					signal: (& (| (gEgo signal:) $1000) $f7ff)
					setMotion:
						MoveTo
						(+ (gEgo x:) 50)
						(+ (gEgo y:) 20)
						self
				)
				(= local16 0)
				(localproc_3 1)
			)
			(10
				(HandsOn)
				(gTheIconBar disable: 4)
				(self dispose:)
			)
		)
	)
)

(instance egoClimbQuiverBow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 148 121 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(= ticks 12)
			)
			(3
				(theBow setCel: 0 posn: 149 122 setPri: 9 cycleSpeed: 18 init:)
				(gEgo
					view: 15
					setLoop: 2
					setCel: 0
					cycleSpeed: 18
					posn: 152 126
				)
				(= ticks 12)
			)
			(4
				(theBow setCycle: End)
				(gEgo setCycle: End self)
			)
			(5
				(theBow stopUpd:)
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo
					posn: 149 123
					setLoop: 3
					setCel: 0
					setCycle: CT 5 1 self
				)
			)
			(7
				(quiver init: stopUpd:)
				(gEgo posn: 152 116)
				(NormalEgo 2 702 703)
				(= ticks 24)
			)
			(8
				(gGame setSpeed: global141)
				(gEgo setMotion: MoveTo 145 119 self)
			)
			(9
				(if local18
					(gEgo setScript: moveToVines)
				else
					(gEgo
						view: 708
						setLoop: 2
						setCel: 1
						setPri: 12
						ignoreActors: 1
						setCycle: CT 4 1 self
					)
				)
			)
			(10
				(gEgo
					view: 709
					setLoop: -1
					loop: 3
					posn: 156 75
					setStep: 2 3
					setCycle: Walk
				)
				(= local17 1)
				((gCurRoom obstacles:) eachElementDo: #dispose dispose:)
				(gCurRoom obstacles: 0)
				(HandsOn)
				(gTheIconBar disable: 0 4)
				((gTheIconBar at: 2) message: 1)
				(self dispose:)
			)
		)
	)
)

(instance ivyDoubled of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo theIvy self)
			)
			(1
				(if (gCast contains: chIvy)
					(chIvy dispose:)
				)
				(for ((= temp0 0)) (< temp0 26) ((++ temp0))
					(= [local21 temp0] (clIvy new:))
					([local21 temp0]
						x: [local47 temp0]
						y: [local73 temp0]
						setLoop: [local99 temp0]
						init:
						setCycle: End [local21 temp0]
					)
				)
				(= seconds 3)
			)
			(2
				(for ((= temp0 0)) (< temp0 26) ((++ temp0))
					(if (IsObject [local21 temp0])
						([local21 temp0] stopUpd:)
					)
				)
				(Say 1700 24 self) ; "The ivy has magically doubled in thickness and strength."
			)
			(3
				(HandsOn)
				(if (not local16)
					(gTheIconBar disable: 4)
				)
				(self dispose:)
			)
		)
	)
)

(instance N of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreHorizon:
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 65) self
				)
			)
			(1
				(gCurRoom newRoom: 701)
			)
		)
	)
)

(instance moveToVines of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local18 0)
				(gEgo
					view: 708
					setLoop: 2
					setCel: 1
					ignoreActors: 1
					posn: 146 119
					setCycle: End self
				)
			)
			(1
				(Say 1700 22 self) ; "The vines broke off at my touch."
			)
			(2
				(quiver dispose:)
				(gEgo
					view: 15
					posn: 149 121
					setLoop: 3
					setCel: 5
					cycleSpeed: 18
					setCycle: Beg self
				)
			)
			(3
				(gEgo view: 15 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(4
				(theBow
					setCel: 3
					setPri: (+ (gEgo priority:) 1)
					cycleSpeed: 18
					setCycle: Beg
				)
				(gEgo setCycle: Beg self)
			)
			(5
				(theBow dispose:)
				(NormalEgo)
				(self dispose:)
				(HandsOn)
				(gTheIconBar disable: 4)
			)
		)
	)
)

(instance egoTogether of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 40 175 self)
			)
			(1
				(if (and (not (IsFlag 26)) (== global115 1))
					(SetFlag 26)
					(= local11 2)
					(self setScript: (naiadPrinter new:) self 0)
				else
					(+= state 3)
					(self cue:)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(= local11 3)
				(self setScript: (naiadPrinter new:) self 3)
			)
			(4
				(= ticks 6)
			)
			(5
				(HandsOn)
				(self dispose:)
				(gTheIconBar disable: 4)
			)
		)
	)
)

(instance fraidyCat of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local11 3)
				(self setScript: (naiadPrinter new:) self 35)
			)
			(1
				(if (AyeOrNay)
					(for ((= temp0 0)) (< temp0 local0) ((++ temp0))
						(if (IsObject [local1 temp0])
							([local1 temp0]
								setLoop: (Random 0 2)
								ignoreBlocks: wispHolder
								setStep: 5 2
								setMotion:
									MoveTo
									(Random
										(- ([local1 temp0] x:) 30)
										(+ ([local1 temp0] x:) 30)
									)
									250
							)
						)
					)
					(+= state 3)
					(= local13 1)
					(= local11 2)
					(self setScript: (naiadPrinter new:) self 39)
					(SetMessageColor 0)
				else
					(Converse @local163 1 0 self) ; "Is there nothing else you can do to help me here?"
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(= local11 3)
				(self setScript: (naiadPrinter new:) self 43)
			)
			(4
				(HandsOn)
				(gTheIconBar disable: 4)
				(self dispose:)
			)
			(5
				(gEgo
					cycleSpeed: 24
					moveSpeed: 6
					setMotion: MoveTo (gEgo x:) 189
				)
				(self dispose:)
			)
		)
	)
)

(instance outtaHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch (gEgo edgeHit:)
					(EDGE_BOTTOM
						(gEgo
							setMotion:
								PolyPath
								(gEgo x:)
								(+ (gEgo y:) 40)
								self
						)
					)
					(EDGE_LEFT
						(if local16
							(client setScript: (ScriptID 704 1)) ; cantGoThere
						else
							(gEgo
								setMotion:
									PolyPath
									(- (gEgo x:) 40)
									(gEgo y:)
									self
							)
						)
					)
					(EDGE_RIGHT
						(gEgo
							setMotion:
								PolyPath
								(+ (gEgo x:) 40)
								(gEgo y:)
								self
						)
					)
				)
			)
			(1
				(gCurRoom newRoom: (if local13 600 else 620))
			)
		)
	)
)

(instance naiadPrinter of TScript
	(properties)

	(method (cue)
		(if (not notKilled)
			(SetMessageColor 0)
			(if (not local9)
				(HandsOn 1)
			)
			(gTheIconBar enable: 8)
			(= local11 (= local10 0))
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local9 global143)
				(HandsOff)
				(gTheIconBar disable: 8)
				(= cycles 1)
			)
			(1
				(SetMessageColor 30)
				(Say
					1700
					(+ register local10)
					self
					67
					(Random 15 200)
					(Random 90 150)
					80
					{Will-o-th'Wisps}
				)
				(if local11
					(++ local10)
				)
			)
			(2
				(if (and local11 (<= local10 local11))
					(-= state 2)
				)
				(self cue:)
			)
			(3
				(= local11 (= local10 0))
				(if (not local9)
					(HandsOn)
				)
				(gTheIconBar enable: 8)
				(SetMessageColor 0)
				(self dispose:)
			)
		)
	)
)

