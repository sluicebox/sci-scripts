;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use eRS)
(use n819)
(use EcoFeature)
(use Talker)
(use Polygon)
(use LoadMany)
(use Motion)
(use User)
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
		picture 100
		style 10
		horizon 15
		lookStr 37
	)

	(method (init)
		(= global250 3)
		(= global251 1)
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
		(Palette palANIMATE 192 202 7)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $1000)
				(self setScript: enterCity)
			)
			((& temp0 $4000)
				(self newRoom: 420)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(self setScript: tryToGoSouth)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
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
				((ScriptID 2 0) init: 1 0 0 4 1 self) ; Delphineus, "This is it, Adam. We're on our own now, right out here in the open sea. What an adventure, huh?"
			)
			(2
				((ScriptID 2 1) init: 2 0 0 2 1 self) ; Adam, "You're not nervous, are you, Delphineus?"
			)
			(3
				((ScriptID 2 0) init: 1 0 0 5 0 self) ; Delphineus, "Who me? Master of control? Nervous?"
			)
			(4
				((ScriptID 2 0) init: 1 0 0 6 1 self) ; Delphineus, "We've got the prophecy and we've got our natural talent so, hey, what the heck. Flesh-Eater beware, right?"
			)
			(5
				((ScriptID 2 1) init: 2 0 0 3 1 self) ; Adam, "Right! Let's explore!"
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
				((ScriptID 2 1) init: 2 0 0 1 1 self) ; Adam, "Wow..."
			)
			(2
				((ScriptID 2 0) init: 1 0 0 1 1 self) ; Delphineus, "She is beautiful, isn't she? Her name is Eluria... my home."
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
				(gDelph init: x: local2 y: local3)
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
					(EcoNarrator init: 3 0 0 34 self) ; "That way leads to the kelp maze. There's nothing Adam can do for Delphineus there."
				else
					((ScriptID 2 0) init: 1 0 0 2 1 self) ; Delphineus, "I don't want to go through that kelp maze again, Adam. Besides, I don't think Cetus would have gone towards the open ocean."
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
					((ScriptID 2 0) init: 1 0 0 3 1 self) ; Delphineus, "That way leads to the surface, Adam. I know Cetus isn't up there. Let's try going east."
				else
					(EcoNarrator init: 3 0 0 35 self) ; "There's nothing Adam can do to help Delphineus on the ocean's surface."
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
				((ScriptID 2 0) init: 1 0 0 38 1 self) ; Delphineus, "C'mon! Let's go east to the reef. We've already done all we can for the city."
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance BigHead of EcoFeature
	(properties
		onMeCheck 2
		lookStr 1
	)

	(method (doVerb theVerb &tmp temp0)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 2) ; "Perhaps Adam should swim closer to the head first."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 2) ; "Perhaps Adam should swim closer to the head first."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 2) ; "Perhaps Adam should swim closer to the head first."
			)
			(2 ; Talk
				(EcoNarrator init: 3 0 0 5) ; "There is no reply from the giant head."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance eluriaCity of EcoFeature
	(properties
		onMeCheck 4100
		lookStr 3
	)

	(method (doVerb theVerb &tmp temp0)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 4) ; "If Adam wants to clean up Eluria, he'll have to get closer."
			)
			(2 ; Talk
				(EcoNarrator init: 3 0 0 6) ; "Adam can't talk to the city."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 7) ; "Adam can't do anything to the city from here."
			)
			(4 ; Do
				(EcoNarrator init: 3 0 0 16) ; "Just swim there."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance eluriaOutskirts of EcoFeature
	(properties
		onMeCheck 8
		lookStr 15
	)

	(method (doVerb theVerb &tmp temp0)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(2 ; Talk
				(EcoNarrator init: 3 0 0 19) ; "Adam can't talk to the ruins surrounding Eluria."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 18) ; "Adam can't do anything with the ruins around Eluria."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 22) ; "Adam can't clean up the ruins or the spires of rock."
			)
			(4 ; Do
				(EcoNarrator init: 3 0 0 17) ; "The ruins surrounding Eluria have been long abandoned and are of no interest to Adam or the Elurians."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance closeColumn of EcoFeature
	(properties
		onMeCheck 16
		lookStr 11
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 12) ; "The columns are merely silent sentinels and are of no use to Adam."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 12) ; "The columns are merely silent sentinels and are of no use to Adam."
			)
			(2 ; Talk
				(EcoNarrator init: 3 0 0 13) ; "The columns stonily refuse to reply."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 14) ; "The columns do not need to be thrown away."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance glow of EcoProp
	(properties
		x 290
		y 107
		view 100
		priority 10
		signal 16400
		cycleSpeed 15
		lookStr 2
	)

	(method (cue)
		(gLongSong number: 420 loop: -1 play:)
	)
)

(instance leaves of EcoProp
	(properties
		x 281
		y 100
		view 100
		loop 1
		priority 10
		signal 16400
		cycleSpeed 12
		detailLevel 2
		lookStr 8
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 9) ; "Adam can't take the kelp. It's a living plant."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 10) ; "There's nothing Adam can to do with the kelp."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant of EcoProp
	(properties
		x 258
		y 5
		view 100
		loop 2
		signal 16400
		cycleSpeed 12
		detailLevel 2
		lookStr 8
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 9) ; "Adam can't take the kelp. It's a living plant."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 10) ; "There's nothing Adam can to do with the kelp."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance pillars of EcoFeature
	(properties
		onMeCheck 64
		lookStr 20
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 21) ; "Adam can't do anything with the rock spires that hold up Eluria - nor would he want to."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 21) ; "Adam can't do anything with the rock spires that hold up Eluria - nor would he want to."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 22) ; "Adam can't clean up the ruins or the spires of rock."
			)
			(2 ; Talk
				(EcoNarrator init: 3 0 0 23) ; "Adam can't talk to the rock spires that hold up Eluria."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance coral of EcoFeature
	(properties
		y 190
		onMeCheck 128
		lookStr 24
	)

	(method (doVerb theVerb &tmp temp0)
		(= x ((User curEvent:) x:))
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 25) ; "The coral is sharp and would cut Adam's hands."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 26) ; "Adam doesn't want to disturb the natural coral."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance soldierMask of EcoFeature
	(properties
		onMeCheck 256
		lookStr 29
	)

	(method (doVerb theVerb &tmp temp0)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 30) ; "The helmet is so overgrown with moss that it's part of the landscape now. Adam decides to leave it alone."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 31) ; "Adam doesn't need to do anything with the helmet."
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 32) ; "The helmet is part of the ancient history of Eluria and doesn't need to be thrown away."
			)
			(2 ; Talk
				(EcoNarrator init: 3 0 0 33) ; "The helmet has nothing to say."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance moss of EcoFeature
	(properties
		onMeCheck 512
		lookStr 27
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 44 4) ; Inventory, Do
			(EcoNarrator init: 3 0 0 28) ; "Adam can't do anything with the green moss."
		else
			(super doVerb: theVerb temp0 &rest) ; UNINIT
		)
	)
)

