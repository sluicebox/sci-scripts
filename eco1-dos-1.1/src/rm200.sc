;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use n804)
(use HandsOffScript)
(use eRS)
(use Garbage)
(use Apartment)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use ForwardCounter)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm200 0
	enterApartment 1
	Gregarious 3
	gregEnter 4
	gregExit 5
	narci 6
	gregarious 7
	talkIntoApt 8
	gregariousA 9
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 param1 param2)
	(= local0 param1)
	(= local1 param2)
)

(instance rm200 of EcoRoom
	(properties
		picture 200
		style 10
		horizon 16
		east 120
		south 180
	)

	(method (init &tmp temp0)
		(= global250 4)
		(= global251 1)
		(if (IsFlag 43)
			(= north 341)
		)
		(if (== gPrevRoomNum 180)
			(= temp0 (gEgo x:))
			(gEgo x: (Min 219 temp0))
		)
		(super init:)
		(if (not (IsFlag 345))
			(gCast
				add: cap candyBox shoe tube sock plate shirt toaster2 book
				eachElementDo: #init
			)
		)
		(gFeatures
			add:
				blowFishA
				emptyNestA3
				lionFishA
				emptyA1
				swordFishA
				gregariousA
				angelFishA
				emptyNestA2
				seaTurtleA
				columns
				buildings
				steps
				pipes
				moss
				vegatation
			eachElementDo: #init
		)
		(if (IsFlag 46)
			(pump init: setPri: 1)
		)
		(if (not (gEgo has: 4)) ; rag
			(wetRag init:)
		)
		(if (IsFlag 66)
			(brokenBottle init:)
		)
		(if (IsFlag 65)
			(sandwich init:)
		)
		(if (IsFlag 47)
			(narci
				view: 223
				loop: 4
				cel: 0
				x: 84
				y: 70
				cycleSpeed: 4
				setCycle: Fwd
				init:
			)
		)
		(plant1 setCycle: Fwd init:)
		(plant2 setCycle: Fwd init:)
		(plant3 setCycle: Fwd init:)
		(NormalEgo 1)
		(gEgo
			init:
			heading: 270
			setPri: 6
			illegalBits: 0
			ignoreHorizon:
			hide:
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 265 189 297 178 319 178 319 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 5 7 5 7 189
					yourself:
				)
			setRegions: 51 ; bubblesRegion
		)
		(cond
			(
				(and
					(gEgo has: 17) ; spine
					(not (IsFlag 60))
					(== ((Inv at: 10) owner:) 335) ; bikeCage
				)
				(SetFlag 60)
				(gCurRoom setScript: goToCouncilChambers)
			)
			((== gPrevRoomNum 341)
				(if (== ((Inv at: 10) owner:) 335) ; bikeCage
					(gCurRoom setScript: manateeDone)
				else
					(gEgo posn: 211 -18)
					(self setScript: enterFromBoat)
				)
			)
			((IsFlag 40)
				(gCurRoom setScript: swimThru)
			)
			((OneOf gPrevRoomNum 220 221 222 223 224 225 226)
				(self
					setScript:
						exitApartment
						0
						(switch global229
							(1 angelFishA)
							(2 emptyA1)
							(3 gregariousA)
							(4 emptyNestA2)
							(5 swordFishA)
							(6 blowFishA)
							(7 lionFishA)
							(8 emptyNestA3)
							(9 seaTurtleA)
						)
				)
			)
			((== gPrevRoomNum 120)
				(gEgo posn: 370 143)
				(localproc_0 277 139)
			)
			(else
				(gEgo posn: (gEgo x:) 220)
				(localproc_0 (gEgo x:) 175)
			)
		)
		(if local0
			(self setScript: enterScript)
		)
		(gLongSong number: 217 loop: -1 play:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 13) ; "Adam is swimming in front of what looks like a group of caves built into a rocky hillside. These are the Fish Apartments. Most of the citizens of Eluria live here."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(gDelph lookStr: 0 talkScript: 0)
		(ClearFlag 107)
		(gEgo setPri: -1)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(if (> gHowFast 0)
			(Palette palANIMATE 33 43 7)
		)
		(= temp0 (gEgo edgeHit:))
		(cond
			(script 0)
			((or (and (== temp0 1) (not north)) (== temp0 4))
				(gCurRoom setScript: cantLeave)
			)
			((and (> (gEgo x:) 219) (or (== temp0 3) (== temp0 2)))
				(gCurRoom setScript: exitToCourtYard)
			)
		)
		(super doit:)
	)
)

(instance enterFromBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(gEgo show: setMotion: MoveTo (gEgo x:) 28 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gEgo show: setMotion: MoveTo local0 local1 self)
			)
			(2
				(= local0 (= local1 0))
				(if (and (!= ((Inv at: 20) owner:) 200) (not (IsFlag 5))) ; starFish
					(plant1 setScript: (ScriptID 201 0)) ; delExit
					(self dispose:)
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance exitToCourtYard of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 0)
				(or (> (gEgo nsLeft:) 320) (> (gEgo nsTop:) 190))
			)
			(= cycles 1)
		)
	)

	(method (dispose)
		(gEgo ignoreActors: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					setCycle: Walk
					setHeading: 135
					setMotion: MoveFwd 200
				)
			)
			(1
				(gCurRoom newRoom: 120)
			)
		)
	)
)

(instance enterApartment of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo (register swimX:) (register swimY:) self)
			)
			(1
				(gEgo setCycle: 0 view: 814 setLoop: (gEgo loop:))
				(= cycles 3)
			)
			(2
				(gEgo
					view: 802
					setCycle: Walk
					setMotion: MoveTo (register swimX:) (register swimY:) self
				)
			)
			(3
				(gCurRoom newRoom: (register newRoom:))
			)
		)
	)
)

(instance exitApartment of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gEgo
					setCycle: 0
					view: 802
					setCycle: Walk
					setLoop: 0
					show:
					ignoreHorizon:
					setPri: (register egoPri:)
					posn: (register swimX:) (register swimY:)
				)
				(= cycles 3)
			)
			(2
				(gEgo
					setMotion:
						MoveTo
						(register approachX:)
						(register approachY:)
						self
				)
			)
			(3
				(if
					(and
						(!= (register bitValue:) -32768)
						(not (register IamHome:))
						(not (& global119 (register bitValue:)))
					)
					(|= global119 (register bitValue:))
					(Narrator init: 4 0 0 (register lightMsg:) self)
				else
					(= cycles 1)
				)
			)
			(4
				(NormalEgo 0)
				(gEgo setPri: 6)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance gregExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gregarious
					view: (if (IsFlag 299) 253 else 244)
					loop: 0
					cel: 0
					posn: 168 97
					cycleSpeed: 12
					init:
					setCycle: End self
				)
			)
			(1
				(gregarious
					view: (if (IsFlag 299) 252 else 231)
					loop: 0
					cel: 0
				)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance gregEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gregarious
					view: (if (IsFlag 299) 253 else 244)
					loop: 0
					cel: 1
					posn: 168 97
					cycleSpeed: 15
					init:
					setCycle: Beg self
				)
			)
			(1
				(gregarious dispose:)
				(= cycles 2)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cantLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(and
						(== ((Inv at: 10) owner:) 335) ; bikeCage
						(== (gEgo edgeHit:) EDGE_TOP)
					)
					(Narrator init: 4 0 0 18 self) ; "Adam has already fixed the propellers on the fisherman's speedboat. He doesn't need to swim up to the boat again."
				else
					(Narrator init: 4 0 0 6 self) ; "The ocean is a huge place. Adam better stay close to the city until he has a guide to show him the way."
				)
			)
			(1
				(if (== (gEgo edgeHit:) EDGE_TOP)
					(gEgo setMotion: MoveTo (gEgo x:) 26 self)
				else
					(gEgo setMotion: MoveTo 25 (gEgo y:) self)
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance swimThru of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(gregarious
					view: 244
					loop: 0
					cel: 0
					posn: 168 97
					yStep: 4
					cycleSpeed: 8
					illegalBits: 0
					ignoreActors: 1
					setCycle: End self
					init:
				)
			)
			(2
				(gEgo
					posn: 100 113
					setPri: 1
					illegalBits: 0
					setCycle: Walk
					init:
				)
				(gregarious view: 231 cel: 0 posn: 168 99 setPri: 4)
				(= cycles 5)
			)
			(3
				(gregarious
					view: 231
					cel: 0
					posn: 170 94
					setCycle: Walk
					setMotion: MoveTo 145 -30
				)
				(= seconds 2)
			)
			(4
				(Narrator init: 4 0 0 16 self) ; "Adam follows Gregarious as he leads the way up out of the city, towards the ocean's surface."
			)
			(5
				(gEgo show: setMotion: MoveTo 174 104 self)
			)
			(6
				(gEgo setPri: 6 setMotion: MoveTo 183 -23 self)
			)
			(7
				(HandsOn)
				(gCurRoom newRoom: 341)
			)
		)
	)
)

(instance goToCouncilChambers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== gPrevRoomNum 226)
					(gEgo show: posn: -20 25 setMotion: MoveTo 50 30 self)
				else
					(gregarious view: 252 loop: 0 cel: 0 posn: 168 97 init:)
					(gEgo
						posn: 160 -23
						setHeading: 180
						setPri: 6
						show:
						setMotion: MoveTo 160 40 self
					)
				)
			)
			(1
				((gregariousA light:) loop: 8 setCycle: 0)
				(= seconds 3)
			)
			(2
				(if (== gPrevRoomNum 226)
					(gregarious setScript: gregExit self)
				else
					(= cycles 1)
				)
			)
			(3
				(if (== gPrevRoomNum 226)
					(gregarious setHeading: 270 self)
				else
					(gregarious setHeading: 0 self)
				)
			)
			(4
				(Gregarious init: 1 0 0 1 1 self) ; "Wulp, all a the citizens 'r gone now. I'm off ta the Council Chambers for the meetin'. See ya there <a-hyuh>!"
			)
			(5
				(gregarious
					setPri: 4
					ignoreActors: 1
					setCycle: Walk
					setMotion: PolyPath 296 138 self
				)
			)
			(6
				(gregarious setMotion: PolyPath 345 140 self)
				(gEgo setMotion: PolyPath 345 140 self)
			)
			(7
				(HandsOn)
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance talkIntoApt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 2 0 0 20 1 self) ; Adam, "Hello! Anybody home?"
			)
			(1
				(Narrator init: 4 0 0 86 self) ; "The inhabitant of that apartment must be too scared to come out because there is no reply."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance fallIntoNarcisApt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 158 87 self)
			)
			(1
				(gEgo setCycle: 0 setHeading: 280 self)
			)
			(2
				(gEgo
					setCycle: 0
					view: 201
					loop: 0
					cel: 0
					x: 125
					y: 85
					setCycle: End self
				)
			)
			(3
				(Narrator init: 4 0 0 17 self) ; "Adam pushes gently on the panicked blowfish, hoping to help him get back into his apartment."
			)
			(4
				(narci dispose:)
				(gEgo
					view: 201
					loop: 1
					cel: 0
					x: 102
					y: 80
					cycleSpeed: 10
					setCycle: ForwardCounter 3 self
				)
			)
			(5
				(SetScore 5 279)
				(gEgo
					view: 201
					loop: 2
					cel: 0
					x: 102
					y: 80
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(6
				(gEgo hide:)
				(= cycles 2)
			)
			(7
				(HandsOn)
				(gCurRoom newRoom: 221)
			)
		)
	)
)

(instance manateeDone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gregarious view: 252 loop: 0 cel: 0 posn: 168 97 init:)
				(gEgo
					show:
					posn: 160 -20
					setPri: 6
					setMotion: MoveTo 160 40 self
				)
			)
			(1
				(= cycles 10)
			)
			(2
				(Gregarious init: 1 0 0 10 1 self) ; "Thank ya, Adam! Now I can breathe any time I want to!"
			)
			(3
				((ScriptID 2 1) init: 2 0 0 15 1 self) ; Adam, "Will you go to the Mayor's meeting at the Council Chambers now?"
			)
			(4
				(if (gEgo has: 17) ; spine
					(= state 7)
				)
				(= cycles 1)
			)
			(5
				(Gregarious init: 1 0 0 11 1 self) ; "Wulp, I'll have ta wait 'til everyone's outta the 'partments. I AM the watchman, ya know. But I'll go 'long soon as I can."
			)
			(6
				((ScriptID 2 1) init: 2 0 0 16 1 self) ; Adam, "Okay. Bye."
			)
			(7
				(= state 9)
				(= cycles 1)
			)
			(8
				(Gregarious init: 1 0 0 22 self) ; "Wull, looks like everybody's gone, don' it? Just lemme get ma light."
			)
			(9
				(Gregarious init: 1 0 0 23 self) ; "Okay, Adam. I'll meet ya over there <a-hyuh>."
			)
			(10
				(gregarious
					view: 253
					loop: 0
					cel: 1
					posn: 168 97
					cycleSpeed: 12
					setCycle: Beg self
				)
			)
			(11
				(gregarious dispose:)
				(NormalEgo)
				(gEgo illegalBits: 0 setPri: 6 ignoreHorizon:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getPump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 41 129 self)
			)
			(1
				(= cycles 15)
			)
			(2
				(gEgo
					setCycle: 0
					view: 200
					loop: 6
					cel: 0
					posn: 42 141
					cycleSpeed: 12
					setCycle: CT 5 1 self
				)
			)
			(3
				(gEgo get: 16) ; waterPump
				(SetScore 2 276)
				(ClearFlag 46)
				(pump dispose:)
				(gEgo
					view: 200
					loop: 6
					cel: 6
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(Narrator init: 4 0 0 71 self) ; "Adam snags the still-functional water pump."
			)
			(5
				(NormalEgo)
				(gEgo posn: 68 131 setPri: 6 illegalBits: 0 ignoreHorizon:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getWetRag of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 187 101 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo
					setCycle: 0
					view: 181
					loop: 4
					cel: 0
					posn: 189 121
					setPri: 15
					cycleSpeed: 10
					setCycle: CT 7 1 self
				)
			)
			(3
				(wetRag hide:)
				(gEgo setCycle: End self)
				(SetScore 2 275)
			)
			(4
				(= global232 3)
				(gEgo get: 4) ; rag
				(NormalEgo)
				(gEgo
					illegalBits: 0
					setPri: 6
					ignoreHorizon:
					posn: 186 128
					setHeading: 180 self
				)
			)
			(5
				(Narrator init: 4 0 0 78 self) ; "Adam picks up the cotton cloth and carries it with him."
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance acceptStarfish of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 202 99 self)
			)
			(1
				(gregarious
					view: 248
					loop: 1
					cel: 0
					posn: 167 95
					setCycle: CT 2 1
				)
				(gEgo
					view: 248
					loop: 0
					cel: 0
					posn: 196 87
					setCycle: End self
				)
			)
			(2
				(SetScore 5 278)
				(gEgo put: 20 200) ; starFish
				(NormalEgo)
				(gEgo posn: 200 88)
				(= cycles 4)
			)
			(3
				(gregarious setCycle: End self)
			)
			(4
				(gregarious view: 231 loop: 4 cel: 0 posn: 167 95)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance gregTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 4 0 0 72 self) ; "Adam makes small talk with the manatee..."
			)
			(1
				(= local2 (* (Random 6 9) 2))
				(Gregarious init: 1 0 0 local2 0 self)
			)
			(2
				(Gregarious init: 1 0 0 (+ local2 1) 1 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance otherThanStarfish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 2 0 0 22 1 self) ; Adam, "Will this do as a pass?"
			)
			(1
				(Gregarious init: 1 0 0 21 1 self) ; "That's not a pass. Nope. No can do."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookAtGreg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 4 0 0 14 self) ; "Gregarious the manatee is a mammal. Manatees swim in warm water and breathe air at the ocean's surface. Gregarious is the watchman for the Fish Apartments."
			)
			(1
				(Narrator init: 4 0 0 87 self) ; "The manatee looks a little odd. He's turned bright blue and is covered with bandages."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance angelFishA of Apartment
	(properties
		onMeCheck 2
		approachX 72
		approachY 95
		BelongsTo 1
		bitValue 16
		lightX 3
		lightY 90
		lightMsg 56
		swimX -30
		swimY 98
		egoPri 3
		newRoom 222
	)

	(method (init)
		(if (== ((Inv at: 13) owner:) 222) ; sharpShell
			(= IamHome 1)
		)
		(super init: porchLight &rest)
	)
)

(instance emptyNestA3 of Apartment
	(properties
		onMeCheck 4
		approachX 136
		approachY 125
		BelongsTo 8
		bitValue -32768
		swimX 38
		swimY 116
		egoPri 2
		newRoom 220
	)

	(method (init)
		(super init: 0 &rest)
	)
)

(instance gregariousA of Apartment
	(properties
		onMeCheck 8
		BelongsTo 3
		bitValue -32768
		lightX 166
		lightY 93
		swimX 102
		swimY 106
		egoPri 1
		newRoom 225
	)

	(method (init)
		(if (== ((Inv at: 19) owner:) 160) ; goldMask
			(= IamHome 1)
		)
		(if (!= ((Inv at: 20) owner:) 200) ; starFish
			(= approachX 200)
			(= approachY 88)
		else
			(= approachX 186)
			(= approachY 109)
		)
		(super init: porchLight &rest)
		(light setPri: 1)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 60)
					(Narrator init: 4 0 0 98) ; "Gregarious' apartment light is out now that he's left for the council chamber."
				else
					(Narrator init: 4 0 0 11) ; "The central door leads to the apartment where the watchman, Gregarious, lives."
				)
			)
			(3 ; Do
				(if (!= ((Inv at: 20) owner:) 200) ; starFish
					(if (gCast contains: (ScriptID 200 7)) ; gregarious
						(Narrator init: 4 0 0 95) ; "Gregarious is swimming right there. Try doing that on him."
					else
						(gCurRoom setScript: (ScriptID 202 0)) ; gregComeOut
					)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(4 ; Inventory
				(cond
					(
						(and
							(!= ((Inv at: 20) owner:) 200) ; starFish
							(not (gCast contains: (ScriptID 200 7))) ; gregarious
						)
						(if (IsFlag 39)
							(Narrator init: 4 0 0 92) ; "If Adam wants to give something to the Fish Apartment watchman, perhaps he should call him out first."
						else
							(Narrator init: 4 0 0 93) ; "Adam will have to meet the citizen living in that apartment before he can give him or her anything."
						)
					)
					((gCast contains: (ScriptID 200 7)) ; gregarious
						(Narrator init: 4 0 0 95) ; "Gregarious is swimming right there. Try doing that on him."
					)
					((IsFlag 43)
						(Narrator init: 4 0 0 89) ; "Just go right in."
					)
					((SetFlag 60)
						(Narrator init: 4 0 0 98) ; "Gregarious' apartment light is out now that he's left for the council chamber."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(5 ; Talk
				(cond
					((!= ((Inv at: 20) owner:) 200) ; starFish
						(if (gCast contains: (ScriptID 200 7)) ; gregarious
							(Narrator init: 4 0 0 95) ; "Gregarious is swimming right there. Try doing that on him."
						else
							((ScriptID 202 0) start: -1) ; gregComeOut
							(gCurRoom setScript: (ScriptID 202 0)) ; gregComeOut
							((ScriptID 2 1) init: 2 0 0 20 1 (ScriptID 202 0)) ; Adam, "Hello! Anybody home?", gregComeOut
						)
					)
					((not (gEgo has: 33)) ; scroll
						(Narrator init: 4 0 0 89) ; "Just go right in."
					)
					(else
						(Narrator init: 4 0 0 98) ; "Gregarious' apartment light is out now that he's left for the council chamber."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance emptyA1 of Apartment
	(properties
		onMeCheck 16
		approachX 255
		approachY 104
		BelongsTo 2
		bitValue -32768
		swimX 170
		swimY 97
		newRoom 220
	)

	(method (init)
		(super init: 0 &rest)
	)
)

(instance swordFishA of Apartment
	(properties
		onMeCheck 32
		approachX 209
		approachY 59
		BelongsTo 5
		bitValue 8
		lightX 183
		lightY 43
		lightMsg 55
		swimX 108
		swimY 59
		egoPri 1
		newRoom 223
	)

	(method (init)
		(if (== ((Inv at: 14) owner:) 223) ; tweezers
			(= IamHome 1)
		)
		(super init: porchLight &rest)
		(light setPri: 1)
	)
)

(instance blowFishA of Apartment
	(properties
		onMeCheck 64
		approachX 138
		approachY 71
		BelongsTo 6
		bitValue 1
		lightX 68
		lightY 64
		lightMsg 52
		swimX 41
		swimY 68
		egoPri 2
		newRoom 221
	)

	(method (init)
		(if (== ((Inv at: 15) owner:) 221) ; urchins
			(= IamHome 1)
		)
		(super init: porchLight &rest)
	)

	(method (doVerb theVerb)
		(if (IsFlag 47)
			(narci doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lionFishA of Apartment
	(properties
		onMeCheck 128
		approachX 64
		approachY 35
		BelongsTo 7
		bitValue 2
		lightX 34
		lightY 15
		lightMsg 53
		swimX -52
		swimY 31
		egoPri 4
		newRoom 226
	)

	(method (init)
		(if (== ((Inv at: 17) owner:) 226) ; spine
			(= IamHome 1)
		)
		(super init: porchLight &rest)
	)
)

(instance emptyNestA2 of Apartment
	(properties
		onMeCheck 256
		approachX 116
		approachY 37
		BelongsTo 4
		bitValue -32768
		swimX 19
		swimY 34
		egoPri 3
		newRoom 220
	)

	(method (init)
		(super init: 0 &rest)
	)
)

(instance seaTurtleA of Apartment
	(properties
		onMeCheck 512
		approachX 165
		approachY 32
		BelongsTo 9
		bitValue 4
		lightX 132
		lightY 19
		lightMsg 54
		swimX 66
		swimY 31
		egoPri 2
		newRoom 224
	)

	(method (init)
		(if (== ((Inv at: 18) owner:) 224) ; screws
			(= IamHome 1)
		)
		(super init: porchLight &rest)
		(light setPri: 2)
	)
)

(instance columns of Feature
	(properties
		onMeCheck 1024
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 12) ; "Broken Grecian columns lie around the city. It must have been a heck of an earthquake that put Eluria here!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance buildings of Feature
	(properties
		onMeCheck 2048
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 82) ; "Ruins surround Eluria, though they've been long deserted and are of no interest to Adam or the Elurians."
			)
			(3 ; Do
				(Narrator init: 4 0 0 83) ; "Adam has no interest in those ruins. They've been long-since abandoned."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance steps of Feature
	(properties
		onMeCheck 4096
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 45) ; "Steps lead up to the Fish Apartments. Adam wonders what kind of building this was before Eluria sank."
			)
			(3 ; Do
				(Narrator init: 4 0 0 46) ; "There's nothing of interest on that part of the steps."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pipes of Feature
	(properties
		onMeCheck 8192
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 80) ; "These discarded pipes are firmly implanted into the silt, having been here for years and years."
			)
			(3 ; Do
				(Narrator init: 4 0 0 81) ; "Adam doesn't need to get those pipes up. They've been here so long, they're part of the scenery now."
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 81) ; "Adam doesn't need to get those pipes up. They've been here so long, they're part of the scenery now."
			)
			(4 ; Inventory
				(Narrator init: 4 0 0 81) ; "Adam doesn't need to get those pipes up. They've been here so long, they're part of the scenery now."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance moss of Feature
	(properties
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 47) ; "Moss and lichen coat the rocks and ruins of the sunken city."
			)
			(3 ; Do
				(Narrator init: 4 0 0 44) ; "Adam doesn't want to disturb the living plants. His father has taught him never to touch the sea plants lest he destroy them."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance vegatation of Feature
	(properties
		onMeCheck -32768
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 43) ; "Coral, kelp, and other sea plants grow on and around the ruins of the Grecian city that is Eluria."
			)
			(3 ; Do
				(Narrator init: 4 0 0 44) ; "Adam doesn't want to disturb the living plants. His father has taught him never to touch the sea plants lest he destroy them."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant1 of Prop
	(properties
		x 186
		y 125
		lookStr 43
		view 200
		priority 1
		signal 16400
		cycleSpeed 10
		detailLevel 3
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 4 0 0 44) ; "Adam doesn't want to disturb the living plants. His father has taught him never to touch the sea plants lest he destroy them."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant2 of Prop
	(properties
		x 40
		y 69
		lookStr 43
		view 200
		loop 1
		priority 4
		signal 16400
		cycleSpeed 8
		detailLevel 2
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 4 0 0 44) ; "Adam doesn't want to disturb the living plants. His father has taught him never to touch the sea plants lest he destroy them."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant3 of Prop
	(properties
		x 197
		y 54
		lookStr 43
		view 200
		loop 2
		signal 16400
		cycleSpeed 14
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 4 0 0 44) ; "Adam doesn't want to disturb the living plants. His father has taught him never to touch the sea plants lest he destroy them."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance brokenBottle of Garbage
	(properties
		x 221
		y 158
		view 343
		loop 1
		cel 1
		flag 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 63) ; "The fisherman's discarded wine bottle litters the ocean floor. Yuck!"
			)
			(3 ; Do
				(Narrator init: 4 0 0 64) ; "Blech! Adam doesn't want to touch that sticky, gucky, old bottle."
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 65 self) ; "Adam 'Just says no' and trashes the wine bottle."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance candyBox of Garbage
	(properties
		x 265
		y 184
		view 200
		loop 3
		cel 1
		flag 17
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 37) ; "An old, empty, foil-wrapped candy box lies on the ground."
			)
			(3 ; Do
				(Narrator init: 4 0 0 38) ; "Adam might be interested in keeping the candy box if it had something in it. As it is, it's just trash."
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 24 self) ; "Daydreaming of chocolates, Adam throws away the empty candy box."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance shoe of Garbage
	(properties
		x 10
		y 131
		approachX 50
		approachY 126
		view 200
		loop 3
		cel 2
		priority 3
		signal 16400
		flag 18
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 73) ; "An old shoe has been thrown out - perhaps because its odor-eaters expired."
			)
			(3 ; Do
				(Narrator init: 4 0 0 74) ; "That shoe is not Adam's size. Besides, Adam's very careful where he puts his tootsies."
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 75 self) ; "Adam gives the old shoe the ol' boot and trashes it."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tube of Garbage
	(properties
		x 268
		y 142
		view 200
		loop 3
		cel 3
		flag 19
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 29) ; "Someone's thrown an aluminum tube of toothpaste into the sea."
			)
			(3 ; Do
				(Narrator init: 4 0 0 30) ; "Adam brushed before he left home. Besides, who knows where that toothpaste has been?"
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 20 self) ; "Adam squeezes the aluminum toothpaste tube into his garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sock of Garbage
	(properties
		x 205
		y 69
		view 200
		loop 3
		cel 15
		priority 1
		signal 16400
		flag 20
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 33) ; "So THAT'S where socks go when they disappear in the laundry!"
			)
			(3 ; Do
				(Narrator init: 4 0 0 34) ; "Adam doesn't want the old sock - he's got enough socks without mates at home!"
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 22 self) ; "Adam puts the old sock in his garbage bag thinking that it will never find its mate now."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cap of Garbage
	(properties
		x 88
		y 142
		view 200
		loop 3
		cel 5
		flag 21
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 27) ; "A Los Angeles Dodger's baseball cap lies on the ocean floor, discarded by some disgruntled fan."
			)
			(3 ; Do
				(Narrator init: 4 0 0 28) ; "Adam isn't interested in the Dodgers. He's a Giants fan."
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 19 self) ; "Adam stuffs the Dodgers baseball cap into his garbage bag. Good thing he's a Giants fan!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plate of Garbage
	(properties
		x 215
		y 161
		view 200
		loop 3
		cel 6
		flag 22
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 39) ; "Someone thoughtlessly threw an old plate into the sea."
			)
			(3 ; Do
				(Narrator init: 4 0 0 40) ; "Adam has no interest in the old plate. It's cracked and slimy."
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 25 self) ; "Adam cleans up the old plate."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sandwich of Garbage
	(properties
		x 300
		y 137
		view 343
		loop 2
		cel 1
		flag 23
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 66) ; "The fisherman seems partial to sushi sandwiches."
			)
			(3 ; Do
				(Narrator init: 4 0 0 67) ; "It's too late to save those fish."
			)
			(10 ; Recycle
				(ClearFlag 65)
				(Narrator init: 4 0 0 68 self) ; "Adam gives the sushi a decent burial."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance shirt of Garbage
	(properties
		x 168
		y 158
		view 200
		loop 3
		cel 9
		flag 24
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 41) ; "The tattered remains of a man's shirt lies on the ground. Adam wonders who would throw their shirt into the ocean?"
			)
			(3 ; Do
				(Narrator init: 4 0 0 42) ; "The old shirt is too big for Adam even if it weren't throughly ruined by the sea water."
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 26 self) ; "Adam disposes of the yucky old shirt."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance toaster2 of Garbage
	(properties
		x 166
		y 21
		approachX 168
		approachY 42
		view 200
		loop 3
		cel 11
		flag 25
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 31) ; "An old toaster litters the area. Some people will throw ANYTHING away!"
			)
			(3 ; Do
				(Narrator init: 4 0 0 32) ; "Adam isn't interested in old appliances. Perhaps he should just throw it away."
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 21 self) ; "Adam 'burns' the toaster."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance book of Garbage
	(properties
		x 230
		y 133
		view 200
		loop 3
		cel 4
		flag 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 35) ; "Someone carelessly threw out a large novel. Perhaps they couldn't relate to the main character."
			)
			(3 ; Do
				(Narrator init: 4 0 0 36) ; "The book is waterlogged, the ink is running, and it is thoroughly illegible."
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 23 self) ; "Knowledge is a terrible thing to waste, but the book is waterlogged and the ink runny so Adam puts it in his trash bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance gregarious of Actor
	(properties
		x 146
		y 116
		approachX 200
		approachY 88
		yStep 3
		view 231
		loop 2
		priority 5
		signal 24592
		cycleSpeed 10
		illegalBits 0
		xStep 5
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 2 5) ; Inventory, Look, Talk
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(self setScript: lookAtGreg)
			)
			(5 ; Talk
				(self setScript: gregTalk)
			)
			(3 ; Do
				(if (!= ((Inv at: 20) owner:) 200) ; starFish
					(Gregarious init: 1 0 0 20 1) ; "I said gimmie a pass, Adam, not make a pass! <a-hyuh!>"
				)
			)
			(4 ; Inventory
				(switch invItem
					(20 ; starFish
						(((gCurRoom script:) script:) caller: 0)
						((gCurRoom script:)
							setScript: (ScriptID 202 1) (gCurRoom script:) ; getStarFish
						)
					)
					(else
						(gCurRoom setScript: otherThanStarfish)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance narci of Actor
	(properties
		x 103
		y 63
		view 223
		signal 16384
		cycleSpeed 15
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 57) ; "The little blowfish is stuck in his own window, too fat to get through and too scared to deflate!"
			)
			(3 ; Do
				(gCurRoom setScript: fallIntoNarcisApt)
			)
			(5 ; Talk
				(Narrator init: 4 0 0 60) ; "Mmmph. Mmmph."
			)
			(4 ; Inventory
				(switch invItem
					(21 ; healingPotion
						(Narrator init: 4 0 0 58) ; "The blowfish isn't sick, he's stuck! The healing potion can't help."
					)
					(12 ; trident
						(Narrator init: 4 0 0 91) ; "Yes, Adam could try to pry the blowfish free, but it's much too dangerous. Perhaps all it would take is a shove in the right direction."
					)
					(else
						(Narrator init: 4 0 0 59) ; "That won't help get the blowfish unstuck!"
					)
				)
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 90) ; "The poor little blowfish is already having enough trouble with garbage!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance pump of View
	(properties
		x 87
		y 157
		approachX 108
		approachY 158
		view 200
		loop 4
		signal 16384
	)

	(method (init)
		(super init:)
		(self approachVerbs: 2 3 4 10) ; Look, Do, Inventory, Recycle
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 69) ; "A waterpump, old but still working, lies on the ocean floor. It must have fallen from the fisherman's boat. Perhaps he got a newer model."
			)
			(3 ; Do
				(gCurRoom setScript: getPump)
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 70) ; "The water pump IS still working. Perhaps throwing it away is a bit rash."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance wetRag of View
	(properties
		x 182
		y 145
		view 181
		loop 3
		priority 1
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4 0 0 76) ; "There's a thick cotton cloth lying on the steps to the Fish Apartments."
			)
			(3 ; Do
				(gCurRoom setScript: getWetRag)
			)
			(10 ; Recycle
				(Narrator init: 4 0 0 77) ; "Adam is ready to throw out the cloth when he sees that it's still quite strong and clean. Perhaps it will come in handy."
			)
			(4 ; Inventory
				(if (== invItem 22) ; hermetShell
					(Narrator init: 4 0 0 79) ; "Good idea. Try picking up the cloth first."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Gregarious of Talker
	(properties
		nsTop 16
		nsLeft 10
		view 240
		viewInPrint 1
		charNum 7
		keepWindow 1
	)

	(method (init)
		(if (== ((Inv at: 10) owner:) 335) ; bikeCage
			(= view 249)
		else
			(= view 240)
		)
		(gBust view: view)
		(gEyes view: view)
		(gMouth view: view)
		(super init: gBust gEyes gMouth &rest)
	)
)

(instance gBust of Prop
	(properties
		view 240
		cel 1
	)
)

(instance gEyes of Prop
	(properties
		nsTop 9
		nsLeft 19
		view 240
		loop 2
		cycleSpeed 30
	)
)

(instance gMouth of Prop
	(properties
		nsTop 12
		nsLeft 14
		view 240
		loop 1
		cycleSpeed 10
	)
)

(instance porchLight of Prop
	(properties
		view 200
		loop 8
		cel 2
		priority 4
		signal 16400
		detailLevel 2
	)

	(method (init)
		(= cel (Random 0 3))
		(= cycleSpeed (Random 4 12))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== loop 8)
					(Narrator init: 4 0 0 62) ; "That apartment's light is off - nobody's home."
				else
					(Narrator init: 4 0 0 61) ; "That apartment's light is on - somebody must be home."
				)
			)
			(3 ; Do
				(if (== loop 8)
					(Narrator init: 4 0 0 10) ; "That apartment's porch light is off. That must mean that nobody's home."
				else
					(Narrator init: 4 0 0 9) ; "That apartment's porch light is on. That must mean that somebody's home."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

