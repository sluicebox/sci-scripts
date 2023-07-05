;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 312)
(include sci.sh)
(use Main)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use L7TalkWindow)
(use foEExit)
(use Plane)
(use Talker)
(use Motion)
(use Actor)
(use System)

(public
	ro313 0
)

(procedure (localproc_0)
	(if (== (gCurRoom plane:) oLarryCUPlane)
		(gCurRoom deleteRoomPlane: oLarryCUPlane)
		(= global334 toAnnette)
		(L7TalkWindow init: poAnnette global249)
	)
)

(procedure (localproc_1)
	(if (!= (gCurRoom plane:) oLarryCUPlane)
		(if (L7TalkWindow oPlane:)
			(L7TalkWindow dispose:)
		)
		(gCurRoom addRoomPlane: oLarryCUPlane)
		(= global334 0)
	)
)

(procedure (localproc_2)
	(if (poLarryEyes plane:)
		(poLarryEyes setCycle: Beg)
	else
		(poLarryEyes cel: 0)
	)
)

(procedure (localproc_3)
	(if (poLarryEyes plane:)
		(poLarryEyes setCycle: End)
	else
		(poLarryEyes cel: 4)
	)
)

(procedure (localproc_4)
	(poAnnetteEyes loop: 3)
)

(procedure (localproc_5)
	(poAnnetteEyes loop: 2)
)

(instance ro313 of L7Room
	(properties
		picture 31200
	)

	(method (init)
		(super init:)
		(gOMusic1 setMusic: 31200)
		(= global330 0)
		(= global334 toAnnette)
		(poAnnette init:)
		(voAnnette init:)
		(poAnnetteEyes init:)
		(foCUExit init:)
		(gGame handsOn:)
		(if ((ScriptID 64017 0) test: 171) ; oFlags
			(gCurRoom setScript: soIntroduction2)
		else
			(gCurRoom setScript: soIntroduction)
			((ScriptID 64017 0) set: 171) ; oFlags
		)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 53)) ; oInvHandler, ioHanky
		(gEgo get: ((ScriptID 64037 0) get: 3)) ; oInvHandler, ioKnife
		(gEgo get: ((ScriptID 64037 0) get: 20)) ; oInvHandler, ioInsurance
	)
)

(instance soIntroduction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_0)
				(gMessager sayRange: 1 100 0 1 3 self 312) ; "(EXPECTANTLY; OPENING DOOR) Yes? (NOT GLAD TO SEE LARRY) Oh. It's you."
			)
			(1
				(localproc_2)
				(localproc_1)
				(gMessager sayRange: 1 100 0 4 4 self 312) ; "(UNSURE HOW TO BEGIN) Um, well, I was just wondering..."
			)
			(2
				(localproc_3)
				(localproc_1)
				(gMessager sayRange: 1 100 0 5 6 self 312) ; "...if there's any way I could get you in bed?"
			)
			(3
				(localproc_0)
				(gMessager say: 1 100 0 7 self 312) ; "I'm not sure what we have to talk about."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soIntroduction2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 101 0 0 self 312) ; "Yes? Oh. You again."
			)
			(1
				(L7TalkWindow init: poAnnette global249)
				(self dispose:)
			)
		)
	)
)

(instance soHomosexuality of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3)
				(localproc_1)
				(gMessager sayRange: 1 205 0 1 2 self 312) ; "You know... about the other night... I just wanted to..."
			)
			(1
				(localproc_0)
				(gMessager sayRange: 1 205 0 3 4 self 312) ; "Look, you did what you had to do. But I don't want to talk about it, okay?"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soMrBoning of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(gMessager say: 1 204 0 1 self 312) ; "I haven't seen your "old friend" around lately. Is everything okay?"
			)
			(1
				(localproc_0)
				(gMessager sayRange: 1 204 0 2 3 self 312) ; "(HESITANTLY) Yes. Everything's fine."
			)
			(2
				(localproc_1)
				(gMessager sayRange: 1 204 0 4 5 self 312) ; "I hope he's having a nice rest."
			)
			(3
				(localproc_0)
				(gMessager sayRange: 1 204 0 6 7 self 312) ; "Oh, he's "resting comfortably.""
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soCarvingKnife of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 preload: 31102)
				(gMessager sayRange: 1 52 0 1 1 self) ; "Annette, I have a knife."
			)
			(1
				(localproc_4)
				(gMessager sayRange: 1 52 0 2 2 self) ; "(Screams and leaves.)"
			)
			(2
				(localproc_3)
				(localproc_1)
				(gOSound1 playSound: 31102)
				(gMessager sayRange: 1 52 0 3 3 self) ; "Wait. Come back. I wasn't threatening you."
			)
			(3
				(localproc_2)
				(gMessager sayRange: 1 52 0 4 4 self) ; "I was just wondering what I was supposed to do with this knife?"
			)
			(4
				((ScriptID 64017 0) set: 64) ; oFlags
				(gCurRoom newRoom: 311) ; ro311
			)
		)
	)
)

(instance soGoodbye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 86 0 0 self) ; "It's been nice talking to you, I guess."
			)
			(1
				(gCurRoom newRoom: 311) ; ro311
			)
		)
	)
)

(instance soNegotiation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 preload: 31105)
				(gOSound1 preload: 31102 31106)
				(gMessager sayRange: 1 58 0 1 1 self) ; "I have something I believe you want."
			)
			(1
				(localproc_4)
				(gMessager sayRange: 1 58 0 2 3 self) ; "(GROAN) Oh! That damn insurance policy! Now it's gonna cost me big time."
			)
			(2
				(localproc_3)
				(localproc_1)
				(localproc_5)
				(gMessager sayRange: 1 58 0 4 4 self) ; "(HESITANTLY) Um, I was thinking, you know, ah, for something as, uh, special as this, don't you think, uh, a little extra thanks would be in order?"
				(= ticks 20)
			)
			(3
				(localproc_2)
			)
			(4
				(localproc_3)
				(gMessager sayRange: 1 58 0 5 5 self) ; "Like... sex?"
			)
			(5
				(localproc_0)
				(gMessager sayRange: 1 58 0 6 9 self) ; "Oh, I don't think I have anything you'd want."
			)
			(6
				(localproc_1)
				(gMessager sayRange: 1 58 0 10 11 self) ; "Waddaya say I come inside..."
			)
			(7
				(localproc_0)
				(gMessager sayRange: 1 58 0 12 12 self) ; "All right, Larry. I know what you want. And if I give it to you, I don't want to see you again, you understand. No more. That's it. We're through, capisce?"
			)
			(8
				(localproc_2)
				(localproc_1)
				(gMessager sayRange: 1 58 0 13 13 self) ; "She wants me to have sex right now, and she DOESN'T want me to call her later? Oh! It's a dream come true!"
			)
			(9
				(localproc_3)
				(gMessager sayRange: 1 58 0 14 14 self) ; "You're reading my mind, sweetcakes!"
			)
			(10
				(localproc_0)
				(gMessager sayRange: 1 58 0 15 15 self) ; "Ugh. Okay, wait right here."
			)
			(11
				(localproc_1)
				(gOSound1 playSound: 31102)
				(= ticks 180)
			)
			(12
				(gMessager sayRange: 1 58 0 16 16 self) ; "Man, a guy's got to jump through hoops just to get this chick in bed!"
			)
			(13
				(= ticks 60)
			)
			(14
				(gOSound1 playSound: 31106 self)
			)
			(15
				(localproc_0)
				(gMessager sayRange: 1 58 0 17 17 self) ; "Okay, Larry. I don't keep much cash around, but this is worth a lot more than you deserve. Now amscray. Skeedaddle."
			)
			(16
				(gOSound1 playSound: 31105 self)
			)
			(17
				(gEgo put: ((ScriptID 64037 0) get: 20)) ; oInvHandler, ioInsurance
				(gEgo get: ((ScriptID 64037 0) get: 44)) ; oInvHandler, ioStock
				((ScriptID 64017 0) set: 65) ; oFlags
				(gCurRoom newRoom: 311) ; ro311
				(self dispose:)
			)
		)
	)
)

(instance foCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom newRoom: 311) ; ro311
	)
)

(instance poLarry of Prop
	(properties
		x -1
		y 479
		priority 50
		fixPriority 1
		view 31300
	)
)

(instance voLarryMouth of View
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 1))
		(super show: &rest)
	)
)

(instance toLarry of Talker
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(= priority (+ (poLarry priority:) 1))
		(voLarryMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voLarryMouth show:)
		(super dispose: &rest)
	)
)

(instance poLarryEyes of Prop
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 2))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 15))
		(super init: &rest)
		(self cycleSpeed: 6)
	)
)

(instance poAnnette of Prop
	(properties
		noun 1
		x 392
		y 220
		priority 50
		fixPriority 1
		view 31200
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; Carving Knife
				(gCurRoom setScript: soCarvingKnife)
			)
			(58 ; Life Insurance Policy
				(gCurRoom setScript: soNegotiation)
			)
			(86 ; Goodbye
				(gCurRoom setScript: soGoodbye)
			)
			(205 ; Homosexuality
				(gCurRoom setScript: soHomosexuality)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voAnnette of View
	(properties)

	(method (init)
		(= view (poAnnette view:))
		(= loop (+ (poAnnette loop:) 1))
		(= x (poAnnette x:))
		(= y (poAnnette y:))
		(self setPri: (+ (poAnnette priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poAnnette view:))
		(= loop (+ (poAnnette loop:) 1))
		(= x (poAnnette x:))
		(= y (poAnnette y:))
		(self setPri: (+ (poAnnette priority:) 1))
		(super show: &rest)
	)
)

(instance toAnnette of Talker
	(properties)

	(method (init)
		(= view (poAnnette view:))
		(= loop (+ (poAnnette loop:) 1))
		(= x (poAnnette x:))
		(= y (poAnnette y:))
		(= priority (+ (poAnnette priority:) 1))
		(voAnnette hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voAnnette show:)
		(super dispose: &rest)
	)
)

(instance poAnnetteEyes of Prop
	(properties)

	(method (init)
		(= view (poAnnette view:))
		(= loop (+ (poAnnette loop:) 2))
		(= x (poAnnette x:))
		(= y (poAnnette y:))
		(self setPri: (+ (poAnnette priority:) 15))
		(super init: &rest)
		(self cycleSpeed: 6)
		(self setCycle: Blink 10)
	)

	(method (show)
		(= view (poAnnette view:))
		(= x (poAnnette x:))
		(= y (poAnnette y:))
		(super show: &rest)
		(self setCycle: Blink 10)
	)
)

(instance oLarryCUPlane of Plane
	(properties
		picture 31300
	)

	(method (init)
		(super init: 0 0 639 479)
		(poLarry init:)
		(voLarryMouth init:)
		(poLarryEyes init:)
		(= global330 toLarry)
	)

	(method (dispose)
		(= global330 0)
		(super dispose: &rest)
	)
)

