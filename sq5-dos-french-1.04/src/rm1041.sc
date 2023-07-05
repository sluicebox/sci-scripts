;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1041)
(include sci.sh)
(use Main)
(use Talker)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm1041 0
	beaTalker 10
	drooleTalker 12
	floTalker 13
	rogTalker 15
)

(local
	local0 = 1
	local1 = 13
	local2
	[local3 500]
)

(instance rm1041 of Rm
	(properties
		picture 132
		style -32758
	)

	(method (init)
		(LoadMany rsVIEW 715 716)
		(LoadMany rsPIC 136 1)
		(lights1 init:)
		(bea init:)
		(gSq5Music2 number: 654 setLoop: -1 play:)
		(super init:)
		(gCurRoom setScript: sFinale)
	)
)

(instance sFinale of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(gMessager say: 2 0 0 0 self) ; "Congratulations, crew. A job well done."
			)
			(2
				(bea setCycle: End self)
			)
			(3
				(gSq5Music2 number: 709 setLoop: 1 play:)
				(= seconds 1)
			)
			(4
				(bea setCycle: Beg self)
			)
			(5
				(gSq5Music2 number: 163 setLoop: 1 play:)
				(bea dispose:)
				(lights1 dispose:)
				(lights2 dispose:)
				(lights3 dispose:)
				(lights4 dispose:)
				(lights5 dispose:)
				(lights6 dispose:)
				(= cycles 1)
			)
			(6
				(DrawPic 136 100)
				(= seconds 3)
			)
			(7
				(PalVary pvUNINIT)
				(PalVary pvINIT 2100 1)
				(= seconds 5)
			)
			(8
				(= next sClosing)
				(self dispose:)
			)
		)
	)
)

(instance sClosing of Script
	(properties)

	(method (handleEvent event)
		(if (and (or (== state 1) (== state 3)) (& (event type:) $4005)) ; evVERB | evMOUSEKEYBOARD
			(self cue:)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler addToFront: self)
				(gMouseDownHandler addToFront: self)
				(gSq5Music2 fade:)
				(PalVary pvUNINIT)
				(DrawPic 1 -32768)
				(proc0_11)
				(= seconds 3)
			)
			(1
				(Message msgGET 1041 3 0 0 1 @local3) ; "Congratulations! You've vaporized the blobulous personification of the villainous Capt. Quirk saving countless lives from its menace. Fighting back the tremendous urge to plot a course to Disneyland, Roger and his loyal crew make their way back to StarCon."
				(Display @local3 dsCOORD 40 65 dsALIGN alCENTER dsCOLOR 207 dsFONT 1307 dsWIDTH 240)
			)
			(2
				(= seconds 0)
				(DrawPic 1 2)
				(= seconds 2)
			)
			(3
				(Message msgGET 1041 3 0 0 2 @local3) ; "And so ends another chapter in the continuing adventures of Roger Wilco. Stay tuned for future episodes of our courageous custodian and his crew as they continue their quest to... CLEAN UP WHERE OTHERS HAVE GONE BEFORE!"
				(Display @local3 dsCOORD 40 65 dsALIGN alCENTER dsCOLOR 207 dsFONT 1307 dsWIDTH 240)
			)
			(4
				(= seconds 0)
				(DrawPic 1 2)
				(= seconds 2)
			)
			(5
				(Palette palSET_INTENSITY 231 232 0)
				(= ticks 5)
			)
			(6
				(Message msgGET 1041 1 0 0 local0 @local3)
				(Display @local3 dsCOORD 40 65 dsALIGN alCENTER dsCOLOR 231 dsFONT 1307 dsWIDTH 240)
				(= cycles 1)
			)
			(7
				(Palette palSET_INTENSITY 231 232 local2)
				(if (< (+= local2 10) 101)
					(-- state)
				)
				(= ticks 5)
			)
			(8
				(if (== local0 12)
					(sprintLogo init:)
				)
				(= seconds 4)
			)
			(9
				(if (== local0 12)
					(sprintLogo dispose:)
				)
				(Palette palSET_INTENSITY 231 232 local2)
				(if (> (-= local2 10) 0)
					(-- state)
				)
				(= ticks 5)
			)
			(10
				(Display @local3 dsCOORD 40 65 dsALIGN alCENTER dsCOLOR 0 dsFONT 1307 dsWIDTH 240)
				(if (< (++ local0) local1)
					(-= state 6)
				)
				(= seconds 2)
			)
			(11
				(gMessager say: 19 1 0 4 self 0) ; "Thank You for Playing:  |f5|Space Quest 5:  The Next Mutation"
			)
			(12
				(gKeyDownHandler delete: self)
				(gMouseDownHandler delete: self)
				(= gQuit 1)
				(self dispose:)
			)
		)
	)
)

(instance bea of Prop
	(properties
		x 92
		y 39
		view 715
	)
)

(instance lights1 of Prop
	(properties
		x 165
		y 60
		view 715
		loop 8
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
		(lights2 init: setCycle: Fwd)
		(lights3 init: setCycle: Fwd)
		(lights4 init: setCycle: Fwd)
		(lights5 init: setCycle: Fwd)
		(lights6 init: setCycle: Fwd)
	)
)

(instance lights2 of Prop
	(properties
		x 227
		y 20
		view 715
		loop 7
	)
)

(instance lights3 of Prop
	(properties
		x 231
		y 31
		view 715
		loop 5
	)
)

(instance lights4 of Prop
	(properties
		x 232
		y 43
		view 715
		loop 3
	)
)

(instance lights5 of Prop
	(properties
		x 232
		y 45
		view 715
		loop 4
		cel 3
	)
)

(instance lights6 of Prop
	(properties
		x 315
		y 71
		view 715
		loop 6
	)
)

(instance floEyes of Actor ; UNUSED
	(properties
		x 304
		y 89
		view 716
	)
)

(instance drooleMouth of Actor
	(properties
		x 11
		y 10
		view 716
		loop 1
	)
)

(instance rogMouth of Actor
	(properties
		nsTop 30
		nsLeft 12
		view 715
		loop 1
	)
)

(instance beaMouth of Actor
	(properties
		nsTop 17
		nsLeft 31
		view 715
		loop 2
	)
)

(instance beaTalker of Talker
	(properties
		x 80
		y 14
		view 715
		talkWidth 150
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 160 tailY: 37 xOffset: 60 isBottom: 0)
		(super init: 0 0 beaMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance rogTalker of Talker
	(properties
		x 80
		y 14
		view 715
		talkWidth 150
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 160 tailY: 38 xOffset: 60 isBottom: 1)
		(super init: 0 0 rogMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance drooleTalker of Talker
	(properties
		x 18
		y 108
		view 715
		loop 9
		talkWidth 150
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 115 tailY: 122 xOffset: 40 isBottom: 1)
		(super init: 0 0 drooleMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance floTalker of Narrator
	(properties)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 210 tailY: 100 xOffset: -50)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance sprintLogo of View
	(properties
		x 50
		y 80
		view 925
	)
)

