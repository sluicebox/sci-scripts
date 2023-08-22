;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm38 0
)

(local
	local0
)

(instance rm38 of Rm
	(properties
		picture 38
		horizon 85
		north 41
	)

	(method (dispose)
		(= gUseSortedFeatures local0)
		(SetFlag 28)
		(super dispose:)
	)

	(method (init &tmp temp0 temp1)
		(if (== gPrevRoomNum 39)
			(self style: 11)
		else
			(self style: 100)
		)
		(= temp1 (if gNight 32 else 25))
		(if (or (== (gLongSong prevSignal:) -1) (!= (gLongSong number:) temp1))
			(gLongSong stop: number: temp1 loop: -1 priority: 0 play:)
		)
		(super init: &rest)
		(= local0 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(SL enable:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 0 189 0 0 319 0 319 67 302 74 272 113 186 114 197 122 190 132 159 131 106 161 99 172 78 184 94 184 107 181 121 181 127 184 135 187 319 187
					yourself:
				)
		)
		(self
			setFeatures:
				doors
				barrack
				towers
				walls
				walkWay
				theDoor
				castle
				waggon
				chimney
				garden
				mounts
				sky
				water
				crest
				pots
		)
		(doors approachVerbs: 4) ; Do
		(if (not gNight)
			(guard init:)
		)
		(if (== gPrevRoomNum 39)
			(= temp0 (gEgo y:))
			(NormalEgo)
			(gEgo
				cel: (gEgo cel:)
				loop: (gEgo loop:)
				posn: 304 temp0
				init:
			)
		else
			(NormalEgo)
			(gEgo posn: 266 134 init:)
		)
	)

	(method (doit &tmp temp0)
		(if (and (== (gEgo edgeHit:) EDGE_RIGHT) (not (gEgo script:)))
			(gEgo setScript: headEast)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
			)
			(1 ; Look
				(gMessager say: 11 1 0) ; "This is the barracks area. To the north, you see the castle's central keep. To the east, you see the main courtyard and the stables beyond."
			)
			(4 ; Do
				(gMessager say: 11 4 0) ; "The guard would object."
			)
			(52 ; Sleep
				(gEgo setScript: sleepyWhen)
			)
			(78 ; dazzleSpell
				(gMessager say: 11 4) ; "The guard would object."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doors of Feature
	(properties
		x 90
		y 124
		noun 5
		nsTop 95
		nsLeft 51
		nsBottom 153
		nsRight 129
		sightAngle 40
		approachX 91
		approachY 128
		approachDist 41
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance barrack of Feature
	(properties
		noun 1
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance towers of Feature
	(properties
		noun 13
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance walls of Feature
	(properties
		noun 17
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance walkWay of Feature
	(properties
		noun 16
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theDoor of Feature
	(properties
		noun 6
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance castle of Feature
	(properties
		noun 2
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 2 1) ; "The castle's central keep rises above the rear of the courtyard."
			)
			(4 ; Do
				(gMessager say: 2 4) ; "The castle wall feels very solid."
			)
			(81 ; flameDartSpell
				(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waggon of Feature
	(properties
		noun 15
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance chimney of Feature
	(properties
		noun 3
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance garden of Feature
	(properties
		noun 7
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance mounts of Feature
	(properties
		noun 9
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sky of Feature
	(properties
		noun 12
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance water of Feature
	(properties
		noun 14
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance crest of Feature
	(properties
		noun 4
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pots of Feature
	(properties
		noun 10
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance guard of Prop
	(properties
		x 177
		y 125
		noun 8
		approachX 208
		approachY 146
		view 38
		priority 9
		signal 17
	)

	(method (doit)
		(if
			(and
				(< 110 (gEgo y:) 140)
				(< (gEgo x:) 250)
				(!= script guardThreatens)
			)
			(self setScript: guardThreatens)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 8 1) ; "The guard looks like he is either very tired or very lazy."
			)
			(2 ; Talk
				(gMessager say: 8 2) ; "I'm not here to answer your stupid questions. Go talk to Karl the gatekeeper. He talks to anyone about almost anything."
			)
			(20 ; rock
				(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
			)
			(16 ; dagger
				(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
			)
			(12 ; sword
				(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
			)
			(81 ; flameDartSpell
				(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
			)
			(4 ; Do
				(EgoDead 90 91 0 0 503) ; "You hear a guard yell for help. Four guards inside the barracks grab their weapons and overwhelm you. As they drag you into the castle and down into the dungeon, you realize that was not quite the right thing to do."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance guardThreatens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guard startUpd:)
				(= ticks 12)
			)
			(1
				(gEgo setMotion: 0)
				(guard cel: 0 cycleSpeed: 18 setCycle: Fwd)
				(= ticks 100)
			)
			(2
				(gMessager say: 11 0 1 1 self) ; "Go away. This is just the barracks for us guards."
			)
			(3
				(guard cel: 0 ignoreActors: setCycle: End self)
			)
			(4
				(guard cel: 0 stopUpd: setCycle: 0)
				(= ticks 12)
			)
			(5
				(HandsOn)
				(self changeState: 4)
			)
		)
	)
)

(instance headEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (> (gEgo y:) 125)
					(gEgo setMotion: PolyPath 335 (gEgo y:) self)
				else
					(gEgo setMotion: PolyPath 335 (- (gEgo y:) 10) self)
				)
			)
			(1
				(if (> (gEgo y:) 125)
					(gCurRoom newRoom: 39)
				else
					(gCurRoom newRoom: 41)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sleepyWhen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 11 52 0 1 self) ; "You barely get to sleep when the guard on night patrol kicks you out."
			)
			(1
				(if (< 750 gClock 2550)
					(FixTime 21)
				)
				(= ticks 60)
			)
			(2
				(gCurRoom newRoom: 37)
			)
		)
	)
)

