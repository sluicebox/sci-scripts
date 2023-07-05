;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 551)
(include sci.sh)
(use Main)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro551 0
)

(local
	local0
)

(instance ro551 of L7Room
	(properties
		picture 55100
	)

	(method (init)
		(gEgo init: normalize: 7 setScalePercent: 200 posn: 123 444)
		(UpdateScreenItem gEgo)
		(super init:)
		(gOMusic1 setMusic: 38000)
		(if ((ScriptID 64017 0) test: 257) ; oFlags
			((ScriptID 64017 0) set: 269) ; oFlags
			(gCurRoom setScript: soOldWoman)
			(return)
		)
		(if ((ScriptID 64017 0) test: 258) ; oFlags
			((ScriptID 64017 0) set: 269) ; oFlags
			(gCurRoom setScript: soPeterPurser)
			(return)
		)
		(if ((ScriptID 64017 0) test: 259) ; oFlags
			((ScriptID 64017 0) set: 269) ; oFlags
			(gCurRoom setScript: soJapTourists)
			(return)
		)
		(if ((ScriptID 64017 0) test: 260) ; oFlags
			((ScriptID 64017 0) set: 269) ; oFlags
			(gCurRoom setScript: soLittleGirl)
			(return)
		)
		(if ((ScriptID 64017 0) test: 261) ; oFlags
			((ScriptID 64017 0) set: 269) ; oFlags
			(gCurRoom setScript: soNun)
			(return)
		)
		(if ((ScriptID 64017 0) test: 262) ; oFlags
			((ScriptID 64017 0) set: 269) ; oFlags
			(gCurRoom setScript: soPeggy)
			(return)
		)
		(if ((ScriptID 64017 0) test: 263) ; oFlags
			((ScriptID 64017 0) set: 269) ; oFlags
			(gCurRoom setScript: soTVReporter)
			(return)
		)
		(gCurRoom setScript: soGoToYourRoom)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 54)) ; oInvHandler, ioKeyCard
		(switch global311
			(0
				(gCurRoom setScript: soLittleGirl)
			)
			(1
				(gCurRoom setScript: soPeterPurser)
			)
			(2
				(gCurRoom setScript: soTVReporter)
			)
			(3
				(gCurRoom setScript: soNun)
			)
			(4
				(gCurRoom setScript: soOldWoman)
			)
			(5
				(gCurRoom setScript: soJapTourists)
			)
			(6
				(gCurRoom setScript: soPeggy)
			)
		)
		(if (== global311 6)
			(= global311 0)
		else
			(++ global311)
		)
	)
)

(instance soPlayNextIntro of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch global266
					(0
						(= temp0 7)
					)
					(1
						(= temp0 8)
					)
					(2
						(= temp0 9)
					)
					(3
						(= temp0 10)
					)
					(4
						(= temp0 11)
					)
					(5
						(= temp0 12)
					)
					(6
						(= temp0 22)
					)
				)
				(if (< global266 6)
					(++ global266)
				)
				(gMessager say: 0 0 temp0 0 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance soOldWoman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo dispose:)
				(Palette 1 55101) ; PalLoad
				(proc64896_17 0)
				(proc64896_1 0 3 self)
				(gOSound1 preload: 55104)
				(self setScript: soPlayNextIntro self)
			)
			(1)
			(2
				(poLarry
					view: 55100
					loop: 0
					cel: 0
					posn: 223 453
					init:
					setCycle: End coRipJacket 27
				)
				(poGeneric
					view: 55101
					loop: 0
					cel: 0
					posn: 523 407
					init:
					setCycle: End self
				)
			)
			(3
				(= global354 toGeneric)
				(poGeneric
					view: 55102
					loop: 0
					cel: 0
					posn: 523 407
					doit:
					setCycle: Fwd
				)
				(voGenericMouth init:)
				(gMessager say: 0 0 13 0 self) ; "(OLD WOMAN IN SHOCK AND HORROR) You damn hippies should be ashamed!"
			)
			(4
				(proc64896_1 1 12 self)
			)
			(5
				(= global354 0)
				((ScriptID 64017 0) set: 264) ; oFlags
				((ScriptID 64017 0) clear: 257) ; oFlags
				(gCurRoom newRoom: 550) ; ro550
			)
		)
	)
)

(instance coRipJacket of CueMe
	(properties)

	(method (cue)
		(gOSound1 playSound: 55104)
	)
)

(instance soPeterPurser of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo dispose:)
				(Palette 1 55126) ; PalLoad
				(proc64896_17 0)
				(proc64896_1 0 3 self)
				(gOSound1 preload: 55103)
				(self setScript: soPlayNextIntro self)
			)
			(1)
			(2
				(poLarry
					view: 55125
					loop: 0
					cel: 0
					posn: 223 453
					init:
					setCycle: End self 5 29
				)
			)
			(3
				(poGeneric
					view: 55126
					loop: 0
					cel: 0
					posn: 562 399
					init:
					setCycle: End self
				)
			)
			(4
				(= global340 toGeneric)
				(poGeneric view: 55127 loop: 0 cel: 0 posn: 562 399)
				(voGenericMouth init:)
				(= local0 1)
				(gMessager say: 0 0 14 1 coDoneTalking) ; "(DELIGHTED) Oouuuh! Wouldn't I love a bite of THAT!"
			)
			(5
				(gOSound1 playSound: 55103)
				(= cycles 1)
			)
			(6
				(if local0
					(-- state)
				)
				(= cycles 1)
			)
			(7
				(proc64896_1 1 12 self)
			)
			(8
				(= global340 0)
				((ScriptID 64017 0) clear: 258) ; oFlags
				(gCurRoom newRoom: 550) ; ro550
			)
		)
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= local0 0)
	)
)

(instance soJapTourists of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo dispose:)
				(Palette 1 55106) ; PalLoad
				(proc64896_17 0)
				(proc64896_1 0 3 self)
				(gOSound1 preload: 55100)
				(self setScript: soPlayNextIntro self)
			)
			(1)
			(2
				(poLarry
					view: 55105
					loop: 0
					cel: 0
					posn: 223 453
					init:
					setCycle: End self 15
				)
			)
			(3
				(poGeneric
					view: 55106
					loop: 0
					cel: 0
					posn: 548 414
					init:
					setCycle: End self 12 99
				)
			)
			(4
				(gOSound1 playSound: 55100 self)
			)
			(5)
			(6
				(proc64896_1 1 12 self)
			)
			(7
				((ScriptID 64017 0) set: 264) ; oFlags
				((ScriptID 64017 0) clear: 259) ; oFlags
				(gCurRoom newRoom: 550) ; ro550
			)
		)
	)
)

(instance soLittleGirl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo dispose:)
				(Palette 1 55131) ; PalLoad
				(proc64896_17 0)
				(proc64896_1 0 3 self)
				(self setScript: soPlayNextIntro self)
			)
			(1)
			(2
				(poLarry
					view: 55130
					loop: 0
					cel: 0
					posn: 223 453
					init:
					setCycle: CT 32 1
				)
				(poGeneric
					view: 55131
					loop: 0
					cel: 0
					posn: 596 424
					init:
					setCycle: End self
				)
			)
			(3
				(= global354 toGeneric)
				(poGeneric view: 55132 loop: 0 cel: 0 posn: 596 424)
				(voGenericMouth init:)
				(gMessager say: 0 0 5 0 self) ; "(LITTLE GIRL VOICE) Mommy? Why is the funny man wearing a diaper?"
			)
			(4
				(poGeneric
					view: 55133
					loop: 0
					cel: 0
					posn: 596 424
					setCycle: End self
				)
				(poLarry setCycle: End self)
			)
			(5)
			(6
				(proc64896_1 1 12 self)
			)
			(7
				(= global354 0)
				((ScriptID 64017 0) set: 264) ; oFlags
				((ScriptID 64017 0) clear: 260) ; oFlags
				(gCurRoom newRoom: 550) ; ro550
			)
		)
	)
)

(instance soNun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo dispose:)
				(Palette 1 55111) ; PalLoad
				(proc64896_17 0)
				(proc64896_1 0 3 self)
				(self setScript: soPlayNextIntro self)
			)
			(1)
			(2
				(poLarry
					view: 55110
					loop: 0
					cel: 0
					posn: 223 453
					init:
					setCycle: End self 13
				)
			)
			(3
				(poGeneric
					view: 55111
					loop: 0
					cel: 0
					posn: 542 420
					init:
					setCycle: CycleCueList 37 1 self 13 37
				)
			)
			(4
				(gMessager say: 0 0 15 0 self) ; "(SHOCKED) Oh. (HORRIFIED) Oh! (INTERESTED SEXUALLY) Oooooh!"
			)
			(5)
			(6
				(proc64896_1 1 12 self)
			)
			(7
				((ScriptID 64017 0) set: 264) ; oFlags
				((ScriptID 64017 0) clear: 261) ; oFlags
				(gCurRoom newRoom: 550) ; ro550
			)
		)
	)
)

(instance soPeggy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo dispose:)
				(Palette 1 55116) ; PalLoad
				(proc64896_17 0)
				(gOSound1 preload: 55102 55101)
				(proc64896_1 0 3 self)
				(self setScript: soPlayNextIntro self)
			)
			(1)
			(2
				(poLarry
					view: 55115
					loop: 0
					cel: 0
					posn: 223 453
					init:
					setCycle: CycleCueList 50 1 self 28 50
				)
			)
			(3
				(poGeneric
					view: 55116
					loop: 0
					cel: 0
					posn: 467 418
					init:
					setCycle: CycleCueList 24 1 self 9 24
				)
			)
			(4
				(= global341 toPeggy1)
				(gMessager say: 0 0 20 1 self) ; "(DELIGHT AT FINDING A NAKED MAN) Well, shiver me timbers!"
			)
			(5
				(poGeneric hide:)
				(poPeggy1 init:)
				(voPeggy1Mouth init: hide:)
				(if (toPeggy1 mouth:)
					((toPeggy1 mouth:) show:)
				)
			)
			(6)
			(7
				(= local0 1)
				(gMessager say: 0 0 20 2 coDoneTalking) ; "Oh, no!"
				(poPeggy1 dispose:)
				(voPeggy1Mouth dispose:)
				(poGeneric show:)
				(poGeneric setCycle: CycleCueList 28 1 self 25)
				(gOSound1 playSound: 55101)
			)
			(8
				(poLarry setCycle: CT 53 1 self)
			)
			(9
				(= ticks 60)
			)
			(10
				(poLarry setCycle: End)
				(= ticks 60)
			)
			(11
				(poGeneric setCycle: CT 33 1 self)
			)
			(12
				(= ticks 90)
			)
			(13
				(if local0
					(-- state)
				)
				(= cycles 1)
			)
			(14
				(= global341 toPeggy2)
				(= local0 1)
				(poGeneric hide:)
				(poPeggy2 init:)
				(voPeggy2Mouth init:)
				(gMessager sayRange: 0 0 20 3 4 coDoneTalking) ; "(RETRACT RULER AND STOMP OFF IN DISGUST) Looks like somebody already shivered that poor little timber! (MUMBLE AS YOU TURN OFF-MIKE) G*d d*mn sh*t-face c**ks**king mother-f**king son of a b***h"
				(= ticks 250)
			)
			(15
				(if (toPeggy2 mouth:)
					((toPeggy2 mouth:) hide:)
				)
				(poPeggy2 dispose:)
				(voPeggy2Mouth dispose:)
				(poGeneric show: setCycle: End self)
				(gOSound1 playSound: 55102)
				(poLarry setCycle: CT 56 -1)
			)
			(16
				(if local0
					(-- state)
				)
				(= cycles 1)
			)
			(17
				(proc64896_1 1 12 self)
			)
			(18
				((ScriptID 64017 0) set: 264) ; oFlags
				((ScriptID 64017 0) clear: 262) ; oFlags
				(gCurRoom newRoom: 550) ; ro550
			)
		)
	)
)

(instance poPeggy1 of Prop
	(properties
		x 467
		y 418
		priority 418
		fixPriority 1
		view 55140
	)
)

(instance voPeggy1Mouth of View
	(properties
		x 467
		y 418
		priority 419
		fixPriority 1
		view 55140
		loop 1
	)
)

(instance toPeggy1 of Talker
	(properties
		x 467
		y 418
		view 55140
		loop 1
		priority 419
	)

	(method (init)
		(super init: &rest)
		(if (voPeggy1Mouth plane:)
			(voPeggy1Mouth hide:)
		)
		(mouth hide:)
	)

	(method (dispose)
		(super dispose: &rest)
		(if (voPeggy1Mouth plane:)
			(voPeggy1Mouth show:)
		)
	)
)

(instance poPeggy2 of Prop
	(properties
		x 467
		y 418
		priority 418
		fixPriority 1
		view 55145
	)
)

(instance voPeggy2Mouth of View
	(properties
		x 467
		y 418
		priority 419
		fixPriority 1
		view 55145
		loop 1
	)
)

(instance toPeggy2 of Talker
	(properties
		x 467
		y 418
		view 55145
		loop 1
		priority 419
	)

	(method (init)
		(super init: &rest)
		(if (voPeggy2Mouth plane:)
			(voPeggy2Mouth hide:)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(if (voPeggy2Mouth plane:)
			(voPeggy2Mouth show:)
		)
	)
)

(instance soTVReporter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo dispose:)
				(Palette 1 55121) ; PalLoad
				(proc64896_17 0)
				(proc64896_1 0 3 self)
				(gOSound1 preload: 55105 55106)
				(self setScript: soPlayNextIntro self)
			)
			(1)
			(2
				(self setScript: soHandleLarrySounds)
				(poLarry
					view: 55120
					loop: 0
					cel: 0
					posn: 223 453
					init:
					setCycle: End soHandleLarrySounds 1 25 35
				)
			)
			(3
				(poGeneric
					view: 55121
					loop: 0
					cel: 0
					posn: 473 395
					init:
					setCycle: End self
				)
			)
			(4
				(= global355 toGeneric)
				(poGeneric view: 55122 loop: 0 cel: 0 posn: 473 395)
				(voGenericMouth init:)
				(gMessager say: 0 0 19 0 self) ; "Next, on "Inside Affair:" The Lust Boat! Coming in a port near you?!"
			)
			(5
				(proc64896_1 1 12 self)
			)
			(6
				(= global354 0)
				((ScriptID 64017 0) set: 264) ; oFlags
				((ScriptID 64017 0) clear: 263) ; oFlags
				(gCurRoom newRoom: 550) ; ro550
			)
		)
	)
)

(instance soHandleLarrySounds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(soTVReporter cue:)
			)
			(2
				(gOSound1 playSound: 55105)
			)
			(3
				(gOSound1 playSound: 55106)
			)
		)
	)
)

(instance soGoToYourRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo dispose:)
				(voLarryAtDoor init:)
				(gMessager say: 2 17 17 0 self) ; "You insert your keycard into the slot with great anticipation. What will your "special suite" be like?"
			)
			(1
				(gCurRoom drawPic: 55010)
				(voLarryAtDoor dispose:)
				(gOMusic1 setMusic: 53000)
				(gOAmbience setRelVol: 40 setAmbient: 55001)
				(= seconds 5)
			)
			(2
				(gCurRoom drawPic: 55020)
				(gOAmbience setRelVol: 75)
				(= seconds 5)
			)
			(3
				((ScriptID 64017 0) set: 157) ; oFlags
				(gOAmbience setRelVol: 100)
				(gCurRoom newRoom: 550) ; ro550
				(self dispose:)
			)
		)
	)
)

(instance voLarryAtDoor of View
	(properties
		x 497
		y 402
		view 55103
	)

	(method (init)
		(self setScalePercent: 70)
		(super init: &rest)
	)
)

(instance poLarry of Prop
	(properties)
)

(instance poGeneric of Prop
	(properties)
)

(instance voGenericMouth of View
	(properties)

	(method (init)
		(= view (poGeneric view:))
		(= loop (poGeneric loop:))
		(++ loop)
		(= cel 0)
		(= x (poGeneric x:))
		(= y (poGeneric y:))
		(= priority (poGeneric priority:))
		(++ priority)
		(= fixPriority 1)
		(super init: &rest)
	)
)

(instance toGeneric of Talker
	(properties)

	(method (init)
		(= view (poGeneric view:))
		(= loop (poGeneric loop:))
		(++ loop)
		(= cel 0)
		(= x (poGeneric x:))
		(= y (poGeneric y:))
		(= priority (poGeneric priority:))
		(++ priority)
		(super init: &rest)
		(voGenericMouth hide:)
	)

	(method (dispose)
		(voGenericMouth show:)
		(super dispose: &rest)
	)
)

(instance foLarryDoor of Feature ; UNUSED
	(properties
		noun 2
		x 77
		y 225
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 28 154 50 142 402 5 423
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(17 ; Your Cabin Keycard
				(gCurRoom setScript: soGoToYourRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

