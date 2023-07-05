;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use eRS)
(use Garbage)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm120 0
	trident 1
	TridentStatue 2
)

(local
	local0
	local1
	local2
	[local3 17] = [181 38 181 73 171 73 171 48 131 48 131 73 125 73 125 38 0]
	local20
	local21
	[local22 18] = [-1 -1 -16 106 15 16 106 108 135 360 156 4096 8 360 143 -15 157 -32768]
	[local40 12] = [-1 0 0 26 3 -16 26 25 19 340 22 16384]
	[local52 20] = [-1 1 240 34 1 -30 63 -21 63 67 77 8192 -1 106 77 251 119 240 34 -32768]
)

(procedure (localproc_0 param1 param2)
	(= local0 param1)
	(= local1 param2)
)

(class SFeature of Feature
	(properties
		newRoom 0
		decend 0
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: distantSwimmer 0 self)
			)
			(10 ; Recycle
				(Narrator init: 88) ; "Adam can't throw the buildings away!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rm120 of EcoRoom
	(properties
		lookStr 7
		picture 120
		style 7
		horizon 15
		east 140
		south 100
		west 180
	)

	(method (init)
		(if (and (== gPrevRoomNum 160) (gEgo has: 20) (not (IsFlag 5))) ; starFish
			(LoadMany rsVIEW 831 150 121)
		else
			(eel init: stopUpd:)
		)
		(gFeatures
			add:
				FishApartments
				CouncilChambers
				Gardens
				Urns
				TridentStatue
				MidStatue
				Temple
				Olympian
				oldColumns
			eachElementDo: #init
		)
		(if (not (IsFlag 344))
			(gCast
				add: television cart chair beachBall pipe tricycle teddy radio
				eachElementDo: #init
			)
		)
		(if (== gPrevRoomNum 100)
			(= style 10)
		)
		(if (== ((Inv at: 12) owner:) 120) ; trident
			(trident posn: 217 44 init:)
		)
		(super init:)
		(if
			(and
				(IsFlag 6)
				(or
					(!= (gLongSong number:) 120)
					(== (gLongSong prevSignal:) -1)
				)
			)
			(gLongSong number: 120 loop: -1 play:)
		)
		(plant1 setCycle: Fwd init:)
		(gAddToPics add: plant2 plant3)
		(gAddToPics eachElementDo: #init doit:)
		(if (not (IsFlag 61))
			(bikeCage setPri: 3 init:)
		)
		(councilPoly points: @local3 size: 8)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 173 189 173 180 262 141 252 118 252 107 314 107 314 8 6 8 6 66 0 66
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 147 131 183 131 189
					yourself:
				)
				councilPoly
			setRegions: 51 50 ; bubblesRegion, regionFish
		)
		(if (IsFlag 6)
			((ScriptID 50 0) addFish: @local22) ; regionFish
		)
		((ScriptID 50 0) addFish: @local52 @local40) ; regionFish
		(gEgo
			init:
			view: 802
			setLoop: gStopGroop
			illegalBits: 0
			setHeading: 180
			ignoreHorizon:
			setPri: 7
		)
		(if (and (gEgo has: 33) (not (IsFlag 73))) ; scroll
			(NormalDelph)
			(gDelph loop: 6 z: 0 init: posn: 124 139 setPri: 8)
		)
		(HandsOn)
		(switch gPrevRoomNum
			(160
				(gEgo posn: 156 75)
				(if (and (gEgo has: 20) (not (SetFlag 5))) ; starFish
					0
				else
					(localproc_0 148 89)
				)
			)
			(140
				(gEgo posn: 300 60)
				(if (not (IsFlag 45))
					(localproc_0 241 93)
				else
					(ClearFlag 45)
				)
			)
			(180
				(gEgo posn: 0 120 setHeading: 90)
				(localproc_0 40 120)
			)
			(200
				(gEgo posn: 44 21)
				(localproc_0 53 79)
			)
			(else
				(gEgo posn: 169 143 heading: 0 loop: 3)
				(if (IsFlag 6)
					(gEgo posn: 148 211)
					(localproc_0 148 165)
				)
			)
		)
		(if local0
			(self setScript: enterScript 0 (OneOf gPrevRoomNum 200 160 140))
		else
			(switch gPrevRoomNum
				(140
					(self setScript: (ScriptID 122 0)) ; transition
				)
				(160
					(CouncilChambers approachVerbs: 0)
					((gCurRoom obstacles:) delete: councilPoly)
					(= local2 1)
					(self setScript: (ScriptID 123 0)) ; fleshEater
				)
				(else
					(if (not (SetFlag 6))
						(self setScript: (ScriptID 121 0)) ; beginQuest
					)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: lookStr)
				(if (and (not (IsFlag 344)) (not (IsFlag 7)))
					(Narrator store: 106)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (> gHowFast 0)
			(Palette palANIMATE 33 43 7)
		)
		(= temp0 (gEgo onControl: 1))
		(cond
			((or script global115) 0)
			((and (& temp0 $4000) (not (IsFlag 7)))
				(self setScript: dontLeave)
			)
			((and (& temp0 $0100) (not local2))
				(if (and (!= ((Inv at: 20) owner:) 160) (not (IsFlag 7))) ; starFish
					(= local2 1)
					(self setScript: NoQuorum)
				else
					(self setScript: distantSwimmer 0 CouncilChambers)
				)
			)
			((& temp0 $0002)
				(self setScript: distantSwimmer 0 FishApartments)
			)
			((& temp0 $0200)
				(self setScript: distantSwimmer 0 Temple)
			)
			((== ((User alterEgo:) edgeHit:) 1)
				(self setScript: NoneEscortedEgo)
			)
			((& temp0 $1000)
				(gCurRoom newRoom: 180)
			)
			(
				(and
					(not (gEgo script:))
					(not (IsFlag 334))
					(< (-- local21) 0)
				)
				(= local21 600)
				(gEgo setScript: (ScriptID 124 0)) ; toxicWaste
			)
		)
		(if
			(or
				(and
					(!= (gLongSong number:) 120)
					(== (gLongSong prevSignal:) -1)
				)
				(== (gLongSong number:) 420)
			)
			(gLongSong number: 120 loop: -1 play: 50 fade: 127 10 25 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (gDelph script:)
			(gDelph setScript: 0)
		)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if register
					(gEgo
						setCycle: 0
						view: 809
						setLoop: 3
						cel: 0
						setCycle: End self
					)
				)
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(1
				(if register
					(= register 0)
				else
					(= cycles 1)
				)
			)
			(2
				(if (OneOf gPrevRoomNum 200 140 160)
					(NormalEgo 2)
				else
					(NormalEgo)
				)
				(gEgo ignoreHorizon: setPri: 7)
				(= local0 0)
				(= local1 0)
				(if (and (gEgo has: 33) (not (IsFlag 73))) ; scroll
					(= cycles 5)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(3
				(if (not (SetFlag 121))
					((ScriptID 2 0) init: 17 1 self) ; Delphineus, "C'mon, Adam! There's a reef south of the city. Let's head out and see what we can find!"
				else
					((ScriptID 2 0) init: 18 1 self) ; Delphineus, "C'mon, Adam! We've done all we can for the city. We've got to find Cetus and we already know he's not here."
				)
			)
			(4
				(gDelph setScript: timedTalk)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance timedTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				((ScriptID 2 0) init: 17 1 self) ; Delphineus, "C'mon, Adam! There's a reef south of the city. Let's head out and see what we can find!"
				(= state -1)
			)
		)
	)
)

(instance distantSwimmer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setCycle: 0
					view: 809
					setLoop: (register decend:)
					setCycle: End self
					setMotion:
						MoveTo
						(register approachX:)
						(register approachY:)
						self
				)
			)
			(1 0)
			(2
				(gCurRoom newRoom: (register newRoom:))
			)
		)
	)
)

(instance dontLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 0 self)
			)
			(1
				(gDelph
					view: 831
					loop: 2
					cel: 6
					x: 170
					y: -43
					xStep: 12
					yStep: 7
					signal: 24576
					setPri: 6
					init:
				)
				(= cycles 1)
			)
			(2
				(gEgo setHeading: 0)
				(gDelph setCycle: Walk setMotion: MoveTo 170 104 self)
			)
			(3
				((ScriptID 2 0) init: 11 1 self) ; Delphineus, "That way leads to the open sea, Adam. I don't think I should leave the city until things are better here and I don't want you to get lost out there alone."
			)
			(4
				((ScriptID 2 1) init: 6 1 self) ; Adam, "Okay. I'll stay and help you, Del."
			)
			(5
				((ScriptID 2 0) init: 12 1 self) ; Delphineus, "Thanks, Adam. You're a pal."
			)
			(6
				(if (>= (++ local20) 2)
					(if (== ((Inv at: 20) owner:) 160) ; starFish
						((ScriptID 2 0) init: 14 1 self) ; Delphineus, "If you need help, Adam, come see me at the Fish Apartments."
					else
						(= cycles 1)
					)
				else
					(= cycles 2)
				)
			)
			(7
				(gDelph setMotion: MoveTo 170 -43 self)
				(gEgo setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self)
			)
			(8 0)
			(9
				(HandsOn)
				(gDelph dispose:)
				(self dispose:)
			)
		)
	)
)

(instance NoQuorum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(CouncilChambers approachVerbs: 0)
				((gCurRoom obstacles:) delete: councilPoly)
				(gEgo setHeading: 180 self)
			)
			(1
				(NormalDelph)
				(gDelph
					z: 0
					init:
					setPri: 6
					posn: 27 -29
					setMotion: MoveTo 86 75 self
				)
			)
			(2
				(gDelph setHeading: 90 self)
			)
			(3
				(= cycles 10)
			)
			(4
				((ScriptID 2 0) init: 13 1 self) ; Delphineus, "We don't have a enough citizens for the meeting yet, Adam. Why don't you see if you can round up some more?  Try the apartments that still have the lights on."
			)
			(5
				((ScriptID 2 1) init: 7 1 self) ; Adam, "Sure, Del."
			)
			(6
				(gDelph setMotion: MoveTo 108 75 self)
			)
			(7
				(gDelph
					setCycle: 0
					view: 834
					loop: 1
					cel: 0
					posn: 121 71
					setCycle: End self
				)
			)
			(8
				(gDelph dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance NoneEscortedEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator init: 53 self) ; "The ocean is a huge place. Adam had better stick close to the city until he has a guide to go with him."
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gCurRoom horizon:) 5) self
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getCage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 160 95 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(bikeCage dispose:)
				(gEgo
					setCycle: 0
					view: 126
					loop: 1
					cel: 0
					x: 136
					y: 114
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(Narrator init: 23 self) ; "Adam picks up the steel cage, thinking that it might come in handy."
			)
			(4
				(NormalEgo)
				(SetScore 2 254)
				(gEgo ignoreHorizon: get: 10 x: 146 y: 106 setPri: 7) ; bikeCage
				(SetFlag 61)
				(= cycles 1)
			)
			(5
				(gEgo setHeading: 0 self)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance showEel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eel startUpd: cel: 0 setCycle: End self)
			)
			(1
				(eel stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance councilPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance FishApartments of SFeature
	(properties
		onMeCheck 2
		approachX 19
		approachY 14
		lookStr 14
		newRoom 200
		decend 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 14) ; "Off in the distance is a strange building that looks like a honeycomb from here. It must be the Fish Apartments."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance CouncilChambers of SFeature
	(properties
		onMeCheck 260
		approachX 159
		approachY 74
		lookStr 12
		newRoom 160
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 12) ; "There's a round building to the north. It's a 'Tholos', a place where the Greeks held senatorial meetings."
			)
			(3 ; Do
				(if (and (!= ((Inv at: 20) owner:) 160) (not (IsFlag 7))) ; starFish
					(if (not local2)
						(= local2 1)
						(gCurRoom setScript: NoQuorum)
						(self _approachVerbs: 26505)
					else
						(Narrator init: 105) ; "Adam doesn't have a quorum yet."
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Temple of SFeature
	(properties
		onMeCheck 576
		approachX 307
		approachY 49
		lookStr 13
		newRoom 140
		decend 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 13) ; "To Adam's right is the majestic Temple of Poseidon. A feeling of power surrounds the building. There's a beautiful bronze statue in front of the Temple."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Gardens of Feature
	(properties
		onMeCheck 8
		lookStr 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 8) ; "To the left of the Courtyard Adam sees what looks like part of a large animal and traces of vegetation."
			)
			(3 ; Do
				(Narrator init: 9) ; "Just swim over there."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance oldColumns of Feature
	(properties
		y 189
		onMeCheck 5120
		lookStr 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 6) ; "These particular columns are beyond fixing."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance TridentStatue of Feature
	(properties
		x 213
		y 30
		onMeCheck 16
		approachX 213
		approachY 77
	)

	(method (init)
		(super init:)
		(self approachVerbs: 2 3 4) ; Look, Do, Inventory
	)

	(method (doVerb theVerb invItem)
		(if (not global115)
			(switch theVerb
				(2 ; Look
					(= global115 1)
					((ScriptID 125 0) init:) ; INSET
					(Narrator posn: 45 142 init: 25) ; "Adam is swimming in front of a large and impressive bronze statue."
				)
				(3 ; Do
					(= global115 1)
					((ScriptID 125 0) init:) ; INSET
				)
				(4 ; Inventory
					(if (== invItem 11) ; conchShell
						(= global115 1)
						((ScriptID 125 0) init:) ; INSET
						((ScriptID 125 1) doVerb: theVerb invItem &rest) ; Shell
					else
						(= global115 1)
						((ScriptID 125 0) init:) ; INSET
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		else
			((ScriptID 125 0) doVerb: theVerb invItem &rest) ; INSET
		)
	)
)

(instance MidStatue of Feature
	(properties
		onMeCheck 32
		lookStr 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 4) ; "The lady in the statue doesn't need a hand, she needs a head."
			)
			(4 ; Inventory
				(Narrator init: 90) ; "There's nothing Adam needs to do with that statue."
			)
			(10 ; Recycle
				(Narrator init: 90) ; "There's nothing Adam needs to do with that statue."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Olympian of Feature
	(properties
		x 284
		y 136
		onMeCheck 128
		lookStr 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 17) ; "I don't know, that guy doesn't look too eager to give Adam his discus."
			)
			(4 ; Inventory
				(Narrator init: 90) ; "There's nothing Adam needs to do with that statue."
			)
			(10 ; Recycle
				(Narrator init: 90) ; "There's nothing Adam needs to do with that statue."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Urns of Feature
	(properties
		onMeCheck 2048
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 1) ; "The broken fragments of large Grecian urns provide a safe haven for small fish."
			)
			(3 ; Do
				(Narrator init: 2) ; "Adam doesn't see any reason to get inside the giant urns right now."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance trident of View
	(properties
		x 217
		y 44
		sightAngle 360
		lookStr 45
		view 120
		loop 5
		priority 3
		signal 16401
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 approachX: 213 approachY: 77) ; Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if global115
					(super doVerb: theVerb &rest)
				else
					(= global115 1)
					((ScriptID 125 0) init:) ; INSET
					(Narrator init: 25) ; "Adam is swimming in front of a large and impressive bronze statue."
				)
			)
			(3 ; Do
				(if global115
					(if (not (gEgo has: 12)) ; trident
						(gCurRoom setScript: (ScriptID 125 2)) ; getTrident
					else
						(super doVerb: theVerb &rest)
					)
				else
					(CueObj
						state: 0
						cycles: 0
						client: self
						theVerb: 2
						theInvItem: 0
					)
					(gEgo
						setMotion:
							PolyPath
							approachX
							(+ (gEgo z:) approachY)
							CueObj
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant1 of Prop
	(properties
		x 192
		y 189
		onMeCheck 0
		view 120
		loop 1
		priority 14
		signal 16400
		cycleSpeed 15
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 10) ; "Dark green kelp waves in the ocean current."
			)
			(3 ; Do
				(Narrator init: 11) ; "Adam doesn't want to pull a leaf off a living kelp plant."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant2 of PicView
	(properties
		x 291
		y 189
		onMeCheck 0
		view 120
		cel 3
		priority 14
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 10) ; "Dark green kelp waves in the ocean current."
			)
			(3 ; Do
				(Narrator init: 11) ; "Adam doesn't want to pull a leaf off a living kelp plant."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant3 of PicView
	(properties
		x 27
		y 189
		onMeCheck 0
		view 120
		loop 2
		cel 3
		priority 14
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 10) ; "Dark green kelp waves in the ocean current."
			)
			(3 ; Do
				(Narrator init: 11) ; "Adam doesn't want to pull a leaf off a living kelp plant."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bikeCage of View
	(properties
		x 120
		y 135
		lookStr 40
		view 126
		loop 2
		signal 16385
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: getCage)
			)
			(10 ; Recycle
				(Narrator init: 24) ; "Adam thinks about throwing away the steel cage, but it reminds him of the ones his father recommends for boaters. He decides it might be useful."
			)
			(4 ; Inventory
				(Narrator init: 87) ; "Adam doesn't need to do anything with the steel cage except to pick it up."
			)
			(5 ; Talk
				(Narrator init: 87) ; "Adam doesn't need to do anything with the steel cage except to pick it up."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance television of Garbage
	(properties
		x 70
		y 111
		view 120
		loop 4
		cel 9
		priority 3
		signal 16
		flag 27
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 57) ; "Holy HDTV! Some litterbug dumped a boob-tube in the ocean!"
			)
			(3 ; Do
				(Narrator init: 59) ; "Nah! Adam doesn't want to watch that TRASH!"
			)
			(10 ; Recycle
				(Narrator init: 58 self) ; "One of Adam's teachers used to talk about 'trash on TV', but this television is trashy without even being turned on! Adam dumps it in his garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cart of Garbage
	(properties
		x 156
		y 109
		view 120
		loop 3
		cel 3
		priority 3
		signal 16
		flag 28
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 63) ; "An old shopping cart lies rusting in the Courtyard. Adam's heard of shopping carts being stolen from grocery store parking lots, but this is ridiculous!"
			)
			(3 ; Do
				(Narrator init: 64) ; "This isn't exactly the fish department at Krugers! Adam doesn't need the shopping cart, but he might want to clean it up."
			)
			(10 ; Recycle
				(Narrator init: 65 self) ; "Fortunately for Adam the shopping cart is collapsible. Adam stuffs it easily into his garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chair of Garbage
	(properties
		x 251
		y 86
		view 120
		loop 4
		cel 13
		priority 2
		signal 16
		flag 30
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 72) ; "It looks like someone's thrown away a desk chair -- the kind that rolls around on the floor. Adam's dad has one just like it at home. Of course, Dad would never dispose of anything so thoughtlessly."
			)
			(3 ; Do
				(Narrator init: 73) ; "There's not much need to sit down in the ocean. The chair is nothing but an eyesore here."
			)
			(10 ; Recycle
				(Narrator init: 74 self) ; "Adam wheels the desk chair into the twilight zone of his garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance beachBall of Garbage
	(properties
		x 245
		y 133
		view 120
		loop 3
		cel 13
		priority 4
		signal 16
		flag 32
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 66) ; "A deflated beach ball lies discarded in the Courtyard. At least this is one piece of garbage that seems logical here under the ocean!"
			)
			(3 ; Do
				(Narrator init: 67) ; "That ball is long past its beachin' days. Try trashing it."
			)
			(10 ; Recycle
				(Narrator init: 68 self) ; "The sad little beach ball, flat as yesterday's newspaper, sinks slowly into Adam's trash bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pipe of Garbage
	(properties
		x 54
		y 142
		approachX 50
		approachY 116
		view 120
		loop 4
		cel 4
		priority 3
		signal 16
		flag 34
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 81) ; "Since the ancient Greeks didn't have modern plumbing, Adam guesses that the pipe is merely a result of more human littering."
			)
			(3 ; Do
				(Narrator init: 82) ; "No thanks. Adam's plumbing already works fine."
			)
			(10 ; Recycle
				(Narrator init: 83 self) ; "Adam ditches the pipe."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tricycle of Garbage
	(properties
		x 258
		y 143
		view 120
		loop 3
		cel 14
		priority 4
		signal 16
		flag 35
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 69) ; "A really old tricycle, half disintegrated, lies childless and discarded in the Courtyard."
			)
			(3 ; Do
				(Narrator init: 70) ; "That tricycle is hopelessly broken. Besides, Adam rides two-wheelers now."
			)
			(10 ; Recycle
				(Narrator init: 71 self) ; "Adam trashes the three-wheeler."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance teddy of Garbage
	(properties
		x 76
		y 89
		view 120
		loop 4
		cel 2
		priority 3
		signal 16
		flag 36
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 60) ; "That cute, cuddly teddy is about to disintegrate in the salt water. Adam wonders who would throw their teddy bear into the sea?"
			)
			(3 ; Do
				(Narrator init: 61) ; "Adam prefers REAL animals to stuffed ones. Besides, that teddy is soaked to the stuffin' and ready for retirement."
			)
			(10 ; Recycle
				(Narrator init: 62 self) ; "Adam puts the soaked and scraggly-looking bear into his trash bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance radio of Garbage
	(properties
		x 127
		y 102
		view 120
		loop 4
		cel 7
		priority 3
		signal 16400
		flag 38
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 78) ; "That boom box has boomed its last boom."
			)
			(3 ; Do
				(Narrator init: 79) ; "Adam wouldn't mind listening to the local station, KFIN, but that radio is broken."
			)
			(10 ; Recycle
				(Narrator init: 80 self) ; "Adam transmits the radio into his garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance eel of Prop
	(properties
		x 229
		y 163
		lookStr 84
		view 120
		loop 6
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 85) ; "Have you ever heard the term 'slippery as an eel'? That fish is not about to let Adam catch it."
			)
			(2 ; Look
				(if (not script)
					(self setScript: showEel)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(Narrator init: lookStr)
	)
)

