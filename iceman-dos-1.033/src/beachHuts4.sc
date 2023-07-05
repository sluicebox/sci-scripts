;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)
(use tahiti)
(use SoundSyncWave)
(use n824)
(use n828)
(use n954)
(use ForwardCounter)
(use LoadMany)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	beachHuts4 0
)

(synonyms
	(kiss embrace squeeze hug)
)

(local
	local0
	local1
	local2
)

(instance beachHuts4 of Rm
	(properties
		picture 13
		east 24
		south 16
		west 12
	)

	(method (init)
		(super init:)
		(Load rsSOUND 42)
		(Load rsSOUND 36)
		(LoadMany rsVIEW 206 112 212 12 13 213 313)
		(gAddToPics add: beachLayer eachElementDo: #init doit:)
		(proc824_0)
		(hutDoor2 init:)
		(if (or (and (gEgo has: 6) (== global143 2)) (not global142)) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
			(hutDoor2 stopUpd:)
		)
		(self
			setRegions: 301 300 ; Water, tahiti
			setFeatures:
				hutDoor1
				hut1
				hut2
				westWindowFeat
				windowFeat
				((Clone windowFeat)
					x: 139
					y: 31
					z: 30
					nsTop: 12
					nsBottom: 39
					nsLeft: 126
					nsRight: 144
					heading: 265
					yourself:
				)
				((Clone windowFeat)
					x: 190
					y: 16
					z: 25
					nsTop: 2
					nsBottom: 27
					nsLeft: 184
					nsRight: 199
					heading: 175
					yourself:
				)
				((Clone windowFeat)
					x: 265
					y: 21
					z: 30
					nsTop: 7
					nsBottom: 33
					nsLeft: 254
					nsRight: 278
					heading: 150
					yourself:
				)
		)
		((Clone wave) x: 165 y: 137 init:)
		((Clone wave) x: 290 y: 121 init:)
		((Clone wave) x: 202 y: 132 init:)
		((Clone wave) loop: 1 x: 251 y: 148 init:)
		((Clone wave) x: 295 y: 137 init:)
		((Clone wave) loop: 0 x: 295 y: 150 init:)
		(wave init:)
		(gEgo init:)
		(switch gPrevRoomNum
			(west
				(gEgo x: 10)
			)
			(14 ; inHerHut
				(gEgo posn: 210 59 loop: 1)
				(hutDoor2 setCel: 16 setCycle: Beg hutDoor2)
				(HandsOn)
			)
			(11 ; hotelBar
				((= local0 (ScriptID 309 0)) ; agent
					init:
					view: 212
					illegalBits: 0
					posn: 220 54
					ignoreActors: 1
					loop: 1
					heading: 270
					setScript: agentInFrontOfHutScript
					setPri: 3
					z: 1000
				)
				(HandsOff)
				(gEgo
					view: 213
					ignoreActors:
					ignoreControl: -32768
					setLoop: 0
					posn: 210 54
					heading: 90
					cel: 0
					ignoreActors: 1
					illegalBits: 0
				)
				(HandsOn)
				(User canControl: 0)
				(gFeatures add: agentFeature)
			)
			(else
				(gEgo
					loop: 1
					y:
						(if (< (gEgo y:) 105)
							105
						else
							(gEgo y:)
						)
				)
			)
		)
		(if global142
			(earRing init:)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,beach]')
				(Print 13 0) ; "You see two bungalows, the Tahitian beach, and a man lying on the sand."
			)
		)
	)

	(method (dispose)
		(gEgo ignoreActors: 0)
		(super dispose:)
	)
)

(instance hutDoor1 of RFeature
	(properties
		y 41
		x 25
		nsTop 8
		nsBottom 59
		nsRight 27
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 13 1) ; "This is the door to Hut #2."
					)
					((GoToIfSaid self event 13 68 0 13 2))
					((Said 'open')
						(Print 13 3) ; "This door is locked."
					)
					((Said 'unlock')
						(if (gEgo has: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
							(Print 13 4) ; "You try to unlock the door, but your key doesn't work."
						else
							(Print 13 5) ; "You don't have a key."
						)
					)
					((Said 'knock')
						(Print 13 6) ; "There is no answer."
					)
				)
			)
		)
	)
)

(instance hutDoor2 of Prop
	(properties
		y 54
		x 228
		view 13
		signal 16
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 13 7) ; "This is the door to Hut #3."
					)
					((GoToIfSaid self event self 20 0 13 2))
					((Said 'open')
						(Print 13 3) ; "This door is locked."
					)
					((Said 'unlock')
						(if (gEgo has: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
							(Print 13 8) ; "You try to unlock the door but your key doesn't work."
						else
							(Print 13 5) ; "You don't have a key."
						)
					)
					((Said 'knock')
						(Print 13 6) ; "There is no answer."
					)
				)
			)
		)
	)

	(method (cue)
		(if (or (and (gEgo has: 6) (== global143 2)) (not global142)) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
			(hutDoor2 stopUpd:)
		)
		(doorSound number: (proc0_5 42) loop: 1 play:)
	)
)

(instance agentInFrontOfHutScript of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'thank/you')
				(Print 13 9) ; "You're very welcome," she says, "It's been such a nice time."
			)
			((Said 'go,come<in')
				(if register
					(local0 posn: 220 54 loop: 0 z: 0)
					(gEgo view: 206 setLoop: -1 loop: 0 setCycle: Walk)
					(hutDoor2 setCycle: End self)
					(doorSound number: (proc0_5 42) loop: 1 play:)
				else
					(Print 13 10) ; "Well," she considers, "I really don't know if you should."
				)
			)
			((Said 'talk[/woman,stacy]')
				(Print 13 11) ; ""I've really had a nice time." she says."
			)
			((Said 'kiss[/woman,stacy]')
				(if register
					(Print 13 12) ; "Answer the question first."
				else
					(HandsOff)
					(gEgo
						view: 213
						ignoreActors:
						ignoreControl: -32768
						setLoop: 0
						setCycle: End self
					)
					(SetScore tahiti 413 8 1)
				)
			)
			((Said 'yes')
				(if register
					(local0 posn: 220 54 loop: 0 z: 0)
					(gEgo view: 206 setLoop: -1 loop: 0 setCycle: Walk)
					(hutDoor2 setCycle: End self)
					(doorSound number: (proc0_5 42) loop: 1 play:)
				else
					(Print 13 13) ; "Yes, what?"
				)
			)
			((or (Said 'no') (Said 'exit/woman'))
				(Print 13 14) ; ""Well, all right then, maybe some other time," she says with disappointment."
				(client setScript: agentLeavesAngryScript)
			)
			((Said 'fuck,fondle')
				(Print 13 15) ; "Obviously upset at your crudeness she says, "You rotten scoundrel!""
				(tahiti flags: (| (tahiti flags:) $0040))
				(client setScript: agentLeavesAngryScript)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seconds 3)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(Print 13 16) ; "After a tender embrace, she murmurs..."
				(Print 13 17) ; "Would you like to come in for awhile?"
				(++ register)
				(User canInput: 1)
			)
			(4
				(gEgo observeControl: -32768 ignoreActors: 0)
				(gCurRoom newRoom: 14) ; inHerHut
			)
		)
	)
)

(instance agentLeavesAngryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 206
					loop: 0
					setLoop: -1
					setCycle: Walk
					illegalBits: -26624
				)
				(local0 view: 212 loop: 1 z: 0)
				(hutDoor2 setCycle: End self)
				(doorSound number: (proc0_5 42) loop: 1 play:)
			)
			(1
				(local0
					setPri: 1
					setCycle: Walk
					setMotion: MoveTo 260 (local0 y:) self
				)
			)
			(2
				(hutDoor2 setCycle: Beg self)
				(doorSound number: (proc0_5 36) loop: 1 play:)
			)
			(3
				(hutDoor2 ignoreActors: 0)
				(if (or (and (gEgo has: 6) (== global143 2)) (not global142)) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(hutDoor2 stopUpd:)
				)
				(local0 dispose:)
				(HandsOn)
			)
		)
	)
)

(instance beachLayer of RPicView
	(properties
		y 102
		x 307
		view 12
		loop 1
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/man,towel]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at][/man]')
						(Print 13 18) ; "He's just lying there."
					)
					((Said 'look[<at][/towel]')
						(Print 13 19) ; "A beach towel."
					)
					((Said 'wake,kick,jump,walk[<above][/man]')
						(Print 13 20) ; "Don't do that!"
					)
					((Said 'talk[/man]')
						(Print 13 21) ; "He doesn't seem to hear you."
					)
					((Said 'kiss[/man]')
						(Print 13 22) ; "Buzz off!"
					)
				)
			)
		)
	)
)

(instance wave of SoundSyncWave
	(properties
		y 139
		x 114
		view 112
		loop 2
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self sound: gIceGlobalSound)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/wave]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 13 23) ; "You see mild waves lapping the beach."
					)
				)
			)
		)
	)
)

(instance westWindowFeat of RFeature
	(properties
		y 27
		x 53
		z 30
		heading 265
		nsTop 12
		nsLeft 42
		nsBottom 38
		nsRight 64
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look[<at,in]/*'))
					((Said 'look>')
						(cond
							((Said '[<at]')
								(Print 13 24) ; "It's just a window."
							)
							((Said '[<in]')
								(Print 13 25) ; "You're not tall enough to see into this window."
							)
						)
					)
				)
			)
		)
	)
)

(instance windowFeat of RFeature
	(properties
		y 29
		x 104
		z 30
		heading 175
		nsTop 14
		nsLeft 91
		nsBottom 41
		nsRight 119
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look[<at,in]/*'))
					((Said 'look>')
						(cond
							((Said '[<at]')
								(Print 13 24) ; "It's just a window."
							)
							((Said '[<in]')
								(Print 13 26) ; "You shouldn't be looking in the window."
							)
						)
					)
				)
			)
		)
	)
)

(instance hut1 of RFeature
	(properties
		y 81
		x 39
		heading 180
		nsBottom 79
		nsRight 162
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 13 27) ; "You see two bungalows."
					)
				)
			)
		)
	)
)

(instance hut2 of RFeature
	(properties
		y 251
		x 31
		heading 180
		nsLeft 183
		nsBottom 62
		nsRight 319
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 13 27) ; "You see two bungalows."
					)
				)
			)
		)
	)
)

(instance earRing of Prop
	(properties
		y 79
		x 171
		view 313
		loop 2
		priority 4
		signal 16
	)

	(method (doit)
		(super doit:)
		(if (< (gEgo distanceTo: self) 30)
			(if (and (not cycler) local2 (not (gEgo has: 6))) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
				(self setCycle: ForwardCounter 4 self)
			)
		else
			(= local2 1)
		)
	)

	(method (cue)
		(self stopUpd:)
		(= local2 0)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((gEgo has: 6)) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
			((or (Said 'look[<down][/floor]') (Said 'look[<at,in]/sand'))
				(Print 13 28) ; "In the sand a slight glimmer catches your eye."
			)
			((Said 'look[<at]/glimmer,sparkle')
				(if (& (tahiti flags:) $0400)
					(Print 13 29) ; "You think to yourself as you take a closer look. What? This can't be! Talk about a needle in a haystack, I think I found the lost earring!"
				else
					(Print 13 30) ; "You realize to yourself, as you take a closer look, Hey, this sure looks like one of the earrings Stacy was wearing!"
				)
			)
			(
				(GoToIfSaid
					self
					event
					self
					20
					'get,(pick<up)/earring,glimmer,sparkle,object'
					13
					2
				))
			((Said 'get,(pick<up)/earring,glimmer,sparkle,object')
				(Print 13 31) ; "You pick the object up and, sure enough, it's an earring."
				(gEgo get: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
				(self dispose:)
			)
		)
	)
)

(instance agentFeature of Feature
	(properties
		y 54
		x 212
	)

	(method (handleEvent event)
		(local0 handleEvent: event)
	)
)

(instance doorSound of Sound
	(properties
		priority 2
	)
)

