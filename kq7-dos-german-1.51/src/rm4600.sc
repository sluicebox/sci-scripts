;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4600)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use RandCycle)
(use Polygon)
(use Timer)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm4600 0
)

(instance rm4600 of KQRoom
	(properties
		picture 4600
	)

	(method (init)
		(super init:)
		(gKqMusic1 setVol: 90)
		(gEgo init: view: 8151 posn: 170 120 hide:)
		(candles setCycle: RandCycle init:)
		((ScriptID 13 0) client: gEgo) ; aEgoTalker
		(if (gGame scratch:)
			(FrameOut)
			(mySound number: 802 loop: 1 play:)
			(gGame scratch: 0)
		)
		(SetFlag 192)
		((ScriptID 7001 1) client: malicia) ; maliciaTalker
		(Load rsMESSAGE 4600)
		(mySouthExit init:)
		(cond
			((and (== gPrevRoomNum 4650) (== gChapter 4) (IsFlag 162))
				(gGame handsOff:)
				(dogNose init: posn: 139 126 setLoop: 0)
				(gCurRoom setScript: sRosDogDeath2)
			)
			((and (== gPrevRoomNum 4450) (== gChapter 5) (IsFlag 298))
				(ClearFlag 298)
				(gCurRoom setScript: sZapVal)
			)
			((and (== gPrevRoomNum 4450) (== gChapter 5) (IsFlag 165))
				(knotHole init:)
				(gGame handsOn:)
			)
			((and (IsFlag 164) (not (IsFlag 165)))
				(self setScript: dogNoseScript)
			)
			((and (== gChapter 5) (== gPrevRoomNum 4450) (not (IsFlag 165)))
				(self setScript: dogNoseScript)
			)
			(else
				(knotHole init:)
				(gGame handsOn:)
			)
		)
		(User canControl: 0)
		(ClearFlag 5)
	)

	(method (dispose)
		(mySound stop:)
		(dogTimer client: 0 delete: dispose:)
		(super dispose:)
	)
)

(instance sZapVal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(malicia init:)
				(= seconds 3)
			)
			(1
				(malicia dispose:)
				(theZap init: cel: 0 setCycle: End self)
				(mySound number: 845 loop: 1 play:)
			)
			(2
				(theZap dispose:)
				(PalVary 4 4601) ; PalVaryTarget
				(PalVary 0) ; PalVaryStart
				(= ticks 60)
			)
			(3
				(PalVary 3) ; PalVaryKill
				(if (== gPrevRoomNum 4650)
					(EgoDead 7 self)
				else
					(EgoDead 10 self)
				)
			)
			(4
				(gEgo hide:)
				(if (== gPrevRoomNum 4650)
					(dogTimer client: 0 delete: dispose:)
					(gCurRoom newRoom: 4650)
				else
					(ClearFlag 5)
					(gCurRoom setScript: dogNoseScript)
				)
			)
		)
	)
)

(instance sSprayDog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 165)
				(sprayBottle init: setMotion: MoveTo 145 97 self)
			)
			(1
				(mySound number: 4565 loop: 1 play:)
				(spray init: setCycle: End self)
			)
			(2
				(spray dispose:)
				(sprayBottle setMotion: MoveTo 145 200)
				(mySound number: 888 loop: 1 play: self)
			)
			(3
				(gCurRoom newRoom: 4450)
			)
		)
	)
)

(instance dogNoseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(User canControl: 0)
				(dogNose posn: 139 126 init: cel: 0 loop: 0 setCycle: End self)
				(mySound
					number: 4006
					loop: -1
					play:
					setVol: 50
					fade: 127 3 40 0
				)
			)
			(1
				(dogNose loop: 1 cel: 0 setCycle: RandCycle)
				(dogTimer setReal: dogTimer 10)
				(gGame handsOn:)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sRosDogDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound stop:)
				(= cycles 3)
			)
			(1
				(if (== (dogNose loop:) 1)
					(dogNose setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2
				(dogNose setLoop: 0)
				(dogNose setCel: (dogNose lastCel:) setCycle: CT 3 -1 self)
			)
			(3
				(mySound number: 917 setLoop: 1 play: self)
			)
			(4
				(gMessager say: 1 8 2 1 self) ; "Hush, doggie! Go away!"
			)
			(5
				(gMessager say: 0 0 1 1 self) ; "What have you found, Cuddles, my love? Let me see."
			)
			(6
				(dogNose setCycle: Beg self)
			)
			(7
				(dogNose dispose:)
				(malicia init:)
				(mySound number: 4460 play: self)
			)
			(8
				(gMessager say: 0 0 1 2 self) ; "(NASTY GLEE)Oh, it's a nasty little termite!"
			)
			(9
				(malicia dispose:)
				(theZap init: cel: 0 setCycle: End self)
				(mySound number: 845 loop: 1 play:)
			)
			(10
				(theZap dispose:)
				(PalVary 4 4601) ; PalVaryTarget
				(PalVary 0) ; PalVaryStart
				(= ticks 60)
			)
			(11
				(PalVary 3) ; PalVaryKill
				(EgoDead 9 self)
			)
			(12
				(gEgo hide:)
				(if (== gPrevRoomNum 4650)
					(dogTimer client: 0 delete: dispose:)
					(gCurRoom newRoom: 4650)
				else
					(ClearFlag 5)
					(gCurRoom setScript: dogNoseScript)
				)
			)
		)
	)
)

(instance sRosDogDeath2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound stop:)
				(if (== (dogNose loop:) 1)
					(dogNose setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(dogNose setLoop: 0)
				(dogNose setCel: (dogNose lastCel:) setCycle: CT 3 -1 self)
			)
			(2
				(mySound number: 917 setLoop: 1 play: self)
			)
			(3
				(gMessager say: 0 0 1 1 self) ; "What have you found, Cuddles, my love? Let me see."
			)
			(4
				(dogNose setCycle: Beg self)
			)
			(5
				(dogNose dispose:)
				(malicia init:)
				(mySound number: 4460 play: self)
			)
			(6
				(gMessager say: 0 0 1 2 self) ; "(NASTY GLEE)Oh, it's a nasty little termite!"
			)
			(7
				(malicia dispose:)
				(theZap init: cel: 0 setCycle: End self)
				(mySound number: 845 loop: 1 play:)
			)
			(8
				(theZap dispose:)
				(PalVary 4 4601) ; PalVaryTarget
				(PalVary 0) ; PalVaryStart
				(= ticks 60)
			)
			(9
				(PalVary 3) ; PalVaryKill
				(EgoDead 9 self)
			)
			(10
				(gEgo hide:)
				(if (== gPrevRoomNum 4650)
					(dogTimer client: 0 delete: dispose:)
					(gCurRoom newRoom: 4650)
				else
					(ClearFlag 5)
					(gCurRoom setScript: dogNoseScript)
				)
			)
		)
	)
)

(instance sDoDogSniff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 165)
				(mySound number: 4006 loop: 1 play: self)
			)
			(1
				(gCurRoom newRoom: 4450)
			)
		)
	)
)

(instance sValDogDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound stop:)
				(gMessager say: 1 8 4 1 self) ; "(WHISPERING)No! Go away!"
			)
			(1
				(dogNose dispose:)
				(malicia init:)
				(= seconds 3)
			)
			(2
				(gMessager say: 1 8 4 2 self) ; "(NASTY)Why, it's just what you'd expect to find in the crawlspace! A little worm!"
			)
			(3
				(malicia dispose:)
				(theZap init: cel: 0 setCycle: End self)
				(mySound number: 845 loop: 1 play:)
			)
			(4
				(theZap dispose:)
				(PalVary 4 4601) ; PalVaryTarget
				(PalVary 0) ; PalVaryStart
				(= ticks 60)
			)
			(5
				(PalVary 3) ; PalVaryKill
				(EgoDead 10 self)
			)
			(6
				(gEgo hide:)
				(ClearFlag 5)
				(gCurRoom setScript: dogNoseScript)
			)
		)
	)
)

(instance sprayBottle of Actor
	(properties
		x 145
		y 176
		priority 192
		fixPriority 1
		view 4601
		loop 2
		signal 2049
	)
)

(instance candles of Prop
	(properties
		x 108
		y 62
		priority 88
		fixPriority 1
		view 4604
	)
)

(instance theZap of Prop
	(properties
		x 150
		y 55
		priority 199
		fixPriority 1
		view 4603
	)
)

(instance spray of Prop
	(properties
		x 145
		y 98
		priority 191
		fixPriority 1
		view 4601
		loop 3
	)
)

(instance malicia of Prop
	(properties
		x 154
		y 95
		view 4602
	)
)

(instance dogNose of Prop
	(properties
		x 139
		y 94
		view 4601
	)

	(method (init)
		(super init:)
		(self setPri: 130 setHotspot: 8 10 76 68) ; Do, Exit, Ambrosia, Defoliant
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(dogTimer client: 0 delete: dispose:)
				(if (== gValOrRoz -3) ; Roz
					(gCurRoom setScript: sRosDogDeath)
				else
					(gCurRoom setScript: sValDogDeath)
				)
			)
			(68 ; Defoliant
				(dogNoseScript dispose:)
				(dogTimer client: 0 delete: dispose:)
				(gCurRoom setScript: sSprayDog)
			)
			(76 ; Ambrosia
				(gGame handsOff:)
				(dogTimer client: 0 delete: dispose:)
				(gCurRoom setScript: sDoDogSniff)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance knotHole of ExitFeature
	(properties
		exitDir 1
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 71 66 108 95 154 99 179 92 201 71 201 29 129 13 94 33
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(event type:)
					(!= (event type:) evMOUSERELEASE)
					(not global308)
					(self onMe: event)
				)
				(mySound stop:)
				(gKqMusic1 fade:)
				(if (gCast contains: dogNose)
					(dogNose doVerb: 8)
				else
					(gCurRoom newRoom: 4450)
				)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (doVerb)
		(gCurRoom newRoom: 4450)
	)
)

(instance dogTimer of Timer
	(properties)

	(method (cue)
		(mySound stop:)
		(if (== gValOrRoz -3) ; Roz
			(gGame handsOff:)
			(gCurRoom setScript: sRosDogDeath2)
		else
			(dogTimer client: 0 delete: dispose:)
			(gCurRoom newRoom: 4450)
		)
	)
)

(instance mySouthExit of ExitFeature
	(properties
		nsTop 109
		nsRight 320
		nsBottom 170
		approachX 170
		approachY 200
		x 170
		y 200
		exitDir 3
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(event type:)
					(!= (event type:) evMOUSERELEASE)
					(not global308)
					(self onMe: event)
				)
				(mySound stop:)
				(gKqMusic1 fade:)
				(ClearFlag 164)
				(gCurRoom newRoom: 4650)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance mySound of Sound
	(properties)
)

