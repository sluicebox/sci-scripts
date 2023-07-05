;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 135)
(include sci.sh)
(use Main)
(use starCon)
(use SpeakWindow)
(use Talker)
(use Osc)
(use RandCycle)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm135 0
	smartTalker 1
	dumbTalker 2
	rogerTalker 15
)

(local
	[local0 10] = [3 4 4 2 4 2 4 3 0 0]
	[local10 10] = [2 3 0 4 1 4 1 1 2 4]
	local20
)

(instance rm135 of Rm
	(properties
		noun 11
		picture 22
		style -32758
	)

	(method (init)
		(self setRegions: 109) ; starCon
		(LoadMany rsVIEW 120 121 122 123 124 128)
		(LoadMany rsMESSAGE 135)
		(gGame handsOff:)
		(SetFlag 1)
		(SetScore 160 5)
		(gEgo view: 121)
		(blobBody init: setOnMeCheck: 1 2)
		(blueGuyBody init: setOnMeCheck: 1 4)
		(dumbCadetBody init: setOnMeCheck: 1 8)
		(greenGirlBody init: setOnMeCheck: 1 16)
		(klingonBody init: setOnMeCheck: 1 32)
		(ramBody init: setOnMeCheck: 1 64)
		(smartCadetBody init: setOnMeCheck: 1 128)
		(rogDesk init: setOnMeCheck: 1 16384)
		(smartCadetDesk init: setOnMeCheck: 1 8192)
		(dumbCadetDesk init: setOnMeCheck: 1 -32768)
		(classDoor init: setOnMeCheck: 1 4096)
		(generalDesk init: setOnMeCheck: 1 512)
		(cyclopsEye init: setScript: sCyclopsEye)
		(hornedGuy init: setScript: sHornedGuy)
		(redGuy init:)
		(bubbleHead init:)
		(smartEyes init: setScript: sSmartEyes)
		(smartHand init: setCycle: RandCycle)
		(super init:)
		(switch gPrevRoomNum
			(137
				(if (> global114 9)
					(gCurRoom setScript: sTestOver)
				else
					(cheatDroid
						posn: (Random 20 320) 55
						init:
						setLoop: 0
						setScript: sCheatDroid
					)
					(gCurRoom setScript: sRogTakeTest)
				)
			)
			(else
				(gCurRoom setScript: sTalkToTeach)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance sTalkToTeach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global115 0)
				(= global114 0)
				(gEgo
					view: 120
					setLoop: 0
					setCel: 0
					posn: 96 41
					setPri: 14
					signal: 16400
					setScale: 0
					init:
				)
				(= seconds 1)
			)
			(1
				(gEgo view: 121 setLoop: 0 setCel: 0 posn: 104 49)
				(gSq5Music2 number: 123 setLoop: 1 play: self)
			)
			(2
				(gMessager say: 10 0 0 1 self) ; "Sorry I'm late, professor."
			)
			(3
				(gSq5Music2 number: 1231 setLoop: 1 play: self)
			)
			(4
				(gEgo setLoop: 5 setCel: 0 posn: 104 48)
				(= local20 1)
				(gSq5Music1 number: 6 setLoop: -1 play:)
				(= ticks 10)
			)
			(5
				(gMessager say: 10 0 0 2 self) ; "You, mean the |c4|ULP!|c| StarCon Aptitude Test is today?!"
			)
			(6
				(gSq5Music1 stop:)
				(gEgo setLoop: 0 setCel: 0 posn: 104 49)
				(= local20 0)
				(= cycles 1)
			)
			(7
				(gSq5Music2 number: 1232 setLoop: 1 play: self)
			)
			(8
				(gMessager say: 10 0 0 3 self) ; "Yes sir, I'll get started right away!"
			)
			(9
				(gSq5Music2 number: 1231 setLoop: 1 play: self)
			)
			(10
				(gMessager say: 10 0 0 4 self) ; "What's that? Come talk to you after class? Yes, sir."
			)
			(11
				(gSq5Music1 number: 7 setLoop: -1 play:)
				(gEgo setLoop: 2 setCel: 0 posn: 111 71)
				(blueGuy init: setScript: sBlueGuy)
				(klingon init: setScript: sKlingon)
				(gGame handsOn:)
				(gCurRoom newRoom: 137)
				(self dispose:)
			)
		)
	)
)

(instance sRogTakeTest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 2 setCel: 0 posn: 111 71 init:)
				(rogShiftyEyes setCycle: Osc init:)
				(gGame handsOn:)
				(gTheIconBar disable: 0 4)
				(self dispose:)
			)
		)
	)
)

(instance sLookAtSmart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 161 5)
				(if (< 6 global114 9)
					(cheatAnswer loop: 3)
				else
					(cheatAnswer loop: 2)
				)
				(cheatAnswer posn: 50 30 cel: [local0 global114] init:)
				(cheatQuestion posn: 46 16 cel: global114 init:)
				(= seconds 3)
			)
			(1
				(gSq5Music2 number: 120 setLoop: 1 play: self)
				(cheatAnswer dispose:)
				(cheatQuestion dispose:)
			)
			(2
				(gEgo setScript: sRogTakeTest)
				(= seconds 1)
			)
			(3
				(bubbleHead setCel: 1 posn: 30 40)
				(smartEyes hide:)
				(smartHand hide:)
				(= seconds 2)
			)
			(4
				(bubbleHead setCel: 0 posn: 31 41)
				(smartEyes show:)
				(smartHand show:)
				(cheatDroid setScript: sCheatDroid)
				(gGame handsOn:)
				(gTheIconBar disable: 0 4)
				(self dispose:)
			)
		)
	)
)

(instance sLookAtDumb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< 6 global114 9)
					(cheatAnswer loop: 3)
				else
					(cheatAnswer loop: 2)
				)
				(cheatAnswer posn: 250 30 cel: [local10 global114] init:)
				(cheatQuestion posn: 246 16 cel: global114 init:)
				(= seconds 3)
			)
			(1
				(gSq5Music2 number: 120 setLoop: 1 play: self)
				(cheatAnswer dispose:)
				(cheatQuestion dispose:)
			)
			(2
				(gEgo setScript: sRogTakeTest)
				(= seconds 1)
			)
			(3
				(redGuy setCel: 1 posn: 266 49)
				(= seconds 2)
			)
			(4
				(redGuy setCel: 0 posn: 274 46)
				(cheatDroid setScript: sCheatDroid)
				(gGame handsOn:)
				(gTheIconBar disable: 0 4)
				(self dispose:)
			)
		)
	)
)

(instance sBlueGuy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(blueGuy show:)
				(= seconds (Random 3 6))
			)
			(1
				(blueGuy hide:)
				(= seconds (Random 3 6))
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sSmartEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (* (Random 1 3) 3))
			)
			(1
				(smartEyes setCycle: Osc 1 self)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sHornedGuy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hornedGuy show:)
				(= seconds (Random 1 4))
			)
			(1
				(hornedGuy hide:)
				(= seconds (Random 1 4))
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sKlingon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(klingon show:)
				(= seconds (Random 2 5))
			)
			(1
				(klingon hide:)
				(= seconds (Random 2 5))
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sCyclopsEye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cyclopsEye setCycle: End self)
			)
			(1
				(= seconds (Random 1 3))
			)
			(2
				(cyclopsEye setCycle: Beg self)
			)
			(3
				(= seconds (Random 3 6))
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sCheatDroid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cheatDroid cel: 3)
				(= seconds (Random 2 4))
			)
			(1
				(cheatDroid cel: 4)
				(= ticks 4)
			)
			(2
				(cheatDroid cel: 5)
				(= ticks 4)
			)
			(3
				(cheatDroid cel: 0)
				(= seconds (Random 2 4))
			)
			(4
				(cheatDroid cel: 1)
				(= ticks 4)
			)
			(5
				(cheatDroid cel: 2)
				(= state -1)
				(= ticks 4)
			)
		)
	)
)

(instance sCheatAlert of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(droidAmbient dispose:)
				(cheatDroid xStep: 10)
				(if (> (cheatDroid x:) 160)
					(cheatDroid setMotion: MoveTo 240 (cheatDroid y:) self)
				else
					(cheatDroid setMotion: MoveTo 80 (cheatDroid y:) self)
				)
			)
			(1
				(cond
					((== (cheatDroid cel:) 2)
						(cheatDroid setCel: 1)
						(= cycles 1)
					)
					((> (cheatDroid cel:) 3)
						(cheatDroid setCycle: End self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gSq5Music2 number: 122 setLoop: -1 play:)
				(cheatDroid setLoop: 1 setCel: 0)
				(= ticks 4)
			)
			(3
				(cheatDroid setLoop: 1 setCel: 1)
				(= ticks 4)
			)
			(4
				(alertTop
					posn: (- (cheatDroid x:) 9) (- (cheatDroid y:) 16)
					init:
				)
				(alertEyes
					x: (- (cheatDroid x:) 9)
					y: (- (cheatDroid y:) 6)
					init:
					setCycle: Fwd
				)
				(alertBeacon
					posn: (- (cheatDroid x:) 4) (+ (cheatDroid y:) 10)
					init:
				)
				(alertBeaconLight
					posn: (- (cheatDroid x:) 2) (+ (cheatDroid y:) 15)
					init:
				)
				(alertBottom
					posn: (+ (cheatDroid x:) 2) (+ (cheatDroid y:) 37)
					init:
				)
				(= ticks 4)
			)
			(5
				(alertBeaconLight setCycle: Fwd)
				(alertBeacon setCycle: Fwd)
				(cyclopsEye dispose:)
				(klingon dispose:)
				(blueGuy dispose:)
				(hornedGuy dispose:)
				(= ticks 1)
			)
			(6
				(alertTop hide:)
				(alertBottom hide:)
				(= ticks 2)
			)
			(7
				(if (not (gEgo script:))
					(gEgo setScript: sRogCaught)
				)
				(alertTop show:)
				(alertBottom show:)
				(= ticks 2)
			)
			(8
				(= state 3)
				(= cycles 1)
			)
		)
	)
)

(instance sRogCaught of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rogShiftyEyes hide:)
				(gSq5Music1 number: 8 setLoop: 1 play:)
				(gEgo loop: 5 cel: 1 posn: 113 75)
				(= seconds 3)
			)
			(1
				(gMessager say: 10 0 0 8 self) ; "UH OH! BUSTED!"
			)
			(2
				(gCurRoom newRoom: 195)
				(self dispose:)
			)
		)
	)
)

(instance sTestOver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 fade:)
				(gEgo loop: 0 cel: 0 posn: 104 49 init:)
				(= seconds 3)
			)
			(1
				(gSq5Music1 number: 5 setLoop: -1 play:)
				(gMessager say: 10 0 0 5 self) ; "The test's over already?"
			)
			(2
				(gSq5Music2 number: 123 setLoop: 1 play: self)
			)
			(3
				(if (> global115 4)
					(gMessager say: 10 0 0 6 self) ; "Yes sir, I agree that cleaning the Academy crest is an appropriate punishment for being late to class. I'll get right on it."
				else
					(gMessager say: 10 0 0 7 self) ; "I FAILED?!! OH HEELLLLLLLLLLLLLLLLLLLP!!"
				)
			)
			(4
				(if (> global115 4)
					(starCon setScript: (ScriptID 109 2)) ; sCrestTimer
					(= cycles 2)
				else
					(gCurRoom newRoom: 195)
					(self dispose:)
				)
			)
			(5
				(gCurRoom newRoom: 123)
				(self dispose:)
			)
		)
	)
)

(instance rogShiftyEyes of Prop
	(properties
		x 169
		y 95
		noun 1
		modNum 1
		view 121
		loop 6
		priority 14
		signal 16400
	)
)

(instance hornedGuy of Prop
	(properties
		x 204
		y 50
		noun 9
		view 124
		loop 4
		priority 2
		signal 16
		detailLevel 2
	)
)

(instance blueGuy of Prop
	(properties
		x 162
		y 38
		noun 2
		view 124
		loop 2
		priority 1
		signal 16
		detailLevel 2
	)
)

(instance klingon of Prop
	(properties
		x 98
		y 49
		noun 8
		view 124
		loop 3
		priority 2
		signal 16
		detailLevel 2
	)
)

(instance cyclopsEye of Prop
	(properties
		x 80
		y 77
		noun 1
		view 124
		loop 5
		priority 1
		signal 16
		detailLevel 2
	)
)

(instance redGuy of Prop
	(properties
		x 274
		y 46
		noun 6
		view 124
		priority 6
		signal 16
	)
)

(instance bubbleHead of Prop
	(properties
		x 31
		y 41
		noun 12
		view 123
		priority 6
		signal 16
	)
)

(instance cheatDroid of Actor
	(properties
		x 350
		y 55
		noun 3
		view 122
		priority 4
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== (self cel:) 3)
					(gMessager say: noun 1 2 0 self) ; "Currently, the Proctormatic 9000 is not scanning you... If you're gonna make a move, now is the time."
				else
					(gMessager say: noun 1 1 0 self) ; "A Proctormatic 9000 anti-cheat droid floats malevolently about the classroom, maintaining a vigilant lookout for any student hijinks during the SAT test. Currently the droid is monitoring you with its visual scanners. Best keep your eyes on your own test."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(if
			(and
				(== (cheatDroid mover:) 0)
				(not (== (cheatDroid script:) sCheatAlert))
			)
			(if (> (cheatDroid x:) 300)
				(cheatDroid setMotion: MoveTo 20 55)
			else
				(cheatDroid setMotion: MoveTo 320 55)
			)
		)
		(super doit:)
		(cond
			((== (self cel:) 0)
				(droidAmbient loop: 6 show:)
			)
			((== (self cel:) 3)
				(droidAmbient loop: 7 show:)
			)
			(else
				(droidAmbient hide:)
			)
		)
		(droidAmbient x: (self x:) y: (self y:))
	)

	(method (init)
		(super init:)
		(droidAmbient init: setCycle: Fwd)
		(gSq5Music2 number: 121 setLoop: -1 play:)
	)

	(method (dispose)
		(gSq5Music2 stop:)
		(super dispose:)
	)
)

(instance droidAmbient of Prop
	(properties
		noun 3
		view 122
		loop 6
		priority 4
		signal 16400
	)
)

(instance alertTop of Prop
	(properties
		noun 3
		view 122
		loop 2
		priority 5
		signal 16
	)
)

(instance alertEyes of Prop
	(properties
		noun 3
		view 122
		loop 5
		priority 5
		signal 16
	)
)

(instance alertBeacon of Prop
	(properties
		noun 3
		view 122
		loop 4
		priority 5
		signal 16
	)
)

(instance alertBottom of Prop
	(properties
		noun 3
		view 122
		loop 2
		cel 2
		priority 5
		signal 16
	)
)

(instance alertBeaconLight of Prop
	(properties
		noun 3
		view 122
		loop 3
		priority 6
		signal 16
		cycleSpeed 0
	)
)

(instance smartEyes of Prop
	(properties
		x -3
		y 93
		noun 12
		view 123
		loop 2
		priority 14
		signal 16
		cycleSpeed 20
	)
)

(instance smartHand of Prop
	(properties
		x -10
		y 155
		noun 12
		view 123
		loop 1
		priority 15
		signal 16
		cycleSpeed 15
	)
)

(instance rogMouth of Prop
	(properties
		nsTop 11
		view 121
	)
)

(instance dumbMouth of Prop
	(properties
		nsTop 1
		nsLeft 1
		view 123
		loop 4
	)
)

(instance smartMouth of Prop
	(properties
		nsTop 1
		nsLeft 1
		view 123
		loop 4
	)
)

(instance rogerTalker of Talker
	(properties
		x 104
		view 121
		talkWidth 170
		textX -70
	)

	(method (init)
		(= talkWidth (Localize 250 170 250 170 170))
		(= font gUserFont)
		(= gSystemWindow SpeakWindow)
		(gSystemWindow
			tailX: (Localize 164 164 164 164 124)
			tailY: (Localize 42 46 42 46 46)
			xOffset: (Localize 5 5 5 5 -5)
		)
		(if local20
			(rogMouth loop: 7 nsTop: 13 nsLeft: 42)
			(self loop: 5 cel: 0 y: 46)
		else
			(rogMouth loop: 1 nsTop: 11 nsLeft: 43)
			(self loop: 0 cel: 0 y: 49)
		)
		(super init: 0 0 rogMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance dumbTalker of Talker
	(properties
		x 260
		y 49
		view 123
		loop 3
		talkWidth 130
		textX -100
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow SpeakWindow)
		(gSystemWindow tailX: 260 tailY: 43 xOffset: -45)
		(super init: 0 0 dumbMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance smartTalker of Talker
	(properties
		x 30
		y 49
		view 123
		loop 3
		talkWidth 170
		textX 40
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow SpeakWindow)
		(gSystemWindow tailX: 40 tailY: 43 xOffset: 60)
		(super init: 0 0 smartMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance cheatAnswer of View
	(properties
		x 50
		y 30
		view 128
		loop 2
		priority 15
		signal 16
	)
)

(instance cheatQuestion of View
	(properties
		x 46
		y 16
		view 128
		priority 15
		signal 16
	)
)

(instance rogDesk of Feature
	(properties
		x 157
		y 136
		noun 5
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 137)
			)
			(1 ; Look
				(gCurRoom newRoom: 137)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance smartCadetDesk of Feature
	(properties
		x 12
		y 149
		noun 5
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gGame handsOff:)
				(cheatDroid setScript: 0)
				(rogShiftyEyes hide:)
				(gSq5Music2 number: 120 setLoop: 1 play:)
				(gEgo setLoop: 3 setCel: 0 posn: 107 46)
				(if (not (== (cheatDroid cel:) 3))
					(cheatDroid setScript: sCheatAlert)
				else
					(gCurRoom setScript: sLookAtSmart)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dumbCadetDesk of Feature
	(properties
		x 304
		y 127
		noun 5
		onMeCheck -32768
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gGame handsOff:)
				(cheatDroid setScript: 0)
				(rogShiftyEyes hide:)
				(gSq5Music2 number: 120 setLoop: 1 play:)
				(gEgo setLoop: 4 setCel: 0 posn: 117 61)
				(if (not (== (cheatDroid cel:) 3))
					(cheatDroid setScript: sCheatAlert)
				else
					(gCurRoom setScript: sLookAtDumb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blobBody of Feature
	(properties
		x 4
		y 20
		noun 1
		onMeCheck 2
	)
)

(instance blueGuyBody of Feature
	(properties
		x 4
		y 20
		noun 2
		onMeCheck 4
	)
)

(instance dumbCadetBody of Feature
	(properties
		x 4
		y 20
		noun 6
		onMeCheck 8
	)
)

(instance greenGirlBody of Feature
	(properties
		x 4
		y 20
		noun 7
		onMeCheck 16
	)
)

(instance klingonBody of Feature
	(properties
		x 4
		y 20
		noun 8
		onMeCheck 32
	)
)

(instance ramBody of Feature
	(properties
		x 4
		y 20
		noun 9
		onMeCheck 64
	)
)

(instance smartCadetBody of Feature
	(properties
		x 4
		y 20
		noun 12
		onMeCheck 128
	)
)

(instance classDoor of Feature
	(properties
		x 4
		y 20
		noun 4
		onMeCheck 4096
	)
)

(instance generalDesk of Feature
	(properties
		x 4
		y 20
		noun 5
		onMeCheck 512
	)
)

