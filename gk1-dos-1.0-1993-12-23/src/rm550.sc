;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use Talker)
(use Osc)
(use RandCycle)
(use Cursor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm550 0
)

(local
	local0
	local1
)

(instance rm550 of Room
	(properties
		picture 99
		style 14
		exitStyle 0
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 550)
		(gGame handsOff:)
		(= gNarrator dragonNarrator)
		(= local1 gTheCursor)
		(gGame setCursor: myInvisCursor)
		(gGkMusic1
			number: 550
			setLoop: -1
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(gCurRoom setScript: doTheDream)
		(gTheIconBar disable: erase:)
		(SetFlag 466)
		(SetCursor 0)
	)

	(method (dispose)
		(gGkMusic1 fade:)
		(gTheIconBar enable:)
		(SetCursor 1)
		(= gNarrator GKNarrator)
		(gGame setCursor: local1)
		(DisposeScript 64939)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
		(super dispose:)
	)
)

(instance doTheDream of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dragonNarrator y: 75 x: 90)
				(= seconds 2)
			)
			(1
				(gMessager say: 1 0 2 0 self) ; "That night, Gabriel dreams...."
			)
			(2
				(dragonNarrator y: 160 x: -1)
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 1)
				)
				(= cycles 1)
			)
			(3
				(if (IsFlag 470)
					(self setScript: flopMovie1 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{DRAGON.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {DRAGON.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(4
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 0)
				)
				(= cycles 1)
			)
			(5
				(dragonFace init:)
				(dragonFaceBack init:)
				(= cycles 5)
			)
			(6
				(self setScript: doTheDragonEye)
				(gMessager say: 1 0 1 1 self) ; "(THIS IS A DREAM SEQUENCE. VERY EVIL & DISDAINFUL)Your soul smells, Gabriel Knight. YOU seek to be Schattenj\84ger?"
			)
			(7
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(8
				(doTheDragonEye dispose:)
				(dragonFace dispose:)
				(dragonFaceBack dispose:)
				(egoHead init:)
				(= cycles 1)
			)
			(9
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(10
				(gMessager say: 1 0 1 2 self) ; "(SCARED)I do!"
			)
			(11
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(12
				(egoHead dispose:)
				(dragonEyes init:)
				(leftHand init:)
				(dragonMouth init:)
				(dragonDrool init:)
				(dragonNose init:)
				(rightHand init:)
				(dragonFace_Hands init:)
				(= cycles 1)
			)
			(13
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(14
				(dragonEyes cycleSpeed: 10 setCycle: Osc 1)
				(leftHand cycleSpeed: 20 setCycle: End)
				(dragonMouth cycleSpeed: 10 setCycle: Fwd)
				(dragonDrool cycleSpeed: 13 setCycle: End self)
				(dragonNose cycleSpeed: 11 setCycle: Osc 1)
				(rightHand cycleSpeed: 20 setCycle: End)
				(gGkSound1 number: 551 setLoop: 1 play:)
				(gMessager say: 1 0 1 3 self) ; "You must first burn away the past. How much sin do you have to burn?"
			)
			(15)
			(16
				(dragonDrool dispose:)
				(dragonEyes dispose:)
				(leftHand dispose:)
				(dragonMouth dispose:)
				(dragonNose dispose:)
				(rightHand dispose:)
				(dragonFace_Hands dispose:)
				(= cycles 1)
			)
			(17
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 1)
				)
				(= cycles 1)
			)
			(18
				(if (IsFlag 470)
					(self setScript: flopMovie2 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{FIREWALL.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {FIREWALL.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(19
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 0)
				)
				(= cycles 1)
			)
			(20
				(dragonFaceBack init:)
				(dragonFace init:)
				(self setScript: doDragonExpressions)
				(= cycles 5)
			)
			(21
				(gMessager sayRange: 1 0 1 4 5 self) ; "(EVIL LAUGH)Heh, heh, heh."
			)
			(22
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(23
				(dragonFaceBack dispose:)
				(doDragonExpressions dispose:)
				(dragonFace dispose:)
				(fire init:)
				(fireWall init:)
				(= cycles 1)
			)
			(24
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(25
				(fire setCycle: Fwd)
				(gGkSound1 number: 555 setLoop: -1 play:)
				(gMessager sayRange: 1 0 1 6 8 self) ; "(PROTESTING)NO!"
			)
			(26
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(27
				(gGkSound1 stop:)
				(fire dispose:)
				(fireWall dispose:)
				(egoHead init:)
				(= cycles 1)
			)
			(28
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(29
				(gMessager say: 1 0 1 9 self) ; "(TRYING NOT TO SOUND SCARED)How?"
			)
			(30
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(31
				(egoHead dispose:)
				(dragonEyes init:)
				(leftHand init:)
				(dragonMouth init:)
				(dragonNose init:)
				(rightHand init:)
				(dragonFace_Hands init:)
				(= cycles 1)
			)
			(32
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(33
				(dragonEyes cycleSpeed: 10 setCycle: Osc 1)
				(leftHand cycleSpeed: 20 setCycle: RandCycle)
				(dragonMouth cycleSpeed: 10 setCycle: Fwd)
				(dragonNose cycleSpeed: 11 setCycle: Osc 1)
				(rightHand cycleSpeed: 20 setCycle: RandCycle)
				(gMessager say: 1 0 1 10 self) ; "(EMPHASIS ON FIRST 'I')I cannot show you the path, but I CAN tell you that you will have to let go of the greater part of yourself, Gabriel Knight."
			)
			(34
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(35
				(dragonFace_Hands dispose:)
				(dragonEyes dispose:)
				(leftHand dispose:)
				(dragonMouth dispose:)
				(dragonNose dispose:)
				(rightHand dispose:)
				(egoHead init:)
				(= cycles 1)
			)
			(36
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(37
				(gMessager say: 1 0 1 11 self) ; "(NERVOUS LAUGH)No problem."
			)
			(38
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(39
				(egoHead dispose:)
				(dragonFace init:)
				(dragonFaceBack init:)
				(= cycles 1)
			)
			(40
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(41
				(dragonFace
					setCel: 0
					setLoop: 0
					cycleSpeed: 10
					setCycle: End self
				)
				(gMessager say: 1 0 1 12 self) ; "(I.E. 'YEAH, RIGHT')Yesss. Now, you asked for purification. You shall have it."
			)
			(42)
			(43
				(dragonFace setCel: 0 setLoop: 1 cycleSpeed: 10 setCycle: End)
				(= seconds 5)
			)
			(44
				(dragonFace
					setCel: 0
					setLoop: 2
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(45
				(= seconds 3)
			)
			(46
				(dragonFace
					setCel: 0
					setLoop: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(47
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(48
				(dragonFaceBack dispose:)
				(dragonFace dispose:)
				(egoFace init:)
				(egoHead init:)
				(= cycles 1)
			)
			(49
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(50
				(egoFace cycleSpeed: 20 setCycle: End self)
				(gGkSound1 number: 553 setLoop: 1 play:)
				(gMessager say: 1 0 1 13 self) ; "(RRCC. SCARED, ALARMED)Oh, no!"
			)
			(51)
			(52
				(for ((= local0 0)) (>= local0 100) ((-= local0 2))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(53
				(gGkSound1 stop:)
				(egoHead dispose:)
				(egoFace dispose:)
				(= cycles 1)
			)
			(54
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 1)
				)
				(= cycles 1)
			)
			(55
				(if (IsFlag 470)
					(self setScript: flopMovie3 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{BLAST.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {BLAST.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(56
				(if (IsFlag 470)
					(self setScript: flopMovie4 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{SWORD.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {SWORD.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(57
				(if (IsFlag 470)
					(self setScript: flopMovie5 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{STAB.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {STAB.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(58
				(if (IsFlag 470)
					(self setScript: flopMovie6 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{SHRINK.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {SHRINK.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(59
				(if (IsFlag 470)
					(self setScript: flopMovie7 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{WICKED.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {WICKED.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(60
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 0)
				)
				(Palette 2 0 255 0) ; PalIntensity
				(= cycles 1)
			)
			(61
				(++ gDay)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance doTheDragonEye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dragonFace setCel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(1
				(= seconds 4)
			)
			(2
				(dragonFace setCel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(3
				(= seconds 4)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance doDragonExpressions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dragonFace loop: 0 cel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(1
				(= seconds 3)
			)
			(2
				(dragonFace loop: 1 cel: 0 cycleSpeed: 10 setCycle: End)
				(= seconds 5)
			)
			(3
				(dragonFace loop: 2 cel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(4
				(= seconds 5)
			)
			(5
				(dragonFace loop: 0 cel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(6
				(self changeState: 0)
			)
		)
	)
)

(instance flopMovie1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 930 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 931 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 932 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 933 14)
				(= cycles 2)
			)
			(4
				(gCurRoom drawPic: 934 14)
				(= cycles 2)
			)
			(5
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance flopMovie2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 935 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 936 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance flopMovie3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 937 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 938 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance flopMovie4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 939 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 940 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance flopMovie5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 941 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 942 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 943 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance flopMovie6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 944 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 945 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance flopMovie7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 946 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 947 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 948 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 949 14)
				(= cycles 2)
			)
			(4
				(gCurRoom drawPic: 950 14)
				(= cycles 2)
			)
			(5
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance dragonNarrator of Narrator
	(properties
		y 160
		talkWidth 314
		modeless 2
	)

	(method (init)
		(self back: global214 font: gUserFont)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0)
		(= fore
			(switch global180
				(1 1)
				(62 2)
				(else 7)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)
)

(instance dragonFace of Prop
	(properties
		x 148
		y 68
		view 917
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 10917 else 917)
			posn: (if (IsHiRes) 146 else 148) (if (IsHiRes) 80 else 68)
		)
	)
)

(instance egoFace of Prop
	(properties
		x 153
		y 54
		view 927
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 10927 else 927)
			posn: (if (IsHiRes) 145 else 153) (if (IsHiRes) 74 else 54)
		)
	)
)

(instance dragonEyes of Prop
	(properties
		x 177
		y 68
		view 912
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 10912 else 912)
			posn: (if (IsHiRes) 158 else 177) (if (IsHiRes) 80 else 68)
		)
	)
)

(instance leftHand of Prop
	(properties
		x 226
		y 128
		view 912
		loop 1
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 10912 else 912)
			posn: (if (IsHiRes) 182 else 226) (if (IsHiRes) 110 else 128)
		)
	)
)

(instance dragonMouth of Prop
	(properties
		x 170
		y 101
		view 912
		loop 2
		signal 16417
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 10912 else 912)
			posn: (if (IsHiRes) 155 else 170) (if (IsHiRes) 96 else 101)
		)
	)
)

(instance dragonDrool of Prop
	(properties
		x 175
		y 107
		view 912
		loop 3
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 10912 else 912)
			posn: (if (IsHiRes) 157 else 175) (if (IsHiRes) 99 else 107)
		)
	)
)

(instance dragonNose of Prop
	(properties
		x 209
		y 81
		view 912
		loop 4
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 10912 else 912)
			posn: (if (IsHiRes) 173 else 209) (if (IsHiRes) 85 else 81)
		)
	)
)

(instance rightHand of Prop
	(properties
		x 119
		y 107
		view 912
		loop 5
		signal 16417
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 10912 else 912)
			posn: (if (IsHiRes) 129 else 119) (if (IsHiRes) 99 else 107)
		)
	)
)

(instance fire of Prop
	(properties
		x 60
		y 99
		view 920
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 10920 else 920)
			posn: (if (IsHiRes) 100 else 60) (if (IsHiRes) 95 else 99)
		)
	)
)

(instance dragonFaceBack of View
	(properties
		x 65
		y 22
		view 9170
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 19170 else 9170)
			posn: (if (IsHiRes) 104 else 65) (if (IsHiRes) 57 else 22)
		)
	)
)

(instance egoHead of View
	(properties
		x 61
		y 22
		view 9270
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 19270 else 9270)
			posn: (if (IsHiRes) 100 else 61) (if (IsHiRes) 57 else 22)
		)
	)
)

(instance dragonFace_Hands of View
	(properties
		name {dragonFace&Hands}
		x 61
		y 22
		view 9120
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 19120 else 9120)
			posn: (if (IsHiRes) 100 else 61) (if (IsHiRes) 57 else 22)
		)
	)
)

(instance fireWall of View
	(properties
		x 61
		y 22
		view 9200
	)

	(method (init)
		(super init:)
		(self
			view: (if (IsHiRes) 19200 else 9200)
			posn: (if (IsHiRes) 100 else 61) (if (IsHiRes) 57 else 22)
		)
	)
)

(instance myInvisCursor of Cursor
	(properties
		view 996
	)
)

