;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 830)
(include sci.sh)
(use Main)
(use Teller)
(use n026)
(use GloryTalker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm830 0
	reeshaTalker 1
	reeshaBTalker 2
)

(local
	local0
	local1
	[local2 5] = [0 -1 -2 -3 999]
	[local7 2]
	[local9 9] = [0 -8 -7 -6 -5 -11 -12 -13 999]
	[local18 2]
)

(instance rm830 of Rm
	(properties
		noun 9
		picture 830
	)

	(method (init)
		(= [local7 0] @local2)
		(= [local18 0] @local9)
		(egoTell init: gEgo @local9 @local18)
		(gEgo setScale: scaleX: 128 scaleY: 128 init: noun: 2 normalize:)
		(super init:)
		(gTheIconBar disable: 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 39 189 319 189 259 138 287 138 309 138 309 130 270 130 245 130 163 90 61 90 38 189
					yourself:
				)
		)
		(sky init:)
		(if (IsFlag 57)
			(= local0 1)
		)
		(SetFlag 57)
		(switch local0
			(0
				(gLongSong number: 830 setLoop: -1 play: 127)
				(reesha init:)
				(rubble init: stopUpd:)
				(gCurRoom setScript: eventOne)
			)
			(1
				(cond
					((and (== gPrevRoomNum 550) (== global155 0)) ; combatRm
						(gCurRoom setScript: egoIsDead)
					)
					((== gPrevRoomNum 550) ; combatRm
						(gLongSong number: 830 setLoop: -1 play: 127)
						(reesha noun: 1 init:)
						(rubble init: stopUpd:)
						(gEgo changeGait: 0) ; walking
						(self setScript: reeshaCollapses)
					)
					(else
						(gLongSong number: 832 setLoop: -1 play: 127)
						(reesha
							view: 834
							loop: 0
							setCel: 5
							x: 104
							y: 181
							noun: 1
							init:
							addToPic:
						)
						((ScriptID 35 1) ; Rakeesh
							view: 964
							setScale:
							loop: 0
							cel: 3
							x: 59
							y: 180
							init:
							addToPic:
						)
						((ScriptID 39 1) ; Yesufu
							view: 989
							setScale:
							loop: 2
							cel: 0
							x: 106
							y: 110
							init:
							addToPic:
						)
						((ScriptID 36 1) ; Johari
							view: 974
							setScale:
							loop: 2
							cel: 0
							x: 124
							y: 113
							init:
							addToPic:
						)
						((ScriptID 34 1) ; Uhura
							view: 969
							setScale:
							loop: 2
							cel: 0
							x: 220
							y: 127
							init:
							addToPic:
						)
						((ScriptID 40 1) ; Harami
							view: 838
							x: 61
							y: 111
							setScale:
							init:
							addToPic:
						)
						(gCurRoom setScript: eventTwo)
					)
				)
			)
		)
	)

	(method (dispose)
		(LoadMany 0 991 34 35 36 39 40 41 939)
		(super dispose:)
	)
)

(instance egoIsDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(reesha view: 837 cel: 9 init:)
				(= seconds 2)
			)
			(1
				(gEgo view: 6 cel: 0 loop: 0 setCycle: End self)
			)
			(2
				(EgoDead) ; "It's all over for now. Please try again."
			)
		)
	)
)

(instance demonTaunts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gCurRoom setScript: closeCombat)
			)
		)
	)
)

(instance eventTwo of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 6)
				(gEgo
					x: 298
					y: 133
					solvePuzzle: 338 25
					setMotion: MoveTo 168 145 self
				)
			)
			(1
				((ScriptID 41 1) ; Manu
					setScale:
					init:
					x: 298
					y: 133
					setCycle: Walk
					setMotion: MoveTo 198 161 self
				)
			)
			(2
				(if (IsFlag 150)
					(gMessager say: 4 6 10 0 self) ; "You sense the immediate presence of danger."
				else
					(self cue:)
				)
			)
			(3
				(gMessager say: 6 6 17 0 self) ; "Man-friend! Man-friend! Happy, happy, you come back! Man-friend come back!"
			)
			(4
				(gMessager say: 5 6 18 0 self) ; "The Demons were drawn back into their own world when you closed off the World Gate. This land, and all its people, are safe, thanks to you."
			)
			(5
				(gLongSong changeTo: 833)
				(gEgo view: 881 setCycle: Fwd)
				(= seconds 5)
			)
			(6
				(gMessager say: 5 6 19 0 self) ; "This is dark magic!"
			)
			(7
				(= temp0 (Memory memALLOC_CRIT 50))
				(= temp1 (Message msgGET 830 5 6 3 1 temp0)) ; "%s!"
				(gMessager sayFormat: temp1 temp0 @global157)
				(Memory memFREE temp0)
				(= seconds 3)
			)
			(8
				(gCurRoom newRoom: 880)
				(self dispose:)
			)
		)
	)
)

(instance blastDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rubble loop: 2 setCycle: End self)
				(gLongSong2 number: 930 play: 127)
			)
			(1
				(rubble dispose:)
				(self dispose:)
			)
		)
	)
)

(instance useDispell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 9 setLoop: 3 setCycle: End self)
			)
			(1
				(gEgo
					view: 5
					drop: 16 ; theDispell
					normalize:
					addHonor: 40
					solvePuzzle: 337 10
				)
				(reesha setScript: reeshaCollapses)
				(self dispose:)
			)
		)
	)
)

(instance closeCombat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 6 9 0 self) ; "Fool, fight or die!"
			)
			(1
				(= global365 845)
				(gCurRoom newRoom: 550) ; combatRm
			)
		)
	)
)

(instance reeshaCollapses of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(reesha view: 837 loop: 0 cel: 9 setCycle: Beg self)
				(gLongSong2 number: 932 setLoop: 1 play:)
			)
			(1
				(reesha view: 833 loop: 0 cel: 5 setCycle: Beg self)
			)
			(2
				(demonCloud
					x: 146
					y: 125
					cel: 0
					setLoop: 1
					init:
					setCycle: End self
				)
			)
			(3
				(demonCloud dispose:)
				(DrawPic (gCurRoom picture:) 9)
				(= seconds 3)
			)
			(4
				(HandsOn)
				(gCurRoom setScript: portalOpens)
				(self dispose:)
			)
		)
	)
)

(instance portalOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable:)
				(SetPort 0 0 190 200)
				(= seconds 2)
			)
			(1
				(gLongSong2 number: 831 setLoop: 1 play:)
				(portal loop: 2 x: 40 y: 85 init: cycleSpeed: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(2
				(portal setLoop: 3 x: 46 y: 11 init:)
				(DrawPic (gCurRoom picture:) 9)
				(SetPort 0 0 320 200)
				((ScriptID 34 1) ; Uhura
					setScale:
					x: 76
					y: 94
					init:
					setCycle: Walk
					setMotion: MoveTo 75 133 self
				)
				(gLongSong number: 834 setLoop: 1 play: self)
			)
			(3)
			(4
				(portal stopUpd:)
				((ScriptID 34 1) ; Uhura
					view: 969
					setScale:
					stopUpd:
					setCycle: 0
					ignoreActors: 1
				)
				((ScriptID 36 1) ; Johari
					view: 975
					x: 76
					y: 94
					setScale:
					init:
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 154 113 self
				)
				(gLongSong number: 835 setLoop: 1 play: self)
			)
			(5
				((ScriptID 36 1) setCycle: 0 setHeading: 180) ; Johari
			)
			(6
				((ScriptID 39 1) ; Yesufu
					x: 76
					y: 94
					setScale:
					init:
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 136 110 self
				)
				(gLongSong number: 836 setLoop: 1 play: self)
			)
			(7
				((ScriptID 39 1) setCycle: 0 setHeading: 180 self) ; Yesufu
			)
			(8
				((ScriptID 36 1) view: 974 ignoreActors: 1 stopUpd:) ; Johari
			)
			(9
				((ScriptID 39 1) view: 989 ignoreActors: 1 stopUpd:) ; Yesufu
				((ScriptID 40 1) ; Harami
					x: 76
					y: 94
					init:
					setCycle: Walk
					setMotion: MoveTo 38 169 self
				)
				(gLongSong number: 837 setLoop: 1 play: self)
			)
			(10)
			(11
				((ScriptID 40 1) view: 838 setCycle: 0 ignoreActors: 1 stopUpd:) ; Harami
				((ScriptID 35 1) ; Rakeesh
					setScale:
					view: 967
					setLoop: 0
					x: 76
					y: 94
					init:
					setCycle: Walk
					setMotion: MoveTo 115 135 self
				)
				(gLongSong number: 280 setLoop: -1 play:)
			)
			(12
				(gMessager say: 5 6 8 0 self) ; "Reeshaka!"
			)
			(13
				(portal dispose:)
				(DrawPic (gCurRoom picture:) 9)
				(= seconds 2)
			)
			(14
				((ScriptID 39 1) addToPic:) ; Yesufu
				((ScriptID 36 1) addToPic:) ; Johari
				((ScriptID 34 1) addToPic:) ; Uhura
				((ScriptID 40 1) addToPic:) ; Harami
				((ScriptID 35 1) view: 965 loop: 0 cel: 0 setCycle: End self) ; Rakeesh
				(gLongSong2 number: 12 setLoop: 1 play:)
			)
			(15
				(gMessager say: 5 6 14 0 self) ; "By the power within and without, may you be healed!"
			)
			(16
				(if (not (IsFlag 159))
					(gMessager say: 5 6 22 0 self) ; "I have brought with me a former thief who needed our help. This is Harami."
				else
					(self cue:)
				)
			)
			(17
				((ScriptID 35 1) setCycle: Beg self) ; Rakeesh
			)
			(18
				(reesha setCycle: End self)
			)
			(19
				((ScriptID 35 1) setCycle: 0 addToPic:) ; Rakeesh
				(reesha ignoreActors: 1 addToPic:)
				(gMessager say: 5 6 15 0 self) ; "Kreesha opened a portal as soon as she could locate my friend here."
			)
			(20
				(gLongSong changeTo: 720)
				((ScriptID 41 1) ; Manu
					x: 40
					y: -5
					view: 985
					setLoop: 5
					init:
					ignoreHorizon: 1
					setCycle: Rev
					setMotion: MoveTo 41 144 self
				)
			)
			(21
				((ScriptID 41 1) ; Manu
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 116 148 self
				)
				(gLongSong changeTo: 830)
			)
			(22
				(gMessager say: 6 6 8 0 self) ; "Manu here. Manu come. Help man-friend. Not let bad things get man-friend."
			)
			(23
				(gMessager say: 5 6 16 0 self) ; "The way you must all go lies through that blocked door. I sense powerful Demonic magic behind there, so be careful."
			)
			(24
				(self setScript: blastDoor self)
			)
			(25
				(if (== gHeroType 0) ; Fighter
					(gEgo get: 45) ; theMagicSpear
					(gMessager say: 7 6 20 0 self) ; "Hero, not only have I come to be fighting at your side, but I bring you a weapon to destroy the Demon Wizard."
				else
					(self cue:)
				)
			)
			(26
				(gMessager say: 5 6 1 0 self) ; "Go quickly! The Demons are trying to get in here. Uhura and I will fight them off!"
			)
			(27
				(gEgo ignoreActors: 1 setMotion: PolyPath 290 133 self)
				((ScriptID 41 1) ignoreActors: 1 setMotion: MoveTo 294 133) ; Manu
			)
			(28
				(gTheIconBar enable:)
				(gCurRoom newRoom: 840)
				(self dispose:)
			)
		)
	)
)

(instance eventOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					x: 160
					y: 190
					setScale:
					solvePuzzle: 336 3
					setMotion: MoveTo 160 180 self
				)
			)
			(1
				(reesha setCycle: End self)
			)
			(2
				(reesha loop: 1 setCycle: End self)
			)
			(3
				(reesha loop: 2 setCycle: End self)
			)
			(4
				(gMessager say: 1 6 8 0 self) ; "You... you're not a Demon. Who are you? How did you get in here?"
			)
			(5
				(if (== gHeroType 3) ; Paladin
					(gMessager say: 4 6 10) ; "You sense the immediate presence of danger."
				)
				(demonCloud x: 146 y: 160 init: moveSpeed: 0 setCycle: End self)
			)
			(6
				(demonCloud loop: 1 setCycle: End self)
			)
			(7
				(demonCloud dispose:)
				(= local1 1)
				(reesha view: 837 loop: 0 cel: 0 setCycle: End self)
				(gLongSong2 number: 932 setLoop: 1 play:)
			)
			(8
				(gMessager say: 3 6 8 0 self) ; "Greetings, human. My master sends his regrets, but he is too busy to speak with you right now."
			)
			(9
				(HandsOn)
				(gTheIconBar disable: 1 4)
				(= seconds 10)
			)
			(10
				(gCurRoom setScript: closeCombat)
				(self dispose:)
			)
		)
	)
)

(instance rubble of Prop
	(properties
		x 209
		y 140
		view 830
	)
)

(instance reesha of Prop
	(properties
		x 145
		y 139
		noun 3
		view 833
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(26 ; theDispell
				(gCurRoom setScript: useDispell)
			)
			(2 ; Talk
				(gCurRoom setScript: closeCombat)
			)
			(65 ; Rest
				(gMessager say: 4 6 21) ; "Sleeping here would not be wise."
			)
			(4 ; Do
				(gCurRoom setScript: closeCombat)
			)
			(81 ; flameDartSpell
				(gCurRoom setScript: closeCombat)
			)
			(83 ; forceBoltSpell
				(gCurRoom setScript: closeCombat)
			)
			(88 ; lightningBallSpell
				(gCurRoom setScript: closeCombat)
			)
			(33 ; theRocks
				(gCurRoom setScript: closeCombat)
			)
			(20 ; theDaggers
				(gCurRoom setScript: closeCombat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance demonCloud of Actor
	(properties
		x 52
		y 189
		view 836
		loop 1
		signal 16384
	)
)

(instance portal of Prop
	(properties
		x 46
		y 11
		view 830
		loop 3
		signal 16384
	)
)

(instance sky of Feature
	(properties
		x 142
		y 13
		noun 8
		nsTop -2
		nsLeft 117
		nsBottom 28
		nsRight 167
		sightAngle 180
	)
)

(instance reeshaTell of Teller ; UNUSED
	(properties)

	(method (doChild)
		(switch query
			(-1
				(gCurRoom setScript: closeCombat)
			)
			(-3
				(gCurRoom setScript: closeCombat)
			)
			(-2
				(gCurRoom setScript: closeCombat)
			)
		)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(26 ; theDispell
				(gCurRoom setScript: useDispell)
			)
			(2 ; Talk
				(gCurRoom setScript: closeCombat)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-5 ; "Rakeesh"
				(not local1)
				-8
				(not local1)
				-6 ; "Rescue"
				(not local1)
				-7 ; "Good-bye"
				(not local1)
				-11 ; "Greet"
				(== local1 1)
				-13 ; "Rescue"
				(== local1 1)
				-12 ; "Good-bye"
				(== local1 1)
		)
	)

	(method (doChild)
		(switch query
			(-11 ; "Greet"
				(gEgo setScript: closeCombat)
			)
			(-12 ; "Good-bye"
				(gEgo setScript: closeCombat)
			)
			(-13 ; "Rescue"
				(gCurRoom setScript: demonTaunts)
			)
			(else
				(return query)
			)
		)
	)
)

(instance reeshaTalker of GloryTalker
	(properties
		x 205
		y 10
		view 832
		loop 1
		talkWidth 260
		back 57
		textX -180
		textY 100
		backColor 9
	)

	(method (init)
		(super init: reeshaBust reeshaEyes reeshaMouth &rest)
	)
)

(instance reeshaMouth of Prop
	(properties
		nsTop 49
		nsLeft 20
		view 832
	)
)

(instance reeshaEyes of Prop
	(properties
		nsTop 40
		nsLeft 19
		view 832
		loop 2
	)
)

(instance reeshaBust of View
	(properties
		nsTop 27
		nsLeft 19
		view 832
		loop 3
	)
)

(instance reeshaBTalker of GloryTalker
	(properties
		x 10
		y 10
		view 822
		loop 1
		talkWidth 260
		back 57
		textX 15
		textY 100
		backColor 9
	)

	(method (init)
		(super init: reeshaBBust reeshaBEyes reeshaBMouth &rest)
	)
)

(instance reeshaBMouth of Prop
	(properties
		nsTop 31
		nsLeft 60
		view 822
	)
)

(instance reeshaBEyes of Prop
	(properties
		nsTop 24
		nsLeft 49
		view 822
		loop 2
	)
)

(instance reeshaBBust of View
	(properties
		nsTop 14
		nsLeft 53
		view 822
		loop 3
	)
)

