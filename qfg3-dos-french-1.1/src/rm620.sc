;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use Teller)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm620 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	[local9 12] = [0 -8 -4 -9 -2 -3 -1 -10 -11 -12 -14 999]
	[local21 3]
	[local24 8] = [0 -4 -3 -6 -7 -5 -13 999]
	[local32 2]
	[local34 8] = [0 -1 -2 -3 -4 -5 -13 999]
	[local42 2]
	[local44 9] = [0 -10 -4 -3 -6 7 -13 -5 999]
	[local53 5]
	[local58 3] = [0 -5 999]
	[local61 2]
)

(procedure (localproc_0)
	(leaderTell init: leader @local34 @local42)
	(egoTell init: gEgo @local9 @local21)
	(shamanTell init: shaman @local44 @local53)
	(johariTell init: (ScriptID 36 1) @local24 @local32) ; Johari
	((= local7 (View new:))
		view: 620
		loop: 2
		cel: 0
		x: 43
		y: 111
		signal: 16384
		noun: 4
		actions: leopManTell
		init:
	)
	(leopManTell init: local7 @local58 @local61)
	((View new:)
		view: 620
		loop: 2
		cel: 0
		x: 108
		y: 128
		signal: 16384
		noun: 4
		actions: leopManTell
		init:
	)
	((View new:)
		view: 620
		loop: 2
		cel: 1
		x: 205
		y: 127
		signal: 16384
		noun: 4
		actions: leopManTell
		init:
	)
	((View new:)
		view: 620
		loop: 2
		cel: 3
		x: 255
		y: 115
		signal: 16384
		noun: 4
		actions: leopManTell
		init:
	)
	((View new:)
		view: 620
		loop: 2
		cel: 3
		x: 210
		y: 103
		signal: 16384
		noun: 4
		actions: leopManTell
		init:
	)
	(fire init: setCycle: Fwd)
	((ScriptID 36 1) ; Johari
		view: 620
		loop: 4
		x: 170
		y: 98
		cel: 1
		init:
		noun: 2
		signal: 16384
	)
	(gEgo
		x: 188
		y: 107
		loop: 1
		cel: 0
		setScale: 140
		noun: 5
		init:
		normalize:
	)
	(throne init:)
	(platform init:)
)

(procedure (localproc_1)
	(dancer1 setCel: 0 setCycle: End)
	(dancer2 setCel: 0 setCycle: End)
	(dancer3 setCel: 0 setCycle: End)
	(dancer4 setCel: 0 setCycle: End)
	(dancer7 setCel: 0 setCycle: End)
	(dancer8 setCel: 0 setCycle: End)
)

(procedure (localproc_2)
	(egoAndJohari init:)
	(drummer1 init:)
	(drummer2 init:)
	(drummer3 init:)
	(dancer1 setCycle: Fwd init:)
	(dancer2 setCycle: Fwd init:)
	(dancer3 setCycle: Fwd init:)
	(dancer4 setCycle: Fwd init:)
	(dancer7 setCycle: Fwd init:)
	(dancer8 setCycle: Fwd init:)
)

(class Wcycler of Cycle
	(properties
		head 0
		tail 10
		flash 0
	)

	(method (init param1 param2 param3)
		(super init: param1)
		(self head: param2)
		(if (> param3 (client lastCel:))
			(self tail: (client lastCel:))
		else
			(self tail: param3)
		)
	)

	(method (doit &tmp temp0)
		(if (not flash)
			(client hide:)
			(= flash 1)
		else
			(= flash 0)
			(if (> (= temp0 (self nextCel:)) (self tail:))
				(self cycleDone:)
			else
				(client show:)
				(client cel: temp0)
			)
		)
	)

	(method (cycleDone)
		(client cel: head)
	)
)

(instance rm620 of Rm
	(properties
		noun 11
		picture 620
		vanishingY -25
	)

	(method (init)
		(= [local42 0] @local34)
		(= [local21 0] @local9)
		(= [local32 0] @local24)
		(= [local53 0] @local44)
		(= [local61 0] @local58)
		(cond
			((== gPrevRoomNum 420)
				(= local0 1)
			)
			((== gPrevRoomNum 650)
				(= local0 4)
			)
			((not (IsFlag 37))
				(= local0 0)
			)
			((gEgo has: 46) ; theMagicDrum
				(= local0 2)
			)
			(else
				(= local0 3)
			)
		)
		(switch local0
			(0
				(LoadMany rsVIEW 620 621 622)
				(localproc_2)
				(SetFlag 37)
				(super init: &rest)
				(gCurRoom setScript: changeDance)
				(gLongSong number: 620 setLoop: 1 play: self)
			)
			(1
				(if (not (IsFlag 165))
					(shaman init: noun: 3 stopUpd:)
				)
				(leader init: noun: 1)
				(if (!= gEgoGait 0) ; walking
					(gEgo changeGait: 0) ; walking
				)
				(gLongSong number: 480 setLoop: 1 play:)
				(localproc_0)
				(super init: &rest)
				(gCurRoom setScript: backTarna)
			)
			(2
				(LoadMany rsVIEW 605 606 625 626)
				(shaman init: noun: 3 stopUpd:)
				(leader init: noun: 1)
				(if (!= gEgoGait 0) ; walking
					(gEgo changeGait: 0) ; walking
				)
				(gLongSong number: 480 setLoop: -1 play:)
				(localproc_0)
				(super init: &rest)
				(gCurRoom setScript: enterWithDrum)
			)
			(3
				(LoadMany rsVIEW 605 606 625 626)
				(leader init: x: 83 y: 94 noun: 1)
				(effect init: show:)
				(localproc_0)
				(gLongSong number: 480 setLoop: 1 play:)
				(super init: &rest)
				(gCurRoom setScript: muEnter)
			)
			(4
				(LoadMany rsVIEW 605 606 625 626)
				(leader init: x: 83 y: 94 signal: 16384 noun: 1)
				(localproc_0)
				(gLongSong number: 480 setLoop: 1 play:)
				(super init: &rest)
				(gCurRoom setScript: eventFour)
			)
		)
	)

	(method (cue)
		(switch (gLongSong prevSignal:)
			(20
				(drummer1 setCycle: End)
				(drummer2 setCycle: End)
				(drummer3 setCycle: End)
				(= local8 1)
				(localproc_1)
			)
			(30
				(= local8 0)
				(drummer1 setCycle: Fwd)
				(drummer2 setCycle: Fwd)
				(drummer3 setCycle: Fwd)
			)
			(-1
				(changeDance cue:)
				(gLongSong number: 622 play:)
			)
			(10
				(if local8
					(localproc_1)
				)
			)
		)
	)

	(method (dispose)
		(UnLoad 128 605)
		(UnLoad 128 606)
		(UnLoad 128 625)
		(UnLoad 128 626)
		(UnLoad 128 620)
		(UnLoad 128 621)
		(UnLoad 128 622)
		(LoadMany 0 36 44 43 956)
		(super dispose: &rest)
	)
)

(instance backTarna of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 5)
			)
			(1
				(gMessager say: 2 6 49 0 self) ; "Hero, it is time to present my father with the Drum of Magic."
			)
			(2
				(gEgo
					normalize:
					setMotion: MoveTo (+ (leader x:) 24) 107 self
					solvePuzzle: 298 20
				)
			)
			(3
				(Face gEgo leader self)
			)
			(4
				(= cycles 20)
			)
			(5
				(gEgo
					setCycle: Rev
					setLoop: 1
					setMotion: MoveTo 138 107 self
				)
			)
			(6
				(leader x: 99 y: 99 cel: 0 setLoop: 0 setCycle: End self)
				(gEgo setCycle: Walk setLoop: -1 normalize:)
			)
			(7
				(leader cel: 0 setLoop: 1 setCycle: End self)
			)
			(8
				(leader loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(9
				(gMessager say: 1 6 4 0 self) ; "Behold! The Drum of Magic!"
			)
			(10
				(= seconds 2)
			)
			(11
				(leader cycleSpeed: 12 setCycle: CT 7 1 self)
			)
			(12
				(leader setCycle: CT 11 1 self)
			)
			(13
				(leader setLoop: 3 setCycle: End self)
			)
			(14
				(gMessager say: 1 5 2 0 self) ; "Now that the Drum of Magic is returned, I can speak of peace with the cow people."
			)
			(15
				(gEgo drop: 46) ; theMagicDrum
				(= local3 1)
				(gEgo addHonor: 50)
				(gMessager say: 7 6 47 0 self) ; "Kreesha senses the return of the Drum of Magic and sends the magic portal for your journey back to Tarna."
			)
			(16
				(gCast eachElementDo: #hide)
				(DrawPic 0 9)
				(= seconds 1)
			)
			(17
				(= seconds 1)
			)
			(18
				(gMessager say: 7 6 48 0 self) ; "You travel to Tarna where Rakeesh anxiously awaits the peace conference."
			)
			(19
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance eventFour of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
				(fire setPri: 10)
			)
			(1
				(gMessager say: 1 2 14 0 self) ; "You have won the contest by out-spelling the Shaman and our gratitude by destroying the Demon."
			)
			(2
				(HandsOn 5 1 3 6)
				(self dispose:)
			)
		)
	)
)

(instance egoBows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 5)
			)
			(1
				(if (== local0 3)
					(self changeState: 4)
				else
					(gEgo setMotion: MoveTo 139 105 self)
				)
			)
			(2
				(Face gEgo leader self)
			)
			(3
				(= cycles 5)
			)
			(4
				(gEgo view: 32 setLoop: 1 cycleSpeed: 10 setCycle: End self)
			)
			(5
				(switch register
					(1
						(gMessager say: 5 6 19 0 self) ; "You greet the Leopardman leader."
					)
					(2
						(gMessager say: 5 6 16 0 self) ; "You again bow before the Leopardman leader."
					)
					(3
						(gMessager say: 5 6 31 0 self) ; "You greet the Shaman."
					)
					(4
						(gMessager say: 5 6 44 0 self) ; "You again bow before the Leopardman leader."
					)
				)
			)
			(6
				(gEgo setLoop: -1 cycleSpeed: 6 normalize: addHonor: 5)
				(HandsOn 5 1 3 6)
				(self dispose:)
			)
		)
	)
)

(instance changeDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local8 1)
				(= seconds 2)
			)
			(1
				(gMessager say: 2 2 10 0) ; "Now you will see some real magic."
			)
			(2
				(dancer1 loop: 1 cel: 0 setCycle: CT 3 1)
				(dancer4 loop: 3 cel: 0 setCycle: CT 2 1)
				(dancer7 loop: 1 cel: 0 setCycle: CT 3 1)
				(dancer8 loop: 1 cel: 0 setCycle: CT 3 1 self)
				(dancer2 loop: 3 cel: 0 setCycle: CT 2 1 self)
				(dancer3 loop: 3 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(dancer1 setCycle: Wcycler 3 4)
				(dancer4 setCycle: Wcycler 2 3)
				(dancer7 setCycle: Wcycler 3 4)
				(dancer8 setCycle: Wcycler 3 4)
				(dancer2 setCycle: Wcycler 2 3)
				(dancer3 setCycle: Wcycler 2 3)
				(= seconds 4)
			)
			(4
				(Palette palSET_INTENSITY 0 255 1000)
				(Palette palSET_INTENSITY 0 255 100)
				(dancer1 show: setCycle: End)
				(dancer4 show: setCycle: End)
				(dancer7 show: setCycle: End)
				(dancer8 show: setCycle: End)
				(dancer2 show: setCycle: End)
				(dancer3 show: setCycle: End)
				(= seconds 2)
			)
			(5
				(gMessager say: 2 2 15 0 self) ; "Come, follow me."
			)
			(6
				(if (== gHeroType 2) ; Thief
					(gCurRoom newRoom: 630)
				else
					(gCurRoom newRoom: 600)
				)
			)
		)
	)
)

(instance muEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fire setPri: 10)
				(= cycles 10)
			)
			(1
				(gMessager say: 1 2 27 0 self) ; "Johari, why have you brought this outsider to our village?"
			)
			(2
				(gMessager say: 2 2 28 0 self) ; "Okay, hero, say something about magic."
			)
			(3
				(HandsOn 5 1 3 6)
				(self dispose:)
			)
		)
	)
)

(instance shamanEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(effect show:)
				(= cycles 5)
			)
			(1
				(gMessager say: 5 5 10 0 self) ; "You tell about your skills as a Wizard."
			)
			(2
				(gLongSong2 number: 831 play: setLoop: -1)
				(effect cycleSpeed: 0 setCycle: ForwardCounter 3 self)
			)
			(3
				(shaman
					view: 625
					loop: 0
					cel: 0
					x: 138
					y: 103
					priority: (- (effect priority:) 1)
					noun: 3
					init:
				)
				(shamanTell init: shaman @local44 @local53)
				(effect setCycle: End self)
			)
			(4
				(effect dispose:)
				(shaman setCycle: End self)
			)
			(5
				(shaman x: 145 y: 101 cel: 0 setLoop: 1 setCycle: CT 5 1 self)
			)
			(6
				(gMessager say: 3 6 32 0 self) ; "I am the Shaman. Who is this outsider that he dares claim he has magic?"
			)
			(7
				(shaman setCycle: CT 9 1 self)
			)
			(8
				(gMessager say: 2 2 33 0 self) ; "He is a very powerful Wizard from far away. You will see his power!"
			)
			(9
				(= local1 1)
				(= local2 0)
				(HandsOn 5 1 3 6)
				(self dispose:)
			)
		)
	)
)

(instance giveSpear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo normalize:)
				(switch register
					(1
						(gEgo addHonor: 50)
						(gMessager say: 5 6 41 0 self) ; "You start to tell the Leopardmen about peace and how you need the Spear of Death to convince the Simbani."
					)
					(2
						(gMessager say: 5 5 43 0 self) ; "You tell the leader of the Leopardmen that you need the Spear of Death to gain back the Drum of Magic."
					)
					(3
						(gMessager say: 5 6 22 0 self) ; "You tell the Leopardmen why you brought back the Drum of Magic and ask for the Spear of Death."
					)
					(5
						(gMessager say: 5 6 23 0 self) ; "You tell the Leopard Leader about the horrors of war and ask for the Spear of Death in order to bring peace."
					)
					(else
						(gMessager say: 5 5 1 0 self) ; "You tell about the horrors of war."
					)
				)
			)
			(1
				(if local3
					(self cue:)
				else
					(self setScript: chiefStand self)
				)
			)
			(2
				(leader loop: 4 setCycle: Fwd)
				(gLongSong2 number: 12 setLoop: 1 play: 127 self)
			)
			(3
				(leader setCycle: 0)
				(spear init:)
				(= cycles 10)
			)
			(4
				(if (== local0 4)
					(gEgo setMotion: MoveTo 135 107 self)
				else
					(self cue:)
				)
			)
			(5
				(gEgo view: 31 cycleSpeed: 12 setLoop: 1 setCycle: Beg self)
			)
			(6
				(spear dispose:)
				(gEgo setLoop: -1 cycleSpeed: 6 get: 45 normalize:) ; theMagicSpear
				(= cycles 2)
			)
			(7
				(leader setLoop: 1 setCycle: CT 0 -1 self)
			)
			(8
				(gEgo
					view: 13
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(9
				(= seconds 5)
			)
			(10
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 0)
				(= seconds 2)
			)
			(11
				(gMessager say: 7 2 17 0 self) ; "You journey back to the Simbani village."
				(if (PalVary pvGET_CURRENT_STEP)
					(ClearFlag 81)
					(PalVary pvREVERSE 1)
				)
			)
			(12
				(gEgo cycleSpeed: 6 normalize:)
				((ScriptID 7 4) init: 10 0) ; fixTime
				(= cycles 5)
			)
			(13
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance chiefStand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leader x: 99 y: 99 loop: 1 setCycle: End self)
			)
			(1
				(= cycles 10)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance enterWithDrum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fire setPri: 10)
				(= cycles 10)
			)
			(1
				(gMessager say: 1 2 18 0 self) ; "Johari, why have you brought this outsider to our village?"
			)
			(2
				(gMessager say: 3 6 18 0 self) ; "You have no right to bring this outsider to our village! Outsiders are our enemy and he should be destroyed!"
			)
			(3
				((ScriptID 36 1) ; Johari
					view: 620
					cel: 2
					setLoop: 4
					setScale: 0
					setCycle: End self
				)
			)
			(4
				(gMessager say: 2 2 20 0 self) ; "Okay, hero man, you show my father why I brought you here."
			)
			(5
				((ScriptID 36 1) setCycle: CT 0 -1 self) ; Johari
			)
			(6
				(HandsOn 5 1 3 6)
				(self dispose:)
			)
		)
	)
)

(instance egoGiveDrum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					normalize:
					setMotion: MoveTo (+ (leader x:) 24) 107 self
					solvePuzzle: 298 20
				)
			)
			(1
				(Face gEgo leader self)
			)
			(2
				(= cycles 20)
			)
			(3
				(gEgo
					setCycle: Rev
					setLoop: 1
					setMotion: MoveTo 138 107 self
				)
			)
			(4
				(leader x: 99 y: 99 cel: 0 setLoop: 0 setCycle: End self)
				(gEgo setCycle: Walk setLoop: -1 normalize:)
			)
			(5
				(leader cel: 0 setLoop: 1 setCycle: End self)
			)
			(6
				(leader loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(7
				(gMessager say: 1 6 4 0 self) ; "Behold! The Drum of Magic!"
			)
			(8
				(= seconds 2)
			)
			(9
				(leader cycleSpeed: 12 setCycle: CT 7 1 self)
			)
			(10
				(leader setCycle: CT 11 1 self)
			)
			(11
				(leader setLoop: 3 setCycle: End self)
			)
			(12
				(= local6 1)
				(if (and (gEgo has: 45) (== gHeroType 2)) ; theMagicSpear, Thief
					(self cue:)
				else
					(gMessager say: 2 6 4 0 self) ; "Now it's your turn to speak."
				)
			)
			(13
				(leader cycleSpeed: 6)
				(SetFlag 13)
				(= local3 1)
				(gEgo addHonor: 50)
				(if (and (gEgo has: 45) (== gHeroType 2)) ; theMagicSpear, Thief
					(self cue:)
				else
					(HandsOn 5 1 3 6)
					(gEgo drop: 46) ; theMagicDrum
					(self dispose:)
				)
			)
			(14
				(gEgo drop: 46) ; theMagicDrum
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 0)
				(= seconds 2)
			)
			(15
				(gMessager say: 7 2 35 0 self) ; "You journey back to the Simbani village."
			)
			(16
				(gEgo cycleSpeed: 6 normalize:)
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance accept of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 5 6 11 0 self) ; "You accept the challenge."
			)
			(1
				(leader x: 98 y: 98 cel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gMessager say: 1 6 13 0 self) ; "There will be a duel between the outsider and the Shaman in the arena immediately!"
			)
			(3
				(gCurRoom newRoom: 650)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 149
		y 101
		noun 8
		view 620
		signal 16384
	)
)

(instance spear of View
	(properties
		x 135
		y 93
		view 620
		loop 1
		signal 16384
	)
)

(instance dancer1 of Prop
	(properties
		x 207
		y 104
		view 622
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: shamanEnters)
			)
			(2 ; Talk
				(leopManTell client: dancer1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dancer2 of Prop
	(properties
		x 107
		y 130
		view 622
		loop 2
	)
)

(instance dancer3 of Prop
	(properties
		x 203
		y 130
		view 622
		loop 2
	)
)

(instance dancer4 of Prop
	(properties
		x 154
		y 136
		view 622
		loop 2
	)
)

(instance dancer7 of Prop
	(properties
		x 105
		y 101
		view 622
		loop 5
	)
)

(instance dancer8 of Prop
	(properties
		x 155
		y 101
		view 622
	)
)

(instance egoAndJohari of View
	(properties
		x 205
		y 139
		view 620
		loop 3
	)
)

(instance leader of Prop
	(properties
		x 83
		y 94
		view 605
	)
)

(instance shaman of Prop
	(properties
		x 74
		y 103
		view 625
	)
)

(instance drummer1 of Prop
	(properties
		x 67
		y 125
		view 621
		cel 1
	)
)

(instance drummer2 of Prop
	(properties
		x 52
		y 122
		view 621
		cel 2
	)
)

(instance drummer3 of Prop
	(properties
		x 46
		y 118
		view 621
		cel 3
	)
)

(instance effect of Prop
	(properties
		x 119
		y 89
		view 625
		loop 2
		signal 16384
	)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-8
				(and (not local2) (not local3))
				-4 ; "Drum"
				(== local0 2)
				-10 ; "Now you will see some real magic."
				(== local0 3)
				-9
				(== local1 0)
				-11
				(and (== local0 3) (== local1 1))
				-12
				(and (== local0 3) (== local1 1))
				-14
				(== local0 4)
				-3 ; "Spear"
				(== local0 4)
				-2
				(and (== local1 0) (not local4))
				-1
				(and (== local0 2) (not local5))
		)
	)

	(method (doChild)
		(switch query
			(-9
				(cond
					((== local0 2)
						(if local6
							(gMessager say: 5 6 36) ; "You start to tell about Shapeir..."
						else
							(gMessager say: 5 5 9) ; "You begin to tell about your adventures in Shapeir..."
						)
					)
					((== local0 3)
						(gMessager say: 5 5 40) ; "You start to tell about Shapeir..."
					)
					((== local0 4)
						(gMessager say: 5 5 45) ; "You start to tell about Shapeir..."
					)
					(else
						(gMessager say: 5 5 9) ; "You begin to tell about your adventures in Shapeir..."
					)
				)
				(return 0)
			)
			(-11
				(gEgo addHonor: 20)
				(gCurRoom setScript: accept)
				(return 0)
			)
			(-12
				(gEgo addHonor: -20)
				(gMessager say: 5 6 12) ; "You try to avoid the Shaman's challenge."
				(return 0)
			)
			(-4 ; "Drum"
				(cond
					((gEgo has: 46) ; theMagicDrum
						(gMessager say: 5 5 4) ; "You tell the Leopardman Leader about the Drum of Magic."
						(gCurRoom setScript: egoGiveDrum)
						(return 0)
					)
					((== local3 1)
						(gCurRoom setScript: giveSpear 0 3)
						(return 0)
					)
				)
				(return query)
			)
			(-8
				(cond
					((== local0 4)
						(gCurRoom setScript: egoBows 0 4)
					)
					(local1
						(gCurRoom setScript: egoBows 0 3)
					)
					(else
						(gCurRoom setScript: egoBows 0 1)
					)
				)
				(= local2 1)
				(return 0)
			)
			(-1
				(cond
					((gEgo has: 46) ; theMagicDrum
						(gMessager say: 5 6 46) ; "You tell about the horrors of war, and how you seek to bring peace to this land."
						(gCurRoom setScript: egoGiveDrum)
						(return 0)
					)
					((== local3 1)
						(gEgo addHonor: 30)
						(gCurRoom setScript: giveSpear 0 5)
						(= local5 1)
						(return 0)
					)
				)
				(return query)
			)
			(-2
				(cond
					((== local0 4)
						(gCurRoom setScript: giveSpear 0 1)
						(return 0)
					)
					((== local3 1)
						(gCurRoom setScript: giveSpear 0 1)
						(gEgo addHonor: 30)
						(= local4 1)
						(return 0)
					)
					((== local0 2)
						(gMessager say: 5 5 2) ; "You tell the Leopardman Leader that you have brought back the Drum of Magic as a symbol of peace."
						(gCurRoom setScript: egoGiveDrum)
						(return 0)
					)
					(else
						(gMessager say: 5 6 30) ; "You start to talk ..."
						(return 0)
					)
				)
			)
			(-3 ; "Spear"
				(gCurRoom setScript: giveSpear 0 2)
				(return 0)
			)
			(-10 ; "Now you will see some real magic."
				(if (not (== local1 1))
					(gCurRoom setScript: shamanEnters)
				else
					(gCurRoom setScript: accept)
				)
				(return 0)
			)
			(else
				(return query)
			)
		)
	)
)

(instance leaderTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-13 ; "Challenge"
				(and (== local0 3) (== local1 1))
				-1 ; "War"
				(or (== local0 4) (== local0 2))
				-2 ; "Peace"
				(or (== local0 4) (== local0 2))
				-3 ; "Spear"
				(== local0 4)
				-4 ; "Drum"
				(== local0 2)
				-5 ; "Leopardmen"
				(or (== local0 2) (and (== local0 3) (not local1)))
		)
	)

	(method (doChild param1)
		(switch param1
			(-1 ; "War"
				(if local6
					(gMessager say: 1 5 1) ; "Now that the Drum of Magic has returned, there is no reason for the Leopardmen to fight with the cow people."
				else
					(gMessager say: 1 5 42) ; "The Leopardmen will go to war against the cow people to regain our Drum of Magic and our honor."
				)
				(return 0)
			)
			(-2 ; "Peace"
				(cond
					((== local0 3)
						(gMessager say: 1 5 39) ; MISSING MESSAGE
					)
					((== local0 4)
						(gMessager say: 1 5 41) ; "We will not speak of peace until we have our Drum of Magic returned."
					)
					(local6
						(gMessager say: 1 5 2) ; "Now that the Drum of Magic is returned, I can speak of peace with the cow people."
					)
					(else
						(gMessager say: 1 5 41) ; "We will not speak of peace until we have our Drum of Magic returned."
					)
				)
				(return 0)
			)
			(-5 ; "Leopardmen"
				(if (== local0 2)
					(gMessager say: 1 5 26) ; "My people have the strength, cunning, and skills of a leopard."
				else
					(gMessager say: 2 5 29) ; "Tell about your magic."
				)
				(return 0)
			)
			(-4 ; "Drum"
				(gMessager say: 1 5 4) ; "This Drum of Magic is the symbol of the magic for my people. Much of our magic is weakened without it."
				(return 0)
			)
			(-3 ; "Spear"
				(if (== local3 1)
					(gCurRoom setScript: giveSpear 0 2)
					(return 0)
				)
				(return query)
			)
			(else
				(return query)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(57 ; theMagicDrum
				(if (== local0 2)
					(gCurRoom setScript: egoGiveDrum)
				else
					(super doVerb: theVerb)
				)
			)
			(20 ; theDaggers
				(gCurRoom doVerb: theVerb)
			)
			(33 ; theRocks
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shamanTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-4 ; "Drum"
				(== local0 2)
				-3 ; "Spear"
				(== local0 2)
				-6 ; "Chief"
				(== local0 2)
				-5 ; "Leopardmen"
				(== local0 2)
				-10 ; "Magic"
				(== local0 3)
				-7 ; "Shaman"
				(== local0 3)
				-13 ; "Challenge"
				(== local0 3)
		)
	)

	(method (doChild)
		(if (or (== local0 2) (== local0 3))
			(if (== local3 1)
				(gMessager say: 0 5 21) ; "Just ask about the Spear of Death!"
			else
				(gMessager say: 0 5 34) ; "Don't ask questions, just show my father the drum."
			)
			(return 0)
		else
			(return query)
		)
	)
)

(instance leopManTell of Teller
	(properties)

	(method (doChild)
		(cond
			((== local0 2)
				(if (== local3 1)
					(gMessager say: 0 5 21) ; "Just ask about the Spear of Death!"
				else
					(gMessager say: 0 5 34) ; "Don't ask questions, just show my father the drum."
				)
				(return 0)
			)
			((== local0 3)
				(if (not local1)
					(gMessager say: 0 5 37) ; "Magic! Tell my father about magic."
				else
					(gMessager say: 0 5 38) ; "Just say you will accept the challenge!"
				)
				(return 0)
			)
			(else
				(gMessager say: 0 5 21) ; "Just ask about the Spear of Death!"
				(return 0)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; theDaggers
				(gCurRoom doVerb: theVerb)
			)
			(33 ; theRocks
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance johariTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-4 ; "Drum"
				(== local0 2)
				-13 ; "Challenge"
				local1
				-3 ; "Spear"
				(or (== local0 2) (== local0 4))
				-6
				(== local0 2)
				-7
				(or (== local0 2) (and (== local0 3) local1))
				-5 ; "Leopardmen"
				(or (== local0 2) (and (== local0 3) (not local1)))
		)
	)

	(method (doChild)
		(switch query
			(-4 ; "Drum"
				(if (== local0 2)
					(if (== local3 1)
						(gMessager say: 2 5 3) ; "Ask my father about the spear."
					else
						(gMessager say: 2 5 25) ; "Give the Drum of Magic to my father."
					)
					(return 0)
				else
					(return query)
				)
			)
			(-3 ; "Spear"
				(if (== local0 2)
					(if (== local3 1)
						(gMessager say: 2 5 3) ; "Ask my father about the spear."
					else
						(gMessager say: 2 5 25) ; "Give the Drum of Magic to my father."
					)
					(return 0)
				else
					(return query)
				)
			)
			(-6
				(if (== local0 2)
					(if (== local3 1)
						(gMessager say: 2 5 3) ; "Ask my father about the spear."
					else
						(gMessager say: 2 5 25) ; "Give the Drum of Magic to my father."
					)
					(return 0)
				else
					(return query)
				)
			)
			(-7
				(cond
					((== local0 2)
						(if (== local3 1)
							(gMessager say: 2 5 3) ; "Ask my father about the spear."
						else
							(gMessager say: 2 5 25) ; "Give the Drum of Magic to my father."
						)
						(return 0)
					)
					((== local0 3)
						(if (not local1)
							(gMessager say: 2 5 29) ; "Tell about your magic."
							(return 0)
						else
							(return query)
						)
					)
					(else
						(return query)
					)
				)
			)
			(-5 ; "Leopardmen"
				(if (== local0 2)
					(if (== local3 1)
						(gMessager say: 2 5 3) ; "Ask my father about the spear."
					else
						(gMessager say: 2 5 25) ; "Give the Drum of Magic to my father."
					)
					(return 0)
				else
					(return query)
				)
			)
			(else
				(return query)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; theDaggers
				(gCurRoom doVerb: theVerb)
			)
			(33 ; theRocks
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance throne of Feature
	(properties
		x 90
		y 66
		noun 9
		nsTop 40
		nsLeft 67
		nsBottom 92
		nsRight 114
	)
)

(instance platform of Feature
	(properties
		x 157
		y 61
		z 50
		noun 10
		nsTop 96
		nsLeft 53
		nsBottom 127
		nsRight 261
	)
)

