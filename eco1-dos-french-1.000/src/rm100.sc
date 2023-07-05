;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use eRS)
(use n819)
(use Talker)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm100 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 param2)
	(= local0 param1)
	(= local1 param2)
)

(procedure (localproc_1 param1 param2)
	(= local2 param1)
	(= local3 param2)
)

(instance rm100 of EcoRoom
	(properties
		lookStr 37
		picture 100
		style 10
		horizon 15
	)

	(method (init)
		(= global225 2)
		(NormalEgo)
		(if (not (IsFlag 73))
			(NormalDelph)
			(gDelph z: 0)
			(gDelph init: lookStr: 36 talkScript: delTalkScript)
		)
		(gEgo init:)
		(LoadMany rsVIEW 834 809)
		(gFeatures
			add:
				BigHead
				eluriaCity
				eluriaOutskirts
				closeColumn
				coral
				pillars
				soldierMask
				moss
			eachElementDo: #init
		)
		(plant setCycle: Fwd init:)
		(if (and (IsFlag 7) (!= global233 2))
			(leaves setCycle: Fwd init:)
			(glow setCycle: Fwd init:)
		)
		(super init:)
		(HandsOff)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PTotalAccess
					init: 77 69 103 35 120 35 135 41 177 41 218 61 213 74 184 94 131 94 94 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 256 79 268 30 220 -10 319 -10 319 189 213 189 213 185 271 185 271 138 200 138 216 113
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 -10 108 -10 91 20 52 29 5 189 0 189
					yourself:
				)
			setRegions: 51 ; bubblesRegion
		)
		(switch gPrevRoomNum
			(120
				(gEgo posn: 162 83 loop: 2 setCycle: Walk)
				(localproc_0 162 107)
				(if (not (IsFlag 73))
					(localproc_1 64 119)
					(gDelph posn: 129 78)
				)
			)
			(420
				(gEgo posn: 225 144 loop: 1 setCycle: Walk)
				(localproc_0 196 144)
				(if (not (IsFlag 73))
					(localproc_1 64 121)
					(gDelph posn: 250 165)
				)
			)
			(else
				(gEgo posn: 98 217)
				(if (not (IsFlag 73))
					(gDelph posn: 151 200)
					(localproc_1 163 119)
				)
				(if (not (IsFlag 6))
					(gLongSong number: 100 loop: 1 play: glow)
					(gEgo setCycle: Walk)
					(localproc_0 80 133)
					(enterScript next: enjoyViewOfCity)
				else
					(localproc_0 98 167)
				)
			)
		)
		(if (IsFlag 6)
			(gLongSong number: 101 loop: 1 play: glow)
		)
		(self setScript: enterScript)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $1000)
				(self setScript: enterCity)
			)
			((& temp0 $4000)
				(self newRoom: 420)
			)
			((== (gEgo edgeHit:) 3)
				(self setScript: tryToGoSouth)
			)
			((== (gEgo edgeHit:) 1)
				(gCurRoom setScript: NoExit)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gDelph talkScript: 0 lookStr: 0)
		(gLongSong client: 0)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance enterScript of Script
	(properties)

	(method (init)
		(if local2
			(gDelph setScript: delEnterScript)
		)
		(super init: &rest)
	)

	(method (dispose)
		(if (gDelph script:)
			(gDelph setScript: 0)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo local0 local1 self)
			)
			(2
				(if (and (IsFlag 6) (not (SetFlag 115)))
					(self setScript: wereOnOurOwn self)
				else
					(= ticks 3)
				)
			)
			(3
				(if (not next)
					(NormalEgo)
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance wereOnOurOwn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				((ScriptID 2 0) init: 4 1 self) ; Delphineus, "This is it, Adam. We're on our own now, right out here in the open sea. What an adventure, huh?"
			)
			(2
				((ScriptID 2 1) init: 2 1 self) ; Adam, "You're not nervous, are you, Delphineus?"
			)
			(3
				((ScriptID 2 0) init: 5 0 self) ; Delphineus, "Who me? Master of control? Nervous?"
			)
			(4
				((ScriptID 2 0) say: 6 1 self) ; Delphineus
			)
			(5
				((ScriptID 2 1) init: 3 1 self) ; Adam, "Right! Let's explore!"
			)
			(6
				(= cycles 4)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance enjoyViewOfCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(SetScore 15 250)
				((ScriptID 2 1) init: 1 1 self) ; Adam, "Wow..."
			)
			(2
				((ScriptID 2 0) init: 1 1 self) ; Delphineus, "She is beautiful, isn't she? Her name is Eluria... my home."
			)
			(3
				(gDelph setScript: delEnterCity)
				(client setScript: enterCity)
			)
		)
	)
)

(instance enterCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Walk setHeading: 0 self)
			)
			(1
				(gEgo
					view: 809
					cel: 0
					setLoop: (not (IsFlag 6))
					setCycle: End self
					setMotion: MoveTo 155 87 self
				)
			)
			(2 0)
			(3
				(HandsOn)
				(gCurRoom newRoom: 120)
			)
		)
	)
)

(instance delEnterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gDelph setMotion: MoveTo local2 local3 self)
			)
			(2
				(if (not next)
					(Face gDelph gEgo self)
				else
					(= ticks 2)
				)
			)
			(3
				(gDelph cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance delEnterCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gDelph
					setCycle: 0
					view: 834
					setLoop: 0
					cel: 0
					setCycle: End self
					setMotion: MoveTo 162 74 self
				)
			)
			(1 0)
			(2
				(self dispose:)
			)
		)
	)
)

(instance tryToGoSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(if (IsFlag 73)
					(Narrator init: 34 self) ; "That way leads to the kelp maze. There's nothing Adam can do for Delphineus there."
				else
					((ScriptID 2 0) init: 2 1 self) ; Delphineus, "I don't want to go through that kelp maze again, Adam. Besides, I don't think Cetus would have gone towards the open ocean."
				)
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x:) 175 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance NoExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 73))
					((ScriptID 2 0) init: 3 1 self) ; Delphineus, "That way leads to the surface, Adam. I know Cetus isn't up there. Let's try going east."
				else
					(Narrator init: 35 self) ; "There's nothing Adam can do to help Delphineus on the ocean's surface."
				)
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gCurRoom horizon:) 5) self
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance delTalkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 0) init: 38 1 self) ; Delphineus, "C'mon! Let's go east to the reef. We already done all we can for the city."
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance BigHead of Feature
	(properties
		onMeCheck 2
		lookStr 1
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 2) ; "Perhaps Adam should swim closer to the head first."
			)
			(4 ; Inventory
				(Narrator init: 2) ; "Perhaps Adam should swim closer to the head first."
			)
			(10 ; Recycle
				(Narrator init: 2) ; "Perhaps Adam should swim closer to the head first."
			)
			(5 ; Talk
				(Narrator init: 5) ; "There is no reply from the giant head."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance eluriaCity of Feature
	(properties
		onMeCheck 4100
		lookStr 3
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 4) ; "If Adam wants to clean up Eluria, he'll have to get closer."
			)
			(5 ; Talk
				(Narrator init: 6) ; "Adam can't talk to the city."
			)
			(4 ; Inventory
				(Narrator init: 7) ; "Adam can't do anything to the city from here."
			)
			(3 ; Do
				(Narrator init: 16) ; "Just swim there."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance eluriaOutskirts of Feature
	(properties
		onMeCheck 8
		lookStr 15
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(5 ; Talk
				(Narrator init: 19) ; "Adam can't talk to the ruins surrounding Eluria."
			)
			(4 ; Inventory
				(Narrator init: 18) ; "Adam can't do anything with the ruins around Eluria."
			)
			(10 ; Recycle
				(Narrator init: 22) ; "Adam can't clean up the ruins or the spires of rock."
			)
			(3 ; Do
				(Narrator init: 17) ; "The ruins surrounding Eluria have been long abandoned and are of no interest to Adam or the Elurians."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance closeColumn of Feature
	(properties
		onMeCheck 16
		lookStr 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 12) ; "The columns are merely silent sentinels and are of no use to Adam."
			)
			(4 ; Inventory
				(Narrator init: 12) ; "The columns are merely silent sentinels and are of no use to Adam."
			)
			(5 ; Talk
				(Narrator init: 13) ; "The columns stonily refuse to reply."
			)
			(10 ; Recycle
				(Narrator init: 14) ; "The columns do not need to be thrown away."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance glow of Prop
	(properties
		x 290
		y 107
		lookStr 2
		view 100
		priority 10
		signal 16400
		cycleSpeed 15
	)

	(method (cue)
		(gLongSong number: 420 loop: -1 play:)
	)
)

(instance leaves of Prop
	(properties
		x 281
		y 100
		lookStr 8
		view 100
		loop 1
		priority 10
		signal 16400
		cycleSpeed 12
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 9) ; "Adam can't take the kelp. It's a living plant."
			)
			(4 ; Inventory
				(Narrator init: 10) ; "There's nothing Adam can to do with the kelp."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant of Prop
	(properties
		x 258
		y 5
		lookStr 8
		view 100
		loop 2
		signal 16400
		cycleSpeed 12
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 9) ; "Adam can't take the kelp. It's a living plant."
			)
			(4 ; Inventory
				(Narrator init: 10) ; "There's nothing Adam can to do with the kelp."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pillars of Feature
	(properties
		onMeCheck 64
		lookStr 20
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 21) ; "Adam can't do anything with the rock spires that hold up Eluria - nor would he want to."
			)
			(4 ; Inventory
				(Narrator init: 21) ; "Adam can't do anything with the rock spires that hold up Eluria - nor would he want to."
			)
			(10 ; Recycle
				(Narrator init: 22) ; "Adam can't clean up the ruins or the spires of rock."
			)
			(5 ; Talk
				(Narrator init: 23) ; "Adam can't talk to the rock spires that hold up Eluria."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance coral of Feature
	(properties
		y 190
		onMeCheck 128
		lookStr 24
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 25) ; "The coral is sharp and would cut Adam's hands."
			)
			(4 ; Inventory
				(Narrator init: 26) ; "Adam doesn't want to disturb the natural coral."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soldierMask of Feature
	(properties
		onMeCheck 256
		lookStr 29
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 30) ; "The helmet is so overgrown with moss that it's part of the landscape now. Adam decides to leave it alone."
			)
			(4 ; Inventory
				(Narrator init: 31) ; "Adam doesn't need to do anything with the helmet."
			)
			(10 ; Recycle
				(Narrator init: 32) ; "The helmet is part of the ancient history of Eluria and doesn't need to be thrown away."
			)
			(5 ; Talk
				(Narrator init: 33) ; "The helmet has nothing to say."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance moss of Feature
	(properties
		onMeCheck 512
		lookStr 27
	)

	(method (doVerb theVerb invItem)
		(if (OneOf theVerb 4 3) ; Inventory, Do
			(Narrator init: 28) ; "Adam can't do anything with the green moss."
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

