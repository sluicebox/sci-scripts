;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use AnimDialog)
(use Talker)
(use Scaler)
(use Osc)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm620 0
	floTalker 13
	myRogTalker 15
	sUseComm 20
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
)

(instance theMusic3 of Sound
	(properties)
)

(instance theMusic4 of Sound
	(properties)
)

(instance rm620 of Rm
	(properties
		noun 14
		picture 100
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== (gCurRoom curPic:) 101)
					(gMessager say: 5 1 0 0) ; "Whoever used this pod can't be far away..."
				else
					(gMessager say: 14 1 0 0) ; "Huge fungi resembling giant mushrooms proliferate in the warm, moist environment of this planet."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(LoadMany rsMESSAGE number)
		(LoadMany rsVIEW 22 18)
		(= style
			(switch gPrevRoomNum
				(640 12)
				(else -32758)
			)
		)
		(super init:)
		(gEgo edgeHit: 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 142 19 144 47 150 149 181 176 189 319 189 319 123 281 126 258 126 189 126 177 129 227 132 241 143 239 158 232 164 213 168 177 169 118 159 100 153 80 150 49 142 0 132 0 141
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 0 113 50 110 89 113 127 105 104 94 121 91 148 96 198 88 182 77 171 70 154 77 141 80 110 75 95 66 65 69 98 85 83 87 0 73 0 112
					yourself:
				)
		)
		(if (!= global142 0)
			(pod init:)
			(podDoor init: setOnMeCheck: 1 (podDoor onMeCheck:))
			(mist1 init:)
			(mist2 init:)
			(stems init: setOnMeCheck: 1 (stems onMeCheck:))
			(path init: setOnMeCheck: 1 (path onMeCheck:))
			(bigStem init: setOnMeCheck: 1 (bigStem onMeCheck:))
			(chasm init: setOnMeCheck: 1 (chasm onMeCheck:))
			(if (== global142 1)
				(podHeat init:)
			)
		)
		(switch gPrevRoomNum
			(640
				(if (IsFlag 91)
					(self setScript: sEnterHigh)
				else
					(self setScript: sEnterLow)
				)
			)
			(else
				(if (IsFlag 109)
					(gCurRoom setScript: sFromShip)
				else
					(gCurRoom setScript: sNoMask)
				)
			)
		)
	)

	(method (doit)
		(if (not script)
			(cond
				((& (= local3 (gEgo onControl: 1)) $0008)
					(gCurRoom setScript: sExitLow)
				)
				((& local3 $0004)
					(gCurRoom setScript: sExitHigh)
				)
			)
		)
		(super doit:)
	)
)

(instance sYourDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(NormalEgo 553)
				(gEgo
					init:
					setLoop: 9
					cel: 0
					x: 119
					y: 75
					setCycle: End self
				)
			)
			(1
				(theMusic3 number: 260 setLoop: 1 play:)
				(puker1 init: setCycle: End self)
				(puker2 init: setCycle: End self)
				(puker3 init: setCycle: End self)
			)
			(2 0)
			(3 0)
			(4
				(puker1 setLoop: 3 setCel: 0)
				(puker2 setLoop: 1 setCel: 0)
				(puker3 setLoop: 0 setCel: 0)
				(= seconds 2)
			)
			(5
				(gSq5Music1 number: 102 setLoop: 1 play:)
				(theMusic3 number: 32 setLoop: 1 play:)
				(gEgo setLoop: 10 cel: 0 setCycle: End self)
			)
			(6
				(= seconds 1)
			)
			(7
				(gSq5Music1 number: 519 setLoop: 1 play:)
				(thePuke init: setCycle: End self)
			)
			(8
				(gEgo setLoop: 11 cel: 0 setCycle: End self)
			)
			(9
				(= seconds 2)
			)
			(10
				(EgoDead 29) ; "Hmm. Better try that one again, ace."
			)
		)
	)
)

(instance sFromShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music1 number: 30 setLoop: -1 play:)
				(= seconds 4)
			)
			(1
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(slug init:)
				(NormalEgo 22)
				(gEgo init: ignoreActors: 1 posn: 231 132 setCycle: End self)
			)
			(2
				(gEgo setScript: sBreath)
				(if (and (!= global142 0) (not (IsFlag 29)))
					(myBut init: hide:)
					(pod setScript: sBeep)
				)
				(NormalEgo 18)
				(gEgo setHeading: 180)
				(gGame handsOn:)
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				(gGame setCursor: 980)
				(self dispose:)
			)
		)
	)
)

(instance sNoMask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 4)
			)
			(1
				(NormalEgo 6)
				(gEgo
					init:
					ignoreActors: 1
					setScale: Scaler 100 87 181 123
					posn: 231 132
					setCycle: End self
				)
			)
			(2
				(NormalEgo 553 5)
				(gEgo scaleSignal: 0 scaleX: 128 scaleY: 128 setHeading: 180)
				(= seconds 1)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(= seconds 2)
			)
			(5
				(EgoDead 28) ; "Air: It's what's for breathing."
			)
		)
	)
)

(instance sExitLow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 91)
				(gEgo setMotion: MoveTo -30 140 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 640)
			)
		)
	)
)

(instance sExitHigh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 91)
				(gEgo setMotion: MoveTo -20 100 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 640)
			)
		)
	)
)

(instance sEnterHigh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= global142 0) (not (IsFlag 29)))
					(myBut init: hide:)
					(pod setScript: sBeep)
				)
				(NormalEgo 18 0)
				(gEgo
					edgeHit: 0
					init:
					ignoreActors: 1
					setScript: sBreath
					posn: 6 100
					setScale: Scaler 93 71 122 75
					setMotion: MoveTo 75 89 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterLow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= global142 0) (not (IsFlag 29)))
					(myBut init: hide:)
					(pod setScript: sBeep)
				)
				(NormalEgo 18 0)
				(gEgo
					init:
					ignoreActors: 1
					posn: -30 140
					setScale: Scaler 100 87 181 123
					setScript: sBreath
					setMotion: MoveTo 31 140 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLocateTimer of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(if local0
					(self dispose:)
				)
			)
		)
	)
)

(instance sFinishLook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(NormalEgo 18)
				(gEgo setScale: Scaler 93 71 122 75 setHeading: 180)
				(gEgo setScript: sBreath)
				(self dispose:)
			)
		)
	)
)

(instance sMoveSlug of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 10))
			)
			(1
				(slug show:)
				(= seconds 1)
			)
			(2
				(slug setCycle: End self)
			)
			(3
				(slugEyes init: setCycle: Osc 3 self)
			)
			(4
				(slugEyes dispose:)
				(slug setLoop: 4 setCycle: End self)
			)
			(5
				(slug dispose:)
			)
		)
	)
)

(instance sBurnMe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (& $0040 (gEgo onControl: 1))
					(= cycles 1)
				else
					(gEgo setMotion: MoveTo 104 82 self)
				)
			)
			(1
				(gEgo
					scaleSignal: 0
					scaleX: 128
					scaleY: 128
					view: 553
					loop: 3
					cel: 1
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 4 cel: 0 setCycle: End self)
				(gSq5Music1 number: 31 setLoop: 1 play:)
				(theMusic3 number: 102 setLoop: 1 play:)
			)
			(3
				(= seconds 2)
			)
			(4
				(if (< global145 3)
					(++ global145)
				)
				(NormalEgo 18)
				(gEgo setScale: Scaler 93 71 122 75)
				(theMusic3 stop:)
				(gSq5Music1 number: 30 setLoop: -1 play:)
				(gMessager say: 12 4 0 global145 self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUseComm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(IsFlag 104)
				(= local2 (if (or (== global142 0) (IsFlag 104)) 8 else 10))
				(theMusic3 number: 603 setLoop: 1 play:)
				(gEgo view: 553 loop: 8 cel: 0 setCycle: End self)
			)
			(1
				(floTalker normal: 0 keepWindow: 1)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 982)
				(gMessager say: local2 0 4 0 self)
			)
			(3
				(floTalker normal: 1 keepWindow: 0)
				(= local1
					(switch (floTalker whichSelect:)
						(1 1)
						(2 2)
						(3 3)
					)
				)
				(gMessager say: local2 0 local1 0 self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(NormalEgo 18)
				(gEgo setHeading: 180)
				(if (not (and (== local1 1) (== local2 8)))
					(gGame handsOn:)
					(self dispose:)
				else
					(= seconds 1)
				)
			)
			(6
				(gEgo view: 6 setLoop: 0 cel: 15 setCycle: Beg self)
			)
			(7
				(gEgo dispose:)
				(ClearFlag 104)
				(= seconds 2)
			)
			(8
				(gGame handsOn:)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance sPodScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 103 78 self)
			)
			(1
				(gEgo
					scaleSignal: 0
					scaleX: 128
					scaleY: 128
					view: 553
					loop: 6
					cel: 4
					setCycle: End self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(gCast eachElementDo: #hide)
				(gEgo dispose:)
				(gCurRoom drawPic: 101 100)
				(if (and (not (gEgo has: 19)) (not (IsFlag 29))) ; frock
					(frock init:)
				)
				(beltRight init: cycleSpeed: 16 setCycle: Fwd)
				(dashLights init: cycleSpeed: 8 setCycle: Fwd)
				(beltLeft init: cycleSpeed: 17 setCycle: Fwd)
				(gGame handsOn:)
				(= ticks 20)
			)
			(4
				(outside init: setOnMeCheck: 1 (outside onMeCheck:))
			)
			(5
				(gGame handsOff:)
				(if (not (IsFlag 29))
					(= next sYourDead)
				)
				(gCurRoom drawPic: 100 100)
				(gCast eachElementDo: #show)
				(frock dispose:)
				(myBut dispose:)
				(beltRight dispose:)
				(dashLights dispose:)
				(beltLeft dispose:)
				(outside dispose:)
				(= cycles 1)
			)
			(6
				(if (IsFlag 29)
					(gEgo init: setScript: sFinishLook)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance frock of View
	(properties
		x 92
		y 123
		noun 3
		view 565
		loop 4
		signal 20480
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(SetScore 223 10)
				(gEgo get: 19) ; frock
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance myBut of Prop
	(properties
		x 74
		y 140
		noun 1
		view 565
		loop 3
		priority 3
		signal 16
	)

	(method (show)
		(if (== (gCurRoom curPic:) 101)
			(= cel 0)
			(super show:)
		else
			(= cel 0)
		)
	)

	(method (hide)
		(if (== (gCurRoom curPic:) 101)
			(= cel 1)
		else
			(= cel 1)
			(super hide:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(sBeep dispose:)
				(SetScore 224 35)
				(SetFlag 29)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pod of Prop
	(properties
		x 109
		y 69
		z 20
		noun 12
		view 554
		loop 5
		signal 20480
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< (gEgo y:) 120)
					(if (== global142 1)
						(gCurRoom setScript: sBurnMe)
					else
						(gCurRoom setScript: sPodScript)
					)
				else
					(gMessager say: 4 1 0 0) ; "The interior of the craft is not visible from your present location. All you can tell from here is that it looks like an escape pod."
				)
			)
			(1 ; Look
				(gMessager say: 4 1 0 0) ; "The interior of the craft is not visible from your present location. All you can tell from here is that it looks like an escape pod."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance outside of Feature
	(properties
		x 180
		y 130
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(sPodScript cue:)
			)
			(4 ; Do
				(sPodScript cue:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mist1 of Prop
	(properties
		x 177
		y 156
		view 554
		loop 3
		cel 3
		cycleSpeed 15
		detailLevel 3
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance mist2 of Prop
	(properties
		x 92
		y 189
		view 554
		loop 2
		cel 1
		cycleSpeed 15
		detailLevel 3
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance slug of Prop
	(properties
		x 277
		y 139
		noun 16
		view 554
		priority 15
		signal 16
		cycleSpeed 60
	)

	(method (init)
		(super init:)
		(self hide: setScript: sMoveSlug)
	)
)

(instance slugEyes of Prop
	(properties
		x 296
		y 135
		view 554
		loop 1
		cel 1
		priority 15
		signal 16
		cycleSpeed 15
		detailLevel 3
	)
)

(instance puker1 of Actor
	(properties
		x 158
		y 83
		view 561
		loop 9
	)
)

(instance puker2 of Actor
	(properties
		x 84
		y 90
		view 561
		loop 8
	)
)

(instance puker3 of Actor
	(properties
		x 73
		y 72
		view 561
		loop 7
	)
)

(instance podHeat of Prop
	(properties
		x 136
		y 54
		noun 17
		view 553
		cel 1
		signal 20480
		detailLevel 3
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance chasm of Feature
	(properties
		x 124
		y 113
		noun 2
		onMeCheck 256
	)
)

(instance stems of Feature
	(properties
		x 24
		y 57
		noun 18
		onMeCheck 4096
	)
)

(instance bigStem of Feature
	(properties
		x 285
		y 59
		noun 19
		onMeCheck 2048
	)
)

(instance path of Feature
	(properties
		x 79
		y 154
		noun 9
		onMeCheck 8192
	)
)

(instance podDoor of Feature
	(properties
		x 120
		y 155
		z 100
		noun 9
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (< (gEgo y:) 120)
					(gCurRoom setScript: sPodScript)
				else
					(gMessager say: 4 1 0 0) ; "The interior of the craft is not visible from your present location. All you can tell from here is that it looks like an escape pod."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thePuke of Actor
	(properties
		x 124
		y 56
		view 561
		loop 11
		priority 15
		signal 16
	)
)

(instance dashLights of Prop
	(properties
		x 212
		y 41
		noun 11
		view 565
		cel 3
	)
)

(instance beltLeft of Prop
	(properties
		x 123
		y 95
		noun 15
		view 565
		loop 1
		cel 2
		cycleSpeed 15
	)
)

(instance beltRight of Prop
	(properties
		x 209
		y 94
		noun 15
		view 565
		loop 2
		cel 2
		cycleSpeed 20
	)
)

(instance floTalker of ChoiceTalker
	(properties
		x 10
		y 15
		view 1008
		signal 16
		talkWidth 180
		keepWindow 1
		textX 100
		normal 1
	)

	(method (init)
		(= font gUserFont)
		(super init: floBust floEyes floMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance floBust of Prop
	(properties
		view 1008
	)
)

(instance floEyes of Prop
	(properties
		nsTop 33
		nsLeft 39
		view 1008
		loop 2
		signal 16384
	)
)

(instance floMouth of Prop
	(properties
		nsTop 43
		nsLeft 45
		view 1008
		loop 1
		signal 16384
	)
)

(instance sBreath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music2 number: 550 setLoop: 1 play: self)
			)
			(1
				(= state -1)
				(= seconds (Random 2 4))
			)
		)
	)
)

(instance sBeep of Script
	(properties)

	(method (dispose)
		(theMusic4 dispose:)
		(myBut dispose:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gCurRoom curPic:) 101)
					(myBut show:)
				)
				(theMusic4
					number: 124
					setLoop: 1
					play: self
					setVol:
						(Min
							127
							(Max 40 (- 130 (gEgo distanceTo: pod)))
						)
				)
			)
			(1
				(myBut hide:)
				(= state -1)
				(= seconds 2)
			)
		)
	)
)

(instance myRogTalker of Talker
	(properties
		x 10
		y 25
		view 556
		loop 5
		talkWidth 150
		textX 120
		textY 2
	)

	(method (init)
		(= font gUserFont)
		(super init: rogBust 0 rogMouth &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance rogBust of Prop
	(properties
		view 556
	)
)

(instance rogMouth of Prop
	(properties
		nsTop 18
		nsLeft 43
		view 556
		loop 2
	)
)

