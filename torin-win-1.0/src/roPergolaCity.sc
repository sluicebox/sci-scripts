;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30200)
(include sci.sh)
(use Main)
(use ScrollExit)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use CueMe)
(use n64896)
(use Plane)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	roPergolaCity 0
)

(instance poTorinBreaksFree of Prop
	(properties
		x 139
		y 244
		view 30200
		loop 1
		cycleSpeed 8
	)
)

(instance toTorinBreaksFree of Talker
	(properties
		x 139
		y 244
		view 30200
		loop 7
		priority 245
	)
)

(instance voTorinWithPergolanBody of View
	(properties
		x 189
		y 230
		view 30200
		loop 8
	)
)

(instance toTorinWithPergolan of Talker
	(properties
		x 189
		y 230
		view 30200
		loop 9
		priority 231
	)

	(method (init)
		(poTorinBreaksFree hide:)
		(voTorinWithPergolanBody init:)
		(super init: &rest)
	)

	(method (dispose)
		(poTorinBreaksFree show:)
		(voTorinWithPergolanBody dispose:)
		(super dispose: &rest)
	)
)

(instance poPergolansRun of Prop
	(properties
		x 140
		y 208
		view 30200
		loop 3
	)
)

(instance poSmetana of Prop
	(properties
		x 220
		y 123
		view 30200
		loop 4
	)
)

(instance oGasp of TPSound
	(properties)
)

(instance oScream of TPSound
	(properties)
)

(instance soTorinBreaksFree of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(oGasp playSound: 30205)
				(= gtTorin toTorinBreaksFree)
				(gMessager say: 1 1 1 1 self) ; "Stop that! Let me go."
			)
			(2
				(= gtTorin 0)
				(gMessager say: 1 1 1 2 self) ; "(SWINGING AND FLAILING AWAY AT LITTLE PERGOLANS) Get away. Shoo."
				(goSound1 preload: 30201 30202)
				(poTorinBreaksFree setCycle: CT 18 1 self)
				(poPergolansRun setCycle: End)
			)
			(3
				(= ticks (poTorinBreaksFree cycleSpeed:))
			)
			(4
				(poTorinBreaksFree setCel: 19 setCycle: CT 30 1 self)
				(goSound1 playSound: 30201)
			)
			(5
				(oScream setAmbient: 30202)
				(poTorinBreaksFree setCycle: End self)
			)
			(6
				(poTorinBreaksFree setCycle: CT 39 -1 self)
			)
			(7
				(poTorinBreaksFree setCycle: End self)
			)
			(8
				(= gtTorin toTorinWithPergolan)
				(gMessager say: 1 1 1 3 self) ; "Wait! Don't be afraid!"
			)
			(9
				(= gtTorin 0)
				(gMessager say: 1 1 1 4 self) ; "(TO MAN ON YOUR COLLAR) Hold still."
				(poTorinBreaksFree
					posn: 189 230
					setLoop: 2
					setCel: 0
					setCycle: CT 20 1 self
				)
			)
			(10)
			(11
				(oScream stop:)
				(oGasp playSound: 30203)
				(poTorinBreaksFree setCycle: End self)
			)
			(12
				(poSmetana init:)
				(= gtTorin toTorinRescuer)
				(gMessager say: 1 1 1 5 self) ; "(GENTLY) There."
			)
			(13
				(= ticks 30)
			)
			(14
				(= gtTorin 0)
				(poSmetana setCycle: End self)
			)
			(15
				(= ticks 45)
			)
			(16
				(goMusic1 setMusic: 30298)
				(gMessager say: 1 1 1 6 self) ; "(POLITICAL STUMPER) On behalf of all Pergolans everywhere, I would like to thank you, Giant...for saving the life of Fairmont!"
				(self setScript: soTorinLooksAround self)
			)
			(17)
			(18
				(= gtTorin 0)
				(poTorinBreaksFree dispose:)
				(poPergolansRun dispose:)
				(poSmetana dispose:)
				(gCurRoom addRoomPlane: oGiantTorinCU)
				(gMessager sayRange: 1 1 1 7 9 self) ; "(BOOMING, DISTORTED, LOUD) Oh, that's all right."
			)
			(19
				(gCurRoom deleteRoomPlane: oGiantTorinCU)
				(gCurRoom addRoomPlane: oSmetanaCU)
				(gMessager say: 1 1 1 10 self) ; "You seem to be a kinder, gentler giant, not like SOME giants we know. I wonder if you could help us with a problem."
			)
			(20
				(gCurRoom deleteRoomPlane: oSmetanaCU)
				(gCurRoom addRoomPlane: oGiantTorinCU)
				(gMessager say: 1 1 1 11 self) ; "But of course. Need some logs moved? Rocks realigned? (Villages trampled?)"
			)
			(21
				(gCurRoom deleteRoomPlane: oGiantTorinCU)
				(gCurRoom addRoomPlane: oSmetanaCU)
				(gMessager say: 1 1 1 13 self) ; "Much worse! We recently captured another giant, but very different from you. This one will not cooperate at all!"
			)
			(22
				(gCurRoom deleteRoomPlane: oSmetanaCU)
				(gCurRoom addRoomPlane: oGiantTorinCU)
				(gMessager say: 1 1 1 14 self) ; "What can I do?"
			)
			(23
				(gCurRoom deleteRoomPlane: oGiantTorinCU)
				(gCurRoom addRoomPlane: oSmetanaCU)
				(gMessager say: 1 1 1 15 self) ; "Perhaps if you talked with it."
			)
			(24
				(gCurRoom deleteRoomPlane: oSmetanaCU)
				(gCurRoom addRoomPlane: oGiantTorinCU)
				(gMessager say: 1 1 1 16 self) ; "(HESITANTLY) Well, okay. But are you sure I'LL be safe?"
			)
			(25
				(gCurRoom deleteRoomPlane: oGiantTorinCU)
				(gCurRoom addRoomPlane: oSmetanaCU)
				(gMessager say: 1 1 1 17 self) ; "Follow me."
			)
			(26
				(poTorinPicksUpSmetana init: setCycle: End self)
			)
			(27
				(voSmetanaBody dispose:)
				(poSmetanaJumps init: setCycle: End self)
			)
			(28
				(= ticks 60)
			)
			(29
				(gCurRoom deleteRoomPlane: oSmetanaCU)
				(poTorinPutsAwaySmetana init:)
				(= ticks 120)
			)
			(30
				(poTorinPutsAwaySmetana setCycle: CT 4 1 self)
			)
			(31
				(= ticks (poTorinPutsAwaySmetana cycleSpeed:))
			)
			(32
				(poTorinPutsAwaySmetana setCel: 5 setCycle: End self)
				(aoSmetana
					setLoop: 5 1
					init:
					xStep: 5
					setSpeed: 3
					setCycle: Fwd
					setMotion: MoveTo 650 233 self
				)
			)
			(33)
			(34
				(poTorinPutsAwaySmetana dispose:)
				(gEgo
					posn: 201 202
					loop: 8
					cel: 4
					init:
					normalize: 0 60100 8
				)
				(aoSmetana dispose:)
				(gGame handsOn:)
				(poLeenahInBondage init: setCycle: Fwd)
				(poPergolansHide init:)
				(gTheDoits add: oFleeTest)
				(goMusic1 setMusic: 30399)
				(oJungleAmbience fadeOut:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(oGasp stop:)
		(goSound1 stop:)
		(oScream stop:)
		(= gtTorin 0)
		(poTorinBreaksFree dispose:)
		(poPergolansRun dispose:)
		(poSmetana dispose:)
		(if (== (gCurRoom plane:) oSmetanaCU)
			(gCurRoom deleteRoomPlane: oSmetanaCU)
		)
		(if (== (gCurRoom plane:) oGiantTorinCU)
			(gCurRoom deleteRoomPlane: oGiantTorinCU)
		)
		(poTorinPutsAwaySmetana dispose:)
		(gEgo posn: 201 202 loop: 8 cel: 4 init: show: normalize: 0 60100 8)
		(aoSmetana dispose:)
		(poLeenahInBondage init: setCycle: Fwd)
		(poPergolansHide init:)
		(if (not (gTheDoits contains: oFleeTest))
			(gTheDoits add: oFleeTest)
		)
		(goMusic1 setMusic: 30399)
		(oJungleAmbience stop:)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soTorinLooksAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(poTorinBreaksFree
					posn: 189 229
					setLoop: 5
					setCel: 0
					setCycle: CT 6 1 self
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(poTorinBreaksFree setCycle: CT 9 1 self)
			)
			(4
				(= ticks 60)
			)
			(5
				(poTorinBreaksFree setCycle: CT 14 1 self)
			)
			(6
				(= ticks 60)
			)
			(7
				(poTorinBreaksFree setCycle: End self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance oFleeTest of Code
	(properties)

	(method (doit)
		(if (>= (gEgo x:) 975)
			(gEgo setScript: soPergolansFlee)
			(gTheDoits delete: self)
			(self dispose:)
		)
	)
)

(instance soPergolansFlee of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(oPergolaScrollPlane panTo: 612 0 self 1)
			)
			(1
				(goSound1 playSound: 30209)
				(poPergolansHide setCycle: End self)
			)
			(2
				(poLeenahInBondage addHotspotVerb: 41 73)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voSmetanaBody of View
	(properties
		x 367
		y 127
		view 30201
	)
)

(instance poTorinPicksUpSmetana of Prop
	(properties
		x 48
		y 239
		view 30201
		loop 2
	)
)

(instance aoSmetana of Actor
	(properties
		x 282
		y 207
		view 30201
		loop 5
	)
)

(instance poSmetanaJumps of Prop
	(properties
		x 367
		y 127
		view 30201
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 400)
	)
)

(instance poTorinPutsAwaySmetana of Prop
	(properties
		x 200
		y 200
		view 30201
		loop 4
	)
)

(instance toTorinRescuer of Talker
	(properties
		x 189
		y 230
		view 30200
		loop 6
		priority 231
	)
)

(instance toSmetana of Talker
	(properties
		x 367
		y 127
		view 30201
		loop 1
		priority 128
	)

	(method (init)
		(voSmetanaBody hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voSmetanaBody show:)
		(super dispose: &rest)
	)
)

(instance oSmetanaCU of Plane
	(properties
		picture 30203
	)

	(method (init)
		(= gtSmetana toSmetana)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(voSmetanaBody init:)
	)

	(method (dispose)
		(= gtSmetana 0)
		(super dispose: &rest)
	)
)

(instance oGiantTorinCU of Plane
	(properties
		picture 30211
	)

	(method (init)
		(= gtTorin toGiantTorin)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(voGiantTorinMouth init:)
	)

	(method (dispose)
		(= gtTorin 0)
		(super dispose: &rest)
	)
)

(instance voGiantTorinMouth of View
	(properties
		x 332
		y 181
		view 30210
	)
)

(instance toGiantTorin of Talker
	(properties
		x 332
		y 181
		view 30210
	)

	(method (init)
		(voGiantTorinMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voGiantTorinMouth show:)
		(super dispose: &rest)
	)
)

(instance poLeenahBlinks of Prop
	(properties
		x 1149
		y 264
		view 30202
		loop 8
	)

	(method (init)
		(super init: &rest)
		(self setPri: 265)
		(self setCycle: Blink 200)
	)
)

(instance poLeenahInBondage of Prop
	(properties
		noun 3
		case 3
		approachX 1096
		approachY 290
		x 1149
		y 264
		view 30202
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(poLeenahBlinks init:)
	)

	(method (hide)
		(poLeenahBlinks hide:)
		(super hide: &rest)
	)

	(method (show)
		(poLeenahBlinks show:)
		(super show: &rest)
	)

	(method (doVerb theVerb)
		((ScriptID 64017 0) set: 116) ; oFlags
		(switch theVerb
			(1 ; Do
				(if ((ScriptID 64017 0) test: 113) ; oFlags
					(= gtLeenah toLeenahLying)
					(gMessager say: 3 73 0 5) ; "(DECIDING TO TRUST HIM) Alright, then. Quick! Cut me loose."
					(return)
				)
				(if (== case 3)
					(gEgo setScript: soTorinMeetsLeenah)
				else
					(= gtLeenah toLeenahLying)
					(gEgo setScript: soTalkToLeenah 0 case)
				)
				(switch case
					(3
						(= case 4)
					)
					(4
						(= case 5)
					)
					(5
						(= case 6)
					)
				)
			)
			(41 ; ioLocket
				((ScriptID 64017 0) set: 117) ; oFlags
				(gEgo setScript: soTorinShowsClosedLocket)
			)
			(73 ; ioOpenLocket
				(gEgo setScript: soTorinShowsOpenLocket)
			)
			(51 ; ioKnife
				((ScriptID 64017 0) set: 120) ; oFlags
				(gCurRoom setScript: soTorinKnifesLeenah)
			)
		)
	)

	(method (dispose)
		(poLeenahBlinks dispose:)
		(super dispose: &rest)
	)
)

(instance soTalkToLeenah of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 1159 291 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gGame handsOff:)
				(gMessager say: 3 1 register 0 self)
			)
			(3
				(if (== register 6)
					(gMessager say: 3 1 7 0 self) ; "Oh, I could never do that. You're far too... too... (FINALLY GULPS IT OUT, BUT SOFTLY) too beautiful for me to leave you here."
				else
					(self cue:)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTorinMeetsLeenah of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 1159 291 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gGame handsOff:)
				(poLeenahInBondage hide:)
				(poLeenahScreams setCel: 0 init: setCycle: ForwardCounter 2)
				(gMessager say: 0 0 3 1 self) ; "(FEARFULLY) Oh, no. (SCREAM) NO!"
			)
			(3
				(gMessager say: 0 0 3 2 self) ; "It's okay. I won't hurt you!"
			)
			(4
				(gMessager say: 0 0 3 3 self) ; "(CONTINUE SCREAMING) No! NO!"
				(poLeenahScreams
					setCel: 0
					init:
					setCycle: ForwardCounter 2 self
				)
			)
			(5)
			(6
				(poLeenahScreams dispose:)
				(poLeenahInBondage show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poTorinKneels of Prop
	(properties
		x 1159
		y 291
		view 30202
		loop 3
	)
)

(instance poLeenahScreams of Prop
	(properties
		x 1149
		y 264
		view 30202
		loop 1
	)
)

(instance poPergolansHide of Prop
	(properties
		x 1132
		y 235
		view 30202
		loop 2
	)
)

(instance voLeenahLyingBody of View
	(properties
		x 1149
		y 264
		view 30202
		loop 5
	)
)

(instance toLeenahLying of Talker
	(properties
		x 1149
		y 264
		view 30202
		loop 7
		priority 265
	)

	(method (init)
		(poLeenahInBondage hide:)
		(voLeenahLyingBody init:)
		(super init: &rest)
	)

	(method (dispose)
		(poLeenahInBondage show:)
		(voLeenahLyingBody dispose:)
		(super dispose: &rest)
	)
)

(instance poTorinShowsLocket of Prop
	(properties
		x 1159
		y 291
		view 30203
	)
)

(instance poTorinPutsAwayLocket of Prop
	(properties
		x 1159
		y 291
		view 30203
		loop 3
	)
)

(instance voLeenahReactsToLocketBody of View
	(properties
		x 1149
		y 264
		view 30203
		loop 1
	)
)

(instance toLeenahReactsToLocket of Talker
	(properties
		x 1149
		y 264
		view 30203
		loop 4
		priority 265
	)

	(method (init)
		(voLeenahReactsToLocketBody init:)
		(poLeenahInBondage hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voLeenahReactsToLocketBody dispose:)
		(poLeenahInBondage show:)
		(super dispose: &rest)
	)
)

(instance voTorinShowingLocketBody of View
	(properties
		x 1159
		y 291
		view 30203
		loop 2
	)
)

(instance toTorinShowingLocket of Talker
	(properties
		x 1159
		y 291
		view 30203
		loop 5
		priority 292
	)

	(method (init)
		(voTorinShowingLocketBody init:)
		(poTorinShowsLocket hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voTorinShowingLocketBody dispose:)
		(poTorinShowsLocket show:)
		(super dispose: &rest)
	)
)

(instance soTorinShowsClosedLocket of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 1159 291 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(self setScript: soTorinDiscussesLocket self)
			)
			(3
				(= gtTorin toTorinShowingLocket)
				(= gtLeenah toLeenahReactsToLocket)
				(gMessager sayRange: 3 41 0 6 8 self) ; "What is this? Some sort of cruel joke? Is this trinket supposed to fool me? What are the Pergolans trying to pull? And to think for a moment there I started to trust you!"
			)
			(4
				(poTorinShowsLocket dispose:)
				(poTorinPutsAwayLocket setCel: 0 init: setCycle: End self)
			)
			(5
				(= gtTorin 0)
				(= gtLeenah 0)
				(poTorinPutsAwayLocket dispose:)
				(gEgo show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTorinDiscussesLocket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gtLeenah toLeenahLying)
				(gMessager sayRange: 3 41 0 3 4 self) ; "Hey. You're Leenah, aren't you? I just came from your homeland. I met your Mother and Father."
			)
			(1
				(= gtTorin 0)
				(gEgo hide:)
				(poTorinShowsLocket setCel: 0 init: setCycle: End self)
				(gMessager say: 3 41 0 5 self) ; "They told me to give you this...(PRODUCES LOCKET)"
			)
			(2)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soTorinDoesntDiscussLocket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(poTorinShowsLocket setCel: 0 init: setCycle: End self)
				(= gtLeenah toLeenahReactsToLocket)
				(gMessager say: 3 73 0 1 self) ; "Oh, look. That IS my dear sweet Father. And Di. Oh, how I miss them. Maybe you are from Escarpa. But...you're so tall. Who are you, anyway?"
			)
			(1)
			(2
				(self dispose:)
			)
		)
	)
)

(instance toNull of Narrator
	(properties)
)

(instance soTorinShowsOpenLocket of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 1159 291 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(if ((ScriptID 64017 0) test: 117) ; oFlags
					(self setScript: soTorinDoesntDiscussLocket self)
				else
					(self setScript: soTorinDiscussesLocket self)
				)
			)
			(3
				(= gtTorin toTorinShowingLocket)
				(= gtLeenah toLeenahReactsToLocket)
				(if ((ScriptID 64017 0) test: 117) ; oFlags
					(gMessager say: 3 73 0 2 self) ; "My name is Torin, but I'm not from Escarpa. I'm from The Lands Above."
				else
					(gMessager sayRange: 3 73 0 1 2 self) ; "Oh, look. That IS my dear sweet Father. And Di. Oh, how I miss them. Maybe you are from Escarpa. But...you're so tall. Who are you, anyway?"
				)
				((ScriptID 64017 0) set: 119 117) ; oFlags
			)
			(4
				(gMessager say: 3 73 0 3 self) ; "Torin of The Lands Above: do you promise not to harm me?"
				(poTorinShowsLocket dispose:)
				(poTorinPutsAwayLocket setCel: 0 init: setCycle: End self)
			)
			(5)
			(6
				(poTorinPutsAwayLocket dispose:)
				(gEgo get: ((ScriptID 64001 0) get: 32)) ; oInvHandler, ioOpenLocket
				(gEgo show:)
				(= gtTorin 0)
				(gMessager sayRange: 3 73 0 4 9 self) ; "I swear. (EARNESTLY) At present, I can think of nothing worse!"
			)
			(7
				(gEgo
					setMotion:
						PolyPath
						(poTorinKneels x:)
						(poTorinKneels y:)
						self
				)
			)
			(8
				(gEgo setHeading: 45 self)
			)
			(9
				(= gtTorin toNull)
				(gMessager say: 3 73 0 10 self) ; "That's just it. I didn't bring a knife.... Some hero I am. Well, hold still. Here goes."
				(= ticks 1)
			)
			(10
				(= ticks 90)
			)
			(11
				(gEgo hide:)
				(= gtTorin 0)
				(poTorinKneels setCel: 0 init: setCycle: End self)
			)
			(12)
			(13
				(gMessager say: 3 73 0 11 self) ; "(SOFTLY, WHISPERING) Then, I'll tell you a little secret. All this time, I've had a knife hidden in my boot! But they tied me up before I regained consciousness."
			)
			(14
				(poTorinKneels setCycle: Beg self)
			)
			(15
				(poTorinKneels dispose:)
				(gEgo show:)
				(gEgo setMotion: PolyPath 1159 291 self)
			)
			(16
				(gEgo setHeading: 45 self)
			)
			(17
				(= gtLeenah 0)
				(foKnife init:)
				(poLeenahInBondage deleteHotspotVerb: 1 41 73)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foKnife of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self myPriority: (+ 1 (poLeenahInBondage priority:)))
		(= nsTop 240)
		(= nsBottom 265)
		(= nsLeft 1073)
		(= nsRight 1112)
		(= approachX 1096)
		(= approachY 290)
	)

	(method (doVerb)
		(gEgo setScript: soTorinGetsKnife)
		(self dispose:)
	)
)

(instance soTorinGetsKnife of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(foKnife approachX:)
						(foKnife approachY:)
						self
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(self setScript: (ScriptID 64007 1) self self) ; soEgoGetLow
			)
			(4
				(gEgo get: ((ScriptID 64001 0) get: 34)) ; oInvHandler, ioKnife
				((ScriptID 64017 0) set: 113) ; oFlags
			)
			(5
				(foKnife dispose:)
				(poLeenahInBondage addHotspotVerb: 51 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poTorinCuts of Prop
	(properties
		x 1126
		y 290
		view 30204
	)
)

(instance poLeenahSitsUp of Prop
	(properties
		x 1144
		y 254
		view 30204
		loop 1
	)
)

(instance toLeenahSitting of Talker
	(properties
		x 1144
		y 254
		view 30204
		loop 2
		priority 255
	)
)

(instance poLeenahRopes of Prop
	(properties
		x 1149
		y 264
		view 30204
		loop 3
	)
)

(instance oKissingMusic of TPSound
	(properties
		type 1
	)
)

(instance soTorinKnifesLeenah of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 1126 290 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(poTorinCuts setCel: 0 init: setCycle: CT 14 1 self)
				(gEgo hide:)
				(gMessager say: 4 1 0 1) ; "Now hold still. I wouldn't want to cut you..."
			)
			(3
				(goSound1 playSound: 30301)
				(poTorinCuts setCycle: End self)
				(poLeenahInBondage dispose:)
				(poLeenahSitsUp setCel: 0 init:)
				(poLeenahRopes setCel: 0 init: setCycle: End self)
			)
			(4)
			(5
				(goMusic1 setMusic: 0)
				(oKissingMusic setMusic: 30398)
				(gEgo get: ((ScriptID 64001 0) get: 34)) ; oInvHandler, ioKnife
				(= ticks 180)
			)
			(6
				(poLeenahRopes setPri: 250)
				(poLeenahSitsUp setCycle: End self)
			)
			(7
				(= ticks 180)
			)
			(8
				(= gtLeenah toLeenahSitting)
				(gMessager kill:)
				(gMessager say: 4 1 0 2 self) ; "Oh. Thank you, Torin. That was horrible."
			)
			(9
				(= gtLeenah 0)
				(poTorinCuts dispose:)
				(poLeenahSitsUp dispose:)
				(poLeenahRopes dispose:)
				(gCurRoom addRoomPlane: oBLT)
				(poTorinOffers init:)
				(poLeenahSmiles setCel: 0 init:)
				(= ticks 1)
			)
			(10
				(= ticks 180)
			)
			(11
				(poLeenahSmiles setCycle: End self)
			)
			(12
				(= ticks 180)
			)
			(13
				(poTorinOffers dispose:)
				(poLeenahSmiles dispose:)
				(poAlmostKiss setCel: 0 init: setCycle: End self)
				(gMessager say: 4 1 0 3 self) ; "Here. Here's your locket."
			)
			(14)
			(15
				(gEgo put: ((ScriptID 64001 0) get: 31)) ; oInvHandler, ioLocket
				(gEgo put: ((ScriptID 64001 0) get: 32)) ; oInvHandler, ioOpenLocket
				(= ticks 120)
			)
			(16
				(poAlmostKiss setLoop: 3 setCel: 0 setCycle: CT 20 1 self)
				(oKissingMusic stop:)
				(goSound1 playSound: 30304 coGiggle)
			)
			(17
				(= ticks (poAlmostKiss cycleSpeed:))
			)
			(18
				(poAlmostKiss setCel: 21 setCycle: CT 24 1 self)
				(poLeenahSmiles setLoop: 4 setCel: 0 posn: 74 314 init:)
			)
			(19
				(= ticks (poAlmostKiss cycleSpeed:))
			)
			(20
				(poAlmostKiss setCel: 25 setCycle: End self)
				(poBoogleInterrupts setCel: 0 init: setCycle: End self)
			)
			(21)
			(22
				(poBoogleInterrupts dispose:)
				(oJungleAmbience setAmbient: 30210)
				(poTorinOffers setLoop: 6 setCel: 0 posn: 1 314 init: hide:)
				(= gtTorin toTorinSmirk)
				(= ticks 1)
			)
			(23
				(goSound1 stop:)
				(poAlmostKiss dispose:)
				(poTorinOffers show:)
				(gMessager say: 4 1 0 5 self) ; "Oh, Boogle! (EMBARRASSED) Here. Let me help you up."
			)
			(24
				(voTorinSmirkHead dispose:)
				(voTorinSmirkBody dispose:)
				(poLeenahSmiles
					setLoop: 7
					setCel: 0
					posn: 423 314
					setCycle: End self
				)
				(poTorinOffers show: setCycle: End)
			)
			(25
				(= gtLeenah toLeenahConcerned)
				(gMessager say: 4 1 0 6 self) ; "(NOTICES CUTS) Oh, wait. Look at your arms. You're bleeding!"
			)
			(26
				(poTorinOffers cycleSpeed: 7 setCycle: Beg self)
			)
			(27
				(gMessager say: 4 1 0 7 self) ; "What? Oh, I'm okay. I dropped a long ways through the trees before I landed on this soft loam. I must have caught some branches on the way down. It's nothing."
			)
			(28
				(gCurRoom deleteRoomPlane: oBLT)
				(= gtTorin 0)
				(= gtLeenah 0)
				(poTorinAndLeenah setCel: 0 init:)
				(poLeenahRopes init: setCel: (poLeenahRopes lastCel:))
				(= ticks 60)
			)
			(29
				(poTorinAndLeenah setCycle: End self)
			)
			(30
				(poTorinAndLeenah setLoop: 1 setCel: 0 setCycle: End self)
				(gMessager say: 4 1 0 8 self) ; "Nonsense. Come over here. I'm sure I've heard a stream this way."
			)
			(31)
			(32
				(gCurRoom newRoom: 30300) ; roTorinAndLeenah
			)
		)
	)
)

(instance coGiggle of CueMe
	(properties)

	(method (cue)
		(goSound1 playSubtitledSound: 30206 4 1 0 4)
	)
)

(instance poTorinOffers of Prop
	(properties
		x 71
		y 314
		view 30205
		cycleSpeed 8
	)
)

(instance poLeenahSmiles of Prop
	(properties
		x 417
		y 317
		view 30205
		loop 1
		cycleSpeed 8
	)
)

(instance poAlmostKiss of Prop
	(properties
		x 71
		y 314
		view 30205
		loop 2
		cycleSpeed 8
	)
)

(instance poBoogleInterrupts of Prop
	(properties
		x 212
		y 314
		view 30205
		loop 5
		cycleSpeed 8
	)
)

(instance voTorinSmirkBody of View
	(properties
		x -7
		y 314
		view 30206
	)
)

(instance voTorinSmirkHead of View
	(properties
		x -7
		y 314
		view 30206
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 315)
	)
)

(instance toTorinSmirk of Talker
	(properties
		x -7
		y 314
		view 30206
		loop 1
		priority 315
	)

	(method (init)
		(poTorinOffers hide:)
		(voTorinSmirkBody init:)
		(super init: &rest)
	)

	(method (dispose)
		(voTorinSmirkHead init:)
		(super dispose: &rest)
	)
)

(instance voLeenahConcernedBody of View
	(properties
		x 500
		y 301
		view 30206
		loop 2
	)
)

(instance toLeenahConcerned of Talker
	(properties
		x 500
		y 301
		view 30206
		loop 3
		priority 302
	)

	(method (init)
		(poLeenahSmiles hide:)
		(voLeenahConcernedBody init:)
		(super init: &rest)
	)

	(method (dispose)
		(poLeenahSmiles show:)
		(voLeenahConcernedBody dispose:)
		(super dispose: &rest)
	)
)

(instance poTorinAndLeenah of Prop
	(properties
		x 1126
		y 273
		view 30208
	)
)

(instance oPergolaScrollPlane of TorScrollPlane
	(properties
		priority 20
	)

	(method (addPics)
		(AddPicAt self 30200 0 0)
		(AddPicAt self 30201 632 0)
	)
)

(instance oBLT of Plane
	(properties
		picture 30202
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
	)
)

(instance oJungleAmbience of TPSound
	(properties)
)

(instance roPergolaCity of TPRoom
	(properties)

	(method (init)
		(super init: &rest)
		(= plane
			(oPergolaScrollPlane init: 1264 (gThePlane getHeight:) yourself:)
		)
		(goMusic1 setMusic: 30100)
		(oJungleAmbience setAmbient: 30299)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 1263 291 1045 289 1029 228 644 211 426 196 0 186 0 316
					yourself:
				)
		)
		(gGame handsOff:)
		((ScriptID 64017 0) set: 115) ; oFlags
		(poTorinBreaksFree init:)
		(poPergolansRun init:)
		(gCurRoom setScript: soTorinBreaksFree)
		(FadeToBlack 0 10 soTorinBreaksFree)
	)

	(method (gimme)
		(gCurRoom setScript: soTorinKnifesLeenah)
	)
)

