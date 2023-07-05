;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Window)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm043 0
)

(local
	local0
	local1
)

(instance rm043 of Rm
	(properties
		picture 43
		style 0
		horizon 134
		vanishingY -30
	)

	(method (init)
		(HandsOn)
		(Load rsVIEW 71)
		(Load rsVIEW 36)
		(Load rsVIEW 49)
		(Load rsVIEW 39)
		(Load rsSOUND 41)
		(Load rsSOUND 11)
		(super init:)
		(= global207 1)
		(gEgo loop: 0 posn: 44 141 init:)
		(proc0_10 275 162 -5 138)
		(table init:)
		(stool init:)
		(fire init:)
		(jack init:)
		(if (not [global675 43])
			(if (proc0_11 49)
				(= [global675 43] 1)
				(= global206 gSpeed)
				(switch global131
					(0
						(gGame setSpeed: 4)
					)
					(1
						(gGame setSpeed: 7)
					)
					(2
						(gGame setSpeed: 8)
					)
				)
				(jack setScript: rhymeScript)
			)
		else
			(= local1 1)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if (and (== (rhymeScript state:) 13) (== (event message:) KEY_RETURN))
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (== (rhymeScript state:) 13)
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (== (rhymeScript state:) 13)
					(rhymeScript cycles: 1)
				)
				(if
					(and
						(& temp0 emSHIFT)
						(!= local1 1)
						(proc0_16 event 233 129 242 155)
					)
					(LookAt jack)
					(jack setScript: talkScript)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(super doit:)
		(if (== (gEgo onControl: 1) 4)
			(gCurRoom newRoom: 26)
		)
		(if (> (gEgo distanceTo: jack) 30)
			(= global108 0)
		)
		(if
			(and
				(not [global675 43])
				(< (gEgo distanceTo: jack) 30)
				(not global108)
			)
			(= global108 1)
			(LookAt jack)
			(jack setScript: talkScript)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local1 1)
				(HandsOff)
				(= cycles 5)
			)
			(1
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display
					{Boy, am I\nhungry for\nsome\nChristmas pie!}
					dsWIDTH
					100
					dsCOORD
					140
					66
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(rhymeSound number: 41 loop: 1 play:)
				(jack setLoop: 6 setCycle: Fwd cycleSpeed: 1)
				(= seconds global120)
			)
			(2
				(itemBalloon setCel: 1)
				(itemVisual init: show:)
				(jack setCel: 0)
				(= seconds global121)
			)
			(3
				(itemVisual hide:)
				(itemBalloon hide:)
				(jack setCycle: Beg self)
			)
			(4
				(jack setLoop: 1 setCycle: Fwd)
				(= global103 0)
				(= local1 0)
				(HandsOn)
			)
		)
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local1 1)
				(= global209 1)
				(HandsOff)
				(gEgo setMotion: MoveTo 215 144 self)
			)
			(1
				(proc0_18)
				(jack setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(jack setLoop: 5 setCel: 0 stopUpd:)
				(gEgo setAvoider: Avoid setMotion: MoveTo 180 170 self)
			)
			(3
				(proc0_17)
				(= cycles 5)
			)
			(4
				(gEgo setLoop: 3 stopUpd:)
				(rhymeBox init:)
				(rhymeBox open:)
				(= seconds 3)
			)
			(5
				(rhymeSound number: 11 loop: 1 play:)
				(= seconds 4)
			)
			(6
				(jack
					ignoreControl: -1
					ignoreActors: 1
					ignoreHorizon: 1
					cycleSpeed: 0
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 232 131 self
				)
			)
			(7
				(jack setLoop: 4 setCel: 0)
				(StrCpy @global270 {Eating of Christmas Pie;\n})
				(= seconds 4)
			)
			(8
				(jack cycleSpeed: 5 setCycle: End self)
			)
			(9)
			(10
				(jack setLoop: 5 setCel: 1)
				(= seconds 1)
			)
			(11
				(= seconds (* global122 2))
			)
			(12
				(jack setLoop: 7 setCycle: End self)
			)
			(13
				(gEgo setMotion: 0 setCycle: Walk setLoop: -1)
				(= local0 0)
				(= global103 0)
			)
			(14
				(gGame setSpeed: global206)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(rhymeBox dispose:)
				(proc0_12)
				(if (== gScore gPossibleScore)
					(HandsOff)
					(gEgo setAvoider: Avoid)
					(gEgo setMotion: MoveTo -5 138)
				else
					(NormalEgo)
					(HandsOn)
					(= global209 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(switch (rhymeSound prevSignal:)
			(10
				(rhymeSound prevSignal: 0)
				(Display {Little Jack Horner} dsWIDTH 300 dsCOORD 5 5 dsALIGN alLEFT dsFONT 0 dsCOLOR 0)
			)
			(20
				(rhymeSound prevSignal: 0)
				(Display
					{     Sat in the corner,}
					dsWIDTH
					300
					dsCOORD
					5
					17
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(30
				(rhymeSound prevSignal: 0)
				(StrCpy @global270 {Eating of Christmas Pie;\n})
				(Display @global270 dsWIDTH 300 dsCOORD 5 29 dsALIGN alLEFT dsFONT 0 dsCOLOR 0)
			)
			(40
				(rhymeSound prevSignal: 0)
				(Display
					{He put in his thumb,}
					dsWIDTH
					300
					dsCOORD
					5
					41
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(50
				(rhymeSound prevSignal: 0)
				(Display
					{     And pulled out a plum,}
					dsWIDTH
					300
					dsCOORD
					5
					53
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(60
				(rhymeSound prevSignal: 0)
				(rhymeScript changeState: 10)
			)
			(70
				(rhymeSound prevSignal: 0)
				(Display
					{And said, "What a good boy am I!"}
					dsWIDTH
					300
					dsCOORD
					5
					65
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
		)
	)
)

(instance rhymeSound of Sound
	(properties
		number 11
		priority 10
	)
)

(instance jack of Actor
	(properties)

	(method (init)
		(super init:)
		(if [global675 43]
			(self view: 71 posn: 232 131 setLoop: 5 setCel: 2 stopUpd:)
		else
			(self view: 71 posn: 241 144 setLoop: 1 cycleSpeed: 4 setCycle: Fwd)
		)
	)
)

(instance fire of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 71 posn: 257 137 setLoop: 0 setCycle: Fwd cycleSpeed: 1)
	)
)

(instance stool of View
	(properties)

	(method (init)
		(super init:)
		(self view: 71 posn: 227 129 setLoop: 5 setCel: 3 stopUpd:)
	)
)

(instance table of View
	(properties)

	(method (init)
		(super init:)
		(self view: 36 posn: 275 179 setPri: 11 ignoreActors: 1 stopUpd:)
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 49
			setLoop: 1
			setCel: 0
			posn: 193 92
			setPri: 15
			hide:
			stopUpd:
		)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 posn: 190 120 setPri: 14 hide: stopUpd:)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 15
			left: 48
			bottom: 92
			right: 272
			type: 4
			title: {Little Jack Horner}
			back: 13
		)
	)
)

