;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3100)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use n098)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm3100 0
	rockTalker 1
)

(instance rm3100 of KQRoom
	(properties
		picture 3100
	)

	(method (init)
		(Load rsSOUND 3000)
		(super init:)
		(SetFlag 21)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 72 0 0 320 0 320 136 206 136 201 118 159 104 107 103 94 90 114 73 111 53 97 55 93 72 66 78
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 136 112 136 59 92 0 88
					yourself:
				)
		)
		(gEgo init: normalize: setScaler: Scaler 100 36 138 55)
		(rockSpirit init:)
		(mySouthExit init:)
		(myWestExit init:)
		(switch gPrevRoomNum
			(3250
				(gEgo posn: 155 200)
				(gCurRoom setScript: enterFromSouth)
			)
			(3050
				(gEgo posn: -10 90)
				(gCurRoom setScript: enterFromWest)
			)
			(else
				(gEgo posn: 155 118)
				(gGame handsOn:)
			)
		)
		(if (and (!= gPrevRoomNum 3050) (!= gPrevRoomNum 3250))
			(gKqMusic1
				number: 3000
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		)
		(gWalkHandler add: self)
		(rockMouth init: setScript: snore)
	)

	(method (handleEvent event)
		(if
			(and
				(== (event message:) $000a)
				(> (sneezeTimer seconds:) 0)
				(not script)
			)
			(event claimed: 1)
			(self setScript: moveVal)
		else
			(super handleEvent: event)
		)
	)

	(method (dispose)
		(sneezeTimer client: 0 delete: dispose:)
		(rockMouth setScript: 0)
		(rockSound stop:)
		(gKqSound1 stop:)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance enterFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 155 125 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitToSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 155 200 self)
			)
			(1
				(gCurRoom newRoom: 3250)
			)
		)
	)
)

(instance enterFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 20 90 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sToWoods of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -20 90 self)
			)
			(1
				(gCurRoom newRoom: 3050)
			)
		)
	)
)

(instance touchRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 3101
					posn: 136 104
					setLoop: 0
					setCel: 0
					setScale: 0
					setCycle: CT 20 1 self
				)
				(= register (gEgo cycleSpeed:))
			)
			(1
				(gMessager say: 1 8 0 0 self) ; "What a very unusual boulder."
			)
			(2
				(gEgo setLoop: 0 setCel: 20 setCycle: Beg self)
			)
			(3
				(gEgo
					posn: 135 107
					normalize: 3
					setScaler: Scaler 100 36 138 55
					cycleSpeed: register
					setHeading: 45 self
				)
			)
			(4
				(gMessager say: 2 8 1 1 self 5200) ; "(THINKS TO HERSELF)Hmm."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance makeRockSnore of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 858)
				(Load 140 3101) ; WAVE
				(gEgo
					setScale: 0
					posn: 136 104
					view: 3101
					setLoop: 0
					setCel: 0
					setCycle: CT 45 1 self
				)
			)
			(1
				(rockSound number: 3101 loop: 1 play:)
				(gKqSound1 number: 858 loop: -1 play:)
				(gEgo setCel: 45 setCycle: End self)
			)
			(2
				(gKqSound1 stop:)
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(rockSound stop:)
				(gEgo
					posn: 135 107
					normalize: 6
					setScaler: Scaler 100 36 138 55
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance snore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rockSound
					number: (if (Random 0 1) 903 else 904)
					setLoop: 1
					play: self
				)
				(rockMouth setCel: 0 cycleSpeed: 15 setCycle: CT 2 1 self)
			)
			(1 0)
			(2
				(rockSound
					number: (if (Random 0 1) 905 else 906)
					setLoop: 1
					play: self
				)
				(rockMouth setCel: 3 cycleSpeed: 15 setCycle: CT 4 1 self)
			)
			(3 0)
			(4
				(= ticks 120)
			)
			(5
				(rockMouth setCel: 4)
				(self changeState: 0)
			)
		)
	)
)

(instance firstWake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rockMouth setScript: 0)
				(Load rsSOUND 858)
				(SetFlag 114)
				(gEgo
					setScale: 0
					posn: 136 104
					view: 3101
					setLoop: 0
					setCel: 0
					setCycle: CT 45 1 self
				)
			)
			(1
				(gEgo setCel: 45 setCycle: End self)
				(rockSound number: 858 setLoop: -1 play:)
			)
			(2
				(rockSound stop:)
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(rockMouth setScript: 0 setLoop: 1 setCel: 0 setCycle: End self)
				(gMessager say: 1 55 1 1 self) ; "Aah...aah...AAH--"
				(gEgo
					posn: 135 107
					normalize: 6
					setScaler: Scaler 100 36 138 55
				)
			)
			(4 0)
			(5
				(sneezeTimer setReal: sneezeTimer 10)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance blowVal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= gTheCursor gNormalCursor)
					(proc98_5 2)
				)
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(Load rsSOUND 824)
				(SetFlag 146)
				(= cycles 4)
			)
			(1
				(rockSound stop:)
				(rockMouth setScript: 0 cel: 4)
				(rockEyes
					init:
					view: 3104
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gMessager say: 1 55 1 2 self) ; "CHOOOOOOOO!"
				(rockSound number: 824 loop: 1 play:)
				(gEgo
					setScale: 0
					view: 3103
					posn: 130 103
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(3 0)
			(4
				(gCurRoom newRoom: 3250)
			)
		)
	)
)

(instance moveVal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rockSound stop:)
				(sneezeTimer seconds: 0 client: 0 delete: dispose:)
				(rockEyes init: setCel: 2 setCycle: Beg self)
			)
			(1
				(gEgo setMotion: MoveTo 130 115 self)
			)
			(2
				(rockEyes setLoop: 4 setCel: 0 setCycle: End self)
			)
			(3
				(rockEyes setLoop: 3 setCel: 0 setCycle: End)
				(gMessager say: 1 55 1 2 self) ; "CHOOOOOOOO!"
			)
			(4
				(gEgo setHeading: 360 self)
			)
			(5
				(rockTalker hide_mouth: 0)
				(rockEyes setLoop: 4 setCel: 3)
				(gMessager sayRange: 1 55 1 3 6 self) ; "(MEEKLY)Bless you."
			)
			(6
				(rockEyes setLoop: 5 setCel: 0 setCycle: End self)
			)
			(7
				(rockEyes dispose:)
				(rockMouth setLoop: 0 setScript: snore)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rockBlowsVal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc98_5 2)
				(rockMouth setScript: 0)
				(rockSound stop:)
				(gKqSound1 stop:)
				(gEgo setMotion: PolyPath 135 107 self)
			)
			(1
				(gEgo
					setScale: 0
					posn: 136 104
					view: 3101
					setLoop: 0
					setCel: 0
					setCycle: CT 45 1 self
				)
			)
			(2
				(gEgo setCel: 45 setCycle: End self)
				(rockSound number: 858 setLoop: -1 play:)
			)
			(3
				(rockSound stop:)
				(gEgo setLoop: 2 setCel: 0 setCycle: End)
				(rockEyes init: setCel: 2 setCycle: Beg self)
			)
			(4
				(rockEyes setLoop: 4 setCel: 0 setCycle: End self)
				(gMessager say: 1 55 2 1 self) ; "(VERY CRANKY)You again? What do you want?"
			)
			(5 0)
			(6
				(gEgo
					posn: 135 107
					normalize: 6
					setScaler: Scaler 100 36 138 55
				)
				(= cycles 3)
			)
			(7
				(gMessager sayRange: 1 55 2 2 3 self) ; "(NERVOUS)I--I'm not exactly sure..."
			)
			(8
				(rockEyes view: 3104 setLoop: 0 setCel: 0 setCycle: End self)
				(gKqSound1 number: 3104 setLoop: 1 play: self)
			)
			(9
				(Load rsSOUND 824)
				0
			)
			(10
				(rockEyes setLoop: 1 setCel: 0 setCycle: End self)
				(gKqSound1 number: 3105 setLoop: 1 play:)
			)
			(11
				(rockSound number: 824 loop: 1 play:)
				(gEgo
					setScale: 0
					view: 3103
					posn: 135 103
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(12
				(gKqMusic1 fade:)
				(gCurRoom newRoom: 1600)
			)
		)
	)
)

(instance blowFeather of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 858)
				(rockSound stop:)
				(rockMouth setScript: 0)
				(gEgo
					setScale: 0
					posn: 136 104
					view: 3101
					setLoop: 0
					setCel: 0
					setCycle: CT 45 1 self
				)
			)
			(1
				(gEgo setCel: 45 setCycle: End self)
				(gKqSound1 number: 858 setLoop: 1 play:)
			)
			(2
				(rockEyes init: setCel: 2 setCycle: Beg self)
			)
			(3
				(rockEyes setLoop: 4 setCel: 0 setCycle: End self)
				(gMessager say: 1 55 1 1) ; "Aah...aah...AAH--"
			)
			(4
				(rockEyes setLoop: 3 setCel: 0 setCycle: End)
				(gMessager say: 1 55 1 2 self) ; "CHOOOOOOOO!"
				(gEgo view: 3103 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(5
				(gEgo put: 41) ; Feather
			)
			(6
				(gEgo
					posn: 130 106
					normalize: 2
					setScaler: Scaler 100 36 138 55
				)
				(= cycles 2)
			)
			(7
				(gEgo setHeading: 45 self)
			)
			(8
				(gMessager sayRange: 1 55 3 1 2 self) ; "(MILDLY CRANKY)Why have you disturbed my slumber, mortal?"
			)
			(9
				(gMessager say: 1 55 4 3 self) ; "(WIDE AWAKE)That could not have happened if the river of life still flowed, and the Cornucopia was filled. They are the heart and lifeblood of the woods...and it will perish without them!"
			)
			(10
				(gMessager sayRange: 1 55 4 4 5 self) ; "You must start the river flowing by pouring sacred drink into the River Maiden's pitcher."
			)
			(11
				(rockEyes dispose:)
				(rockMouth setScript: snore)
				(rockSpirit setHotspot: 0)
				(SetFlag 136)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance blowFeatherMad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 858)
				(rockSound stop:)
				(rockMouth setScript: 0)
				(gEgo
					setScale: 0
					posn: 136 104
					view: 3101
					setLoop: 0
					setCel: 0
					setCycle: CT 45 1 self
				)
			)
			(1
				(gEgo setCel: 45 setCycle: End self)
				(gKqSound1 number: 858 setLoop: 1 play:)
			)
			(2
				(rockEyes init: setCel: 2 setCycle: Beg self)
			)
			(3
				(rockEyes setLoop: 4 setCel: 0 setCycle: End self)
				(gMessager say: 1 55 1 1) ; "Aah...aah...AAH--"
			)
			(4
				(rockEyes setLoop: 3 setCel: 0 setCycle: End)
				(gMessager say: 1 55 1 2 self) ; "CHOOOOOOOO!"
				(gEgo view: 3103 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(5
				(gEgo put: 41) ; Feather
			)
			(6
				(gEgo
					posn: 135 107
					normalize: 6
					setScaler: Scaler 100 36 138 55
				)
				(= cycles 6)
			)
			(7
				(gMessager sayRange: 1 55 4 1 2 self) ; "(VERY CRANKY)Did I not give you fair warning? Now you must face my wrath!"
			)
			(8
				(gMessager say: 1 55 4 3 self) ; "(WIDE AWAKE)That could not have happened if the river of life still flowed, and the Cornucopia was filled. They are the heart and lifeblood of the woods...and it will perish without them!"
			)
			(9
				(gMessager sayRange: 1 55 4 4 5 self) ; "You must start the river flowing by pouring sacred drink into the River Maiden's pitcher."
			)
			(10
				(rockEyes dispose:)
				(rockMouth setScript: snore)
				(rockSpirit setHotspot: 0)
				(if (gEgo has: 41) ; Feather
					(gEgo put: 41) ; Feather
				)
				(SetFlag 136)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rockMouth of Prop
	(properties
		x 155
		y 60
		view 3100
	)

	(method (init)
		(if (== gValOrRoz -3) ; Roz
			(= view 3105)
		)
		(super init:)
		(self setPri: 95 setScript: snore)
	)
)

(instance rockEyes of Prop
	(properties
		x 155
		y 60
		view 3100
		loop 5
	)

	(method (init)
		(if (== gValOrRoz -3) ; Roz
			(= view 3105)
		)
		(super init:)
		(self setPri: 95)
	)
)

(instance rockSpirit of Feature
	(properties
		noun 1
		approachX 127
		approachY 107
		x 130
		y 61
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 171 43 134 52 143 69 182 73 182 59
					yourself:
				)
		)
		(if (and (not (IsFlag 136)) (== gValOrRoz -4)) ; Val
			(if (not (IsFlag 136))
				(self setHotspot: 8 10 55 approachVerbs: 8 10 55) ; Do, Exit, Feather, Do, Exit, Feather
			else
				(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
			)
			(if (and (> global334 0) (not (IsFlag 136)))
				(self setHotspot: 0 55) ; Feather
			)
		)
	)

	(method (doVerb theVerb)
		(if (> (sneezeTimer seconds:) 0)
			(sneezeTimer seconds: 0 client: 0 delete: dispose:)
			(gCurRoom setScript: blowVal)
		else
			(switch theVerb
				(8 ; Do
					(self setHotspot: 0 55) ; Feather
					(gCurRoom setScript: touchRock)
				)
				(55 ; Feather
					(if (== (rockMouth loop:) 1)
						0
					else
						(switch global334
							(0
								(if (IsFlag 112)
									(gCurRoom setScript: blowFeather)
								else
									(gCurRoom setScript: firstWake)
								)
							)
							(else
								(if (IsFlag 112)
									(gCurRoom setScript: blowFeatherMad)
								else
									(gCurRoom setScript: rockBlowsVal)
								)
							)
						)
						(if (< global334 1)
							(++ global334)
						)
					)
				)
			)
		)
	)
)

(instance mySouthExit of ExitFeature
	(properties
		nsLeft 90
		nsTop 132
		nsRight 250
		nsBottom 136
		sightAngle 360
		approachX 155
		approachY 133
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 setHotspot: 10 10) ; Exit, Exit, Exit
	)

	(method (doVerb)
		(gCurRoom setScript: exitToSouth)
	)
)

(instance myWestExit of ExitFeature
	(properties
		nsTop 70
		nsRight 10
		nsBottom 100
		sightAngle 360
		approachY 110
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 setHotspot: 10 10) ; Exit, Exit, Exit
	)

	(method (doVerb)
		(gCurRoom setScript: sToWoods)
	)
)

(instance sneezeTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: blowVal)
	)
)

(instance rockSound of Sound
	(properties)
)

(instance rockTalker of KQTalker
	(properties
		loop 20
		clientCel -1
	)

	(method (init)
		(= client rockMouth)
		(super init: &rest)
	)
)

