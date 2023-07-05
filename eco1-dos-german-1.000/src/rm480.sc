;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use Talker)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm480 0
)

(local
	local0
	local1
	local2 = 1
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(instance rm480 of EcoRoom
	(properties
		picture 480
		horizon 20
		north 343
		east 500
		west 440
		walkOffTop 1
	)

	(method (doit)
		(super doit: &rest)
		(if (> gHowFast 0)
			(Palette palANIMATE 33 42 7)
		)
	)

	(method (init)
		(LoadMany rsVIEW 481 482)
		(gFeatures
			add:
				OceanFloor
				EastSide
				OctopusLair
				DeadBrainCoral
				PillarCoral
				StaghornCoral
				TreeCoral
				LettuceCoral1
				LettuceCoral2
				StarletCoral
				RedbeardSponge1
				RedbeardSponge2
				RedSponge
			eachElementDo: #init
		)
		(if (not (IsFlag 313))
			(SteelCable init:)
		)
		(if (== ((Inv at: 23) owner:) 480) ; jar
			(Jar init: setCel: 1)
			(= global233 1)
		)
		(frond0 init:)
		(NormalEgo)
		(gEgo init: setLoop: gStopGroop ignoreHorizon: 1)
		(if (not (IsFlag 73))
			(NormalDelph)
			(gDelph z: 50 init:)
		)
		(if (IsFlag 139)
			(= local3 1)
		)
		(if (IsFlag 101)
			(= local5 1)
		)
		(ClearFlag 101)
		(if (or (gEgo has: 26) (IsFlag 334)) ; steelCable
			(octopus view: 482 loop: 0 x: 151 y: 72 init:)
			(= local3 1)
			(= local1 1)
			(= local2 0)
		else
			(octopus view: 480 loop: 3 cel: 1 x: 145 y: 99 init:)
			(= local2 1)
		)
		(if (and (not (IsFlag 67)) (not (IsFlag 73)))
			(helpBubbles init:)
		)
		(if (< (fish1 detailLevel:) (gGame detailLevel:))
			(fish1 init:)
		)
		(if (< (fish2 detailLevel:) (gGame detailLevel:))
			(fish2 init:)
		)
		(if (< (fish3 detailLevel:) (gGame detailLevel:))
			(fish3 init:)
		)
		(if (< (fish5 detailLevel:) (gGame detailLevel:))
			(fish5 init:)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 168 7 155 48 45 50 0 52 0 0 169 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 114 45 126 70 151 92 175 288 175 310 165 319 165 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 175 125 221 132 229 152 157 152 161 129
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 302 121 204 121 202 99 302 99
					yourself:
				)
		)
		(switch gPrevRoomNum
			(440
				(= style 12)
			)
			(343
				(= style -32759)
			)
			(500
				(= style 11)
			)
			(else
				(= style 6)
			)
		)
		(self setRegions: 51) ; bubblesRegion
		(super init: &rest)
		(if (IsFlag 73)
			(= north 345)
		)
		(switch gPrevRoomNum
			(440
				(if (not (IsFlag 73))
					(gDelph
						posn: -60 (gEgo y:)
						heading: 90
						setMotion: DPath 60 30 140 60 self
					)
				)
				(if (== global124 gCurRoomNum)
					(redFish
						posn: 180 85
						loop: 0
						cycleSpeed: 4
						init:
						setCycle: Fwd
						setMotion: PolyPath 340 84
					)
					(= global124 500)
					(gEgo setMotion: PolyPath 50 84)
					(Narrator posn: -1 130 init: 51) ; "The red fish streaks across the reef toward the east!"
				)
			)
			(500
				(if (not (IsFlag 73))
					(gDelph posn: 380 -80 setMotion: DPath 60 30 140 60 self)
				)
				(if (== global124 gCurRoomNum)
					(redFish
						posn: 150 85
						loop: 1
						cycleSpeed: 4
						init:
						setCycle: Fwd
						setMotion: PolyPath -50 84
					)
					(= global124 440)
					(Narrator posn: -1 130 init: 52) ; "The red fish keeps up the speed as it heads back the way it came."
				)
			)
			(343
				(self setScript: enterFromDriftnet2)
				(if (not (IsFlag 73))
					(gDelph
						posn: (gEgo x:) -80
						heading: 180
						setMotion: PFollow gEgo 90
					)
				)
			)
			(345
				(self setScript: enterFromDriftnet2)
			)
			(else
				(if (not (IsFlag 73))
					(gDelph
						posn: (gEgo x:) -95
						heading: 180
						setMotion: PFollow gEgo 90
					)
				)
			)
		)
		(if (!= (gLongSong number:) 440)
			(gLongSong number: 440 loop: -1 play:)
		)
		(gLongSong2 number: 444 loop: -1 flags: 1 play:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator init: 14) ; "A beautiful array of coral formations continues here but weakens toward the east."
				)
			)
			(10 ; Recycle
				(Narrator init: 38) ; "This part of the reef is in good condition. Nothing needs to be thrown out."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance octopus of Actor
	(properties
		approachX 140
		approachY 128
		view 482
		loop 9
		xStep 5
	)

	(method (init)
		(self ignoreActors: 1 setPri: 1 setCel: 1 cycleSpeed: 26)
		(super init: &rest)
		(self approachVerbs: 2 5) ; Look, Talk
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((IsFlag 73)
						(Narrator init: (Random 177 179) 0 4)
					)
					((not (IsFlag 139))
						(Narrator posn: -1 20 init: 60) ; "It's not a good idea to poke around in hiding places in the reef. Moray eels and other predators love those spots."
					)
					(local1
						((ScriptID 2 0) init: 7 1) ; Delphineus, "You'll hurt his feelings if you don't go along with the 'I'm a rock' thing."
					)
					(else
						(Narrator posn: -1 20 init: 34) ; "Never tangle with an octopus. So to speak."
					)
				)
			)
			(2 ; Look
				(cond
					((IsFlag 73)
						(Narrator init: (Random 174 176) 0 4)
					)
					((not (IsFlag 139))
						(Narrator posn: -1 20 init: 59) ; "A large shape is huddled in the lair, but Adam can't see it clearly."
					)
					(local1
						(self setScript: octLookTalk)
					)
					((not (IsFlag 136))
						(Narrator posn: -1 20 init: 76) ; "It's an octopus!"
					)
					(else
						(Narrator posn: -1 20 init: 63) ; "The octopus has returned. He stares balefully at Adam from the safety of his lair."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(24 ; mirror
						(if local1
							(Narrator init: 47) ; "The octopus doesn't want to play anymore. He's had enough."
						else
							(gEgo setScript: mirrorCartoon)
						)
					)
					(23 ; jar
						(if (and (== global233 0) (== local7 0) (== local4 0))
							(gEgo setScript: egoPlaceJar)
						else
							(Narrator posn: -1 20 init: 45) ; "Putting the jar down here would be useless right now."
						)
					)
					(12 ; trident
						(if (IsFlag 139)
							(Narrator init: 39) ; "Using the trident on the octopus would cause serious damage to his body parts."
						else
							(Narrator posn: -1 20 init: 61) ; "Adam shouldn't use that on the creature in the lair until he knows more about it."
						)
					)
					(17 ; spine
						(if (IsFlag 139)
							(Narrator init: 56) ; "The lionfish spine contains a paralyzing venom. It would be cruel to use it on the octopus."
						else
							(Narrator posn: -1 20 init: 61) ; "Adam shouldn't use that on the creature in the lair until he knows more about it."
						)
					)
					(29 ; fishLure
						(if (IsFlag 139)
							(Narrator init: 68) ; "The octopus eyes the lure disdainfully. It doesn't fool him."
						else
							(Narrator posn: -1 20 init: 67) ; "The creature within the lair stirs but doesn't seem fooled."
						)
					)
					(else
						(if (IsFlag 139)
							(Narrator posn: -1 20 init: 82) ; "Don't do that to the octopus!"
						else
							(Narrator posn: -1 20 init: 61) ; "Adam shouldn't use that on the creature in the lair until he knows more about it."
						)
					)
				)
			)
			(5 ; Talk
				(cond
					((IsFlag 73)
						(Narrator init: 4) ; "Since the octopus doesn't answer, he's clearly not an Elurian."
					)
					(local1
						((ScriptID 2 0) init: 6 1) ; Delphineus, "This is his rock impersonation and rocks don't talk."
					)
					(local5
						(Narrator init: 4) ; "Since the octopus doesn't answer, he's clearly not an Elurian."
					)
					((IsFlag 139)
						(Narrator init: 4) ; "Since the octopus doesn't answer, he's clearly not an Elurian."
					)
					(else
						((ScriptID 2 0) init: 22 1) ; Delphineus, "I don't know what's in there, Adam. Don't talk loud until we find out."
					)
				)
			)
			(10 ; Recycle
				(if (or (IsFlag 139) (IsFlag 73))
					(Narrator init: 71) ; "The octopus doesn't want to be bagged."
				else
					((ScriptID 2 0) init: 28 1) ; Delphineus, "Don't get too close, Adam!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance redFish of Actor
	(properties
		yStep 7
		view 443
		signal 24576
		xStep 11
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				((ScriptID 2 1) init: 1 1 0 50) ; Adam, "Hey, give us that key back!"
			)
			(10 ; Recycle
				(Narrator init: 79 0 50) ; "Adam can't bag the fish - it's too fast."
			)
			(4 ; Inventory
				(switch invItem
					(29 ; fishLure
						(Narrator init: 75 0 50) ; "The red fish eyes the fishing lure but decides it's the wrong flavor."
					)
					(12 ; trident
						(Narrator init: 74 0 50) ; "Spearfishing is out of the question."
					)
					(30 ; hackSaw
						(Narrator init: 76 0 50) ; "Bloodthirsty, aren't you?"
					)
					(13 ; sharpShell
						(Narrator init: 77 0 50) ; "Fileting the red fish is not a good idea."
					)
					(else
						(Narrator init: 78 0 50) ; "That won't stop the red fish."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fish1 of Actor
	(properties
		x 245
		y 35
		view 50
		detailLevel 1
		illegalBits 0
		xStep 4
	)

	(method (init)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			setLoop: 3
			setCycle: Fwd
			cycleSpeed: 16
			setHeading: 100
			setMotion: PolyPath 475 60 self
		)
		(super init: &rest)
	)

	(method (cue)
		(self x: -250 y: 10 setMotion: PolyPath 475 60 self)
		(super cue: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					(Narrator init: (Random 1 8) 0 50)
				)
			)
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(Narrator init: (Random 9 12) 0 50)
					)
					(13 ; sharpShell
						(Narrator init: (Random 13 16) 0 50)
					)
					(17 ; spine
						(Narrator init: (Random 17 20) 0 50)
					)
					(30 ; hackSaw
						(Narrator init: (Random 20 24) 0 50)
					)
					(21 ; healingPotion
						(Narrator init: (Random 25 28) 0 50)
					)
					(29 ; fishLure
						(Narrator init: (Random 29 32) 0 50)
					)
					(else
						(Narrator init: (Random 37 41) 0 50)
					)
				)
			)
			(10 ; Recycle
				(Narrator init: (Random 33 36) 0 50)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator init: (+ 70 (Random 0 2)) 0 50)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fish2 of Actor
	(properties
		x -45
		y 35
		view 51
		detailLevel 1
		illegalBits 0
		xStep 2
	)

	(method (init)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			setLoop: 2
			setCycle: Fwd
			cycleSpeed: 12
			setHeading: 100
			setMotion: PolyPath 475 40 self
		)
		(super init: &rest)
	)

	(method (cue)
		(self x: -65 y: 50 setMotion: PolyPath 475 40 self)
		(super cue: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					(Narrator init: (Random 1 8) 0 50)
				)
			)
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(Narrator init: (Random 9 12) 0 50)
					)
					(13 ; sharpShell
						(Narrator init: (Random 13 16) 0 50)
					)
					(17 ; spine
						(Narrator init: (Random 17 20) 0 50)
					)
					(30 ; hackSaw
						(Narrator init: (Random 20 24) 0 50)
					)
					(21 ; healingPotion
						(Narrator init: (Random 25 28) 0 50)
					)
					(29 ; fishLure
						(Narrator init: (Random 29 32) 0 50)
					)
					(else
						(Narrator init: (Random 37 41) 0 50)
					)
				)
			)
			(10 ; Recycle
				(Narrator init: (Random 33 36) 0 50)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator init: (+ 70 (Random 0 2)) 0 50)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fish3 of Actor
	(properties
		x 45
		y 55
		view 53
		detailLevel 2
		illegalBits 0
		xStep 8
	)

	(method (init)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			setCycle: Fwd
			cycleSpeed: 4
			setMotion: MoveTo 475 40 self
		)
		(super init: &rest)
	)

	(method (cue)
		(if (> (self x:) 460)
			(self y: -10 setLoop: 1 setMotion: MoveTo -575 120 self)
		else
			(self y: -10 setLoop: 0 setMotion: MoveTo 495 170 self)
		)
		(super cue: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					(Narrator init: (Random 1 8) 0 50)
				)
			)
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(Narrator init: (Random 9 12) 0 50)
					)
					(13 ; sharpShell
						(Narrator init: (Random 13 16) 0 50)
					)
					(17 ; spine
						(Narrator init: (Random 17 20) 0 50)
					)
					(30 ; hackSaw
						(Narrator init: (Random 20 24) 0 50)
					)
					(21 ; healingPotion
						(Narrator init: (Random 25 28) 0 50)
					)
					(29 ; fishLure
						(Narrator init: (Random 29 32) 0 50)
					)
					(else
						(Narrator init: (Random 37 41) 0 50)
					)
				)
			)
			(10 ; Recycle
				(Narrator init: (Random 33 36) 0 50)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator init: (+ 70 (Random 0 2)) 0 50)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fish5 of Actor
	(properties
		x 245
		y 45
		view 80
		detailLevel 3
		illegalBits 0
		xStep 4
	)

	(method (init)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			setLoop: 3
			setCycle: Fwd
			cycleSpeed: 26
			setHeading: 100
			setMotion: MoveTo 400 20 self
		)
		(super init: &rest)
	)

	(method (cue)
		(if (> (self x:) 380)
			(self x: -365 y: 160 setMotion: MoveTo 400 20 fish5)
		)
		(super cue: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					(Narrator init: (Random 1 8) 0 50)
				)
			)
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(Narrator init: (Random 9 12) 0 50)
					)
					(13 ; sharpShell
						(Narrator init: (Random 13 16) 0 50)
					)
					(17 ; spine
						(Narrator init: (Random 17 20) 0 50)
					)
					(30 ; hackSaw
						(Narrator init: (Random 20 24) 0 50)
					)
					(21 ; healingPotion
						(Narrator init: (Random 25 28) 0 50)
					)
					(29 ; fishLure
						(Narrator init: (Random 29 32) 0 50)
					)
					(else
						(Narrator init: (Random 37 41) 0 50)
					)
				)
			)
			(10 ; Recycle
				(Narrator init: (Random 33 36) 0 50)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator init: (+ 70 (Random 0 2)) 0 50)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance helpBubbles of Actor
	(properties
		x 300
		y -5
		view 341
		illegalBits 0
		xStep 2
	)

	(method (init)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			setPri: 1
			setLoop: 5
			cycleSpeed: 26
			setScript: timedHelpBubbles
		)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					(Narrator init: 50) ; "This is no time to pop bubbles!"
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					((ScriptID 2 0) init: 23 1) ; Delphineus, "Someone's calling for help. I think it's coming from above!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance frond0 of Prop
	(properties
		approachX 140
		approachY 128
	)

	(method (init)
		(self
			view: 480
			loop: 0
			cel: 0
			x: 131
			y: 52
			setPri: 0
			detailLevel: 3
			ignoreActors: 1
			setCycle: Fwd
			cycleSpeed: 23
		)
		(super init: &rest)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator init: 19) ; "Seaweed sways in the current, which is moving strongly toward the east."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance frond1 of Prop ; UNUSED
	(properties
		approachX 140
		approachY 128
	)

	(method (init)
		(self
			view: 480
			loop: 1
			cel: 0
			x: 62
			y: 40
			setPri: 0
			detailLevel: 3
			ignoreActors: 1
			setCycle: Fwd
			cycleSpeed: 33
		)
		(super init: &rest)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator init: 19) ; "Seaweed sways in the current, which is moving strongly toward the east."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance SteelCable of View
	(properties
		approachX 140
		approachY 128
	)

	(method (init)
		(self view: 480 loop: 2 cel: 0 x: 123 y: 116 setPri: 2 ignoreActors: 1)
		(super init: &rest)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((IsFlag 73)
						(Narrator init: (Random 177 179) 0 4)
					)
					((not (IsFlag 101))
						(gEgo setScript: egoGrabbed)
					)
					(else
						(gEgo setScript: egoGetsCable)
					)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(frond0 setScript: cableLookTalk)
				)
			)
			(10 ; Recycle
				(Narrator posn: -1 20 init: 84) ; "The cable might still be useful."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Jar of View
	(properties
		approachX 140
		approachY 128
	)

	(method (init)
		(self view: 482 loop: 8 cel: 0 x: 170 y: 130 setPri: 2 ignoreActors: 1)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					(gEgo setScript: egoPicksUpJar)
				)
			)
			(2 ; Look
				(cond
					((IsFlag 73)
						(Narrator init: (Random 174 176) 0 4)
					)
					((!= global233 1)
						(Narrator posn: -1 20 init: 77) ; "The jar lies on the sand near the shadowy lair."
					)
					(else
						(Narrator posn: -1 20 init: 79) ; "The jar's lid has been removed!"
					)
				)
			)
			(4 ; Inventory
				(cond
					((IsFlag 73)
						(Narrator init: (Random 174 176) 0 4)
					)
					((== global233 1)
						(Narrator posn: -1 20 init: 85) ; "The jar is already open."
					)
					(else
						(Narrator posn: -1 20 init: 62) ; "That won't open the jar."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance OctopusLair of Feature
	(properties
		x 146
		y 90
		nsTop 87
		nsLeft 91
		nsBottom 102
		nsRight 182
		approachX 140
		approachY 128
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((IsFlag 73)
						(Narrator init: (Random 177 179) 0 4)
					)
					((== local4 1)
						(if (IsFlag 313)
							(Narrator posn: -1 20 init: 36) ; "There's nothing more in the octopus' lair."
						else
							(Narrator init: 81) ; "There's nothing over here. However, the octopus has left the cable behind."
						)
					)
					(local1
						(Narrator init: 36) ; "There's nothing more in the octopus' lair."
					)
					(local5
						(Narrator init: 35) ; "The octopus came back and is just as determined to keep the cable."
					)
					((IsFlag 139)
						(Narrator init: 34) ; "Never tangle with an octopus. So to speak."
					)
					(else
						((ScriptID 2 0) init: 4 1) ; Delphineus, "Look out! I think something's moving back there!"
					)
				)
			)
			(2 ; Look
				(cond
					((IsFlag 73)
						(Narrator init: (Random 174 176) 0 4)
					)
					((== local4 1)
						(Narrator init: 37) ; "Adam has tricked the octopus into fleeing his territory. The lair is empty."
					)
					(local1
						(Narrator init: 31) ; "The lair is empty now, but the octopus is keeping watch outside."
					)
					(local5
						(Narrator init: 63) ; "The octopus has returned. He stares balefully at Adam from the safety of his lair."
					)
					((IsFlag 139)
						(Narrator init: 72) ; "The octopus loves this dark retreat."
					)
					(else
						(rm480 setScript: lairTalk)
					)
				)
			)
			(4 ; Inventory
				(if local4
					(super doVerb: theVerb invItem &rest)
				else
					(octopus doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance OceanFloor of Feature
	(properties
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator posn: -1 20 init: 2) ; "Coral dies sooner or later and gets ground up by the waves. The many-colored types of coral form sand of amazing beauty."
				)
			)
			(4 ; Inventory
				(switch invItem
					(23 ; jar
						(if local4
							(Narrator posn: -1 20 init: 45) ; "Putting the jar down here would be useless right now."
						else
							(octopus doVerb: theVerb invItem &rest)
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance EastSide of Feature
	(properties
		x 295
		y 10
		nsLeft 270
		nsBottom 185
		nsRight 319
		approachX 140
		approachY 128
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator init: 12) ; "The eastern side of the reef is showing stress. The coral begins to weaken here."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance DeadBrainCoral of Feature
	(properties
		x 291
		y 171
		nsTop 153
		nsLeft 265
		nsBottom 189
		nsRight 319
		approachX 240
		approachY 128
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator posn: -1 20 init: 5) ; "The skeleton of the brain coral has some interesting openings."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance PillarCoral of Feature
	(properties
		x 245
		y 116
		nsTop 103
		nsLeft 221
		nsBottom 129
		nsRight 269
		approachX 140
		approachY 128
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					((ScriptID 2 0) init: 16 1) ; Delphineus, "Hey, you're no amateur! Breaking the coral would kill it, you know!"
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(rm480 setScript: pillarCoralTalk)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance StaghornCoral of Feature
	(properties
		x 193
		y 147
		nsTop 135
		nsLeft 166
		nsBottom 160
		nsRight 219
		approachX 140
		approachY 128
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					((ScriptID 2 0) init: 16 1) ; Delphineus, "Hey, you're no amateur! Breaking the coral would kill it, you know!"
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator posn: -1 20 init: 9) ; "The staghorn coral is a different color here."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance TreeCoral of Feature
	(properties
		x 32
		y 47
		nsTop 17
		nsLeft 15
		nsBottom 78
		nsRight 52
		approachX 140
		approachY 128
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					((ScriptID 2 0) init: 16 1) ; Delphineus, "Hey, you're no amateur! Breaking the coral would kill it, you know!"
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator init: 6) ; "Tree coral makes the ocean floor look both strange and familiar."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance LettuceCoral1 of Feature
	(properties
		x 16
		y 114
		nsTop 100
		nsBottom 128
		nsRight 33
		approachX 140
		approachY 128
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					((ScriptID 2 0) init: 16 1) ; Delphineus, "Hey, you're no amateur! Breaking the coral would kill it, you know!"
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator init: 11) ; "Lettuce coral does resemble its vegetable counterpart. However, it's an animal."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance LettuceCoral2 of Feature
	(properties
		x 185
		y 58
		nsTop 48
		nsLeft 139
		nsBottom 68
		nsRight 231
		approachX 140
		approachY 128
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					((ScriptID 2 0) init: 16 1) ; Delphineus, "Hey, you're no amateur! Breaking the coral would kill it, you know!"
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator init: 11) ; "Lettuce coral does resemble its vegetable counterpart. However, it's an animal."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance StarletCoral of Feature
	(properties
		x 27
		y 140
		nsTop 134
		nsLeft 10
		nsBottom 147
		nsRight 44
		approachX 140
		approachY 128
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					((ScriptID 2 0) init: 16 1) ; Delphineus, "Hey, you're no amateur! Breaking the coral would kill it, you know!"
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					((ScriptID 2 0) init: 12 1) ; Delphineus, "That's a starlet coral. She thinks she's cool."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance RedbeardSponge1 of Feature
	(properties
		x 34
		y 170
		nsTop 152
		nsBottom 188
		nsRight 68
		approachX 140
		approachY 128
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator posn: -1 20 init: 10) ; "A colony of common sponge is building itself up here."
			)
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					(Narrator posn: -1 20 init: 83) ; "These are living sponges, so Adam shouldn't pick them."
				)
			)
			(4 ; Inventory
				(if (== invItem 12) ; trident
					(Narrator posn: -1 20 init: 74) ; "Making holes in the sponges won't help."
				else
					(Narrator posn: -1 20 init: 73) ; "That won't help living sponges."
				)
			)
			(10 ; Recycle
				(Narrator posn: -1 20 init: 75) ; "It's useful to gather dead sponges, not living ones."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance RedbeardSponge2 of Feature
	(properties
		x 110
		y 142
		nsTop 119
		nsLeft 85
		nsBottom 164
		nsRight 135
		approachX 140
		approachY 128
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					(frond0 setScript: egoHides)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator posn: -1 20 init: 18) ; "The sponges form a soft nest here. One of the most ancient species, they can grow tall enough to conceal a human."
				)
			)
			(4 ; Inventory
				(if (== invItem 12) ; trident
					(Narrator posn: -1 20 init: 74) ; "Making holes in the sponges won't help."
				else
					(Narrator posn: -1 20 init: 73) ; "That won't help living sponges."
				)
			)
			(10 ; Recycle
				(Narrator posn: -1 20 init: 75) ; "It's useful to gather dead sponges, not living ones."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance RedSponge of Feature
	(properties
		x 106
		y 48
		nsTop 36
		nsLeft 92
		nsBottom 59
		nsRight 119
		approachX 140
		approachY 128
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(Narrator init: 53) ; "A small colony of red sponge flourishes to the north."
				)
			)
			(4 ; Inventory
				(if (== invItem 12) ; trident
					(Narrator init: 74) ; "Making holes in the sponges won't help."
				else
					(Narrator init: 73) ; "That won't help living sponges."
				)
			)
			(10 ; Recycle
				(Narrator init: 75) ; "It's useful to gather dead sponges, not living ones."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pillarCoralTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator posn: -1 20 init: 7 self) ; "Pillar coral is that color at this depth."
			)
			(1
				(Narrator posn: -1 20 init: 8 self) ; "Coral changes color and size depending on the depth where it grows."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance fishGroupTalk of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 73))
					((ScriptID 2 0) init: 9 0 self) ; Delphineus
				else
					(self cue:)
				)
			)
			(1
				(if (not (IsFlag 73))
					((ScriptID 2 0) say: 10 0 self) ; Delphineus
				else
					(self cue:)
				)
			)
			(2
				(if (not (IsFlag 73))
					((ScriptID 2 0) say: 11 1 self) ; Delphineus
				else
					(self cue:)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance lairTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator posn: -1 30 init: 3 self) ; "The dark opening appears fairly deep."
				(= local8 1)
			)
			(1
				(if (not (IsFlag local4))
					((ScriptID 2 0) init: 4 1 self) ; Delphineus, "Look out! I think something's moving back there!"
				else
					(= cycles 1)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance octTalk1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator posn: -1 30 init: 44 self) ; "A creeping tentacle firmly grabs Adam's wrist."
			)
			(1
				((ScriptID 2 1) init: 4 1 self) ; Adam, "Hey, let go of me!"
			)
			(2
				((ScriptID 2 0) init: 1 0 self) ; Delphineus, "Yow! It's an octopus - we've disturbed his lair."
			)
			(3
				((ScriptID 2 0) say: 14 0 self) ; Delphineus
			)
			(4
				((ScriptID 2 0) say: 15 1 self) ; Delphineus
			)
			(5
				((ScriptID 2 1) init: 2 1 self) ; Adam, "I have to admit he's got a strong grip."
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance cableLookTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator posn: -1 30 init: 20 self) ; "A coiled piece of wire can be seen at the mouth of the dark opening."
			)
			(1
				(Narrator posn: -1 30 init: 13 self) ; "On looking closer, Adam sees that it's really part of a long cable."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance octLookTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 5 0 self) ; Delphineus, "Look at him! He's trying to convince you that he's really a rock. Close but no cigar, huh?"
			)
			(1
				((ScriptID 2 0) say: 21 1 self) ; Delphineus
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance enterFromDriftnet2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreHorizon: 1
					posn: 274 -20
					heading: 180
					cycleSpeed: 4
					setMotion: PolyPath 274 50 self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoGrabbed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 139)
				(if local1
					(self setScript: octFromAboveToFront self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (not (IsFlag 73))
					(gDelph setMotion: PolyPath 260 50)
				)
				(gEgo setMotion: PolyPath 186 102 self)
			)
			(2
				(HandsOff)
				(if local0
					(self setScript: octFromFrontToHide self)
				else
					(= cycles 1)
				)
			)
			(3
				(HandsOff)
				(if (not (IsFlag 73))
					(gDelph setMotion: PolyPath 250 50 self)
				else
					(= cycles 1)
				)
			)
			(4
				(gEgo setCycle: Walk setMotion: PolyPath 161 102 self)
			)
			(5
				(if (not (IsFlag 73))
					(gDelph setMotion: PolyPath 250 50)
				)
				(octopus setCel: 0)
				(gEgo setHeading: 270 self)
			)
			(6
				(octopus setCel: 1)
				(gEgo
					view: 481
					loop: 0
					x: 125
					y: 99
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(7
				(octopus setCel: 0)
				(= ticks 140)
			)
			(8
				(cond
					((== local3 0)
						(rm480 setScript: octTalk1 self)
						(= local3 1)
					)
					((IsFlag 136)
						(Narrator posn: -1 30 init: 35 self) ; "The octopus came back and is just as determined to keep the cable."
					)
					(else
						(Narrator posn: -1 30 init: 22 self) ; "The octopus doesn't intend to let Adam have his treasure."
					)
				)
			)
			(9
				(gEgo setCycle: Beg self)
			)
			(10
				(NormalEgo)
				(gEgo setMotion: PolyPath 160 102 self)
			)
			(11
				(if (not (IsFlag 73))
					(gDelph setMotion: PFollow gEgo 90)
				)
				(octopus setCel: 1)
				(gEgo setHeading: 270)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoGetsCable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 186 102 self)
				(SetScore 2 313)
			)
			(1
				(Narrator posn: -1 20 init: 29 self) ; "Adam reaches down and pulls out the cable."
			)
			(2
				(gEgo setCycle: Walk setMotion: PolyPath 156 102 self)
			)
			(3
				(gEgo get: 26) ; steelCable
				(SetScore 2 313)
				(SteelCable hide:)
				((ScriptID 2 1) init: 1 1 self) ; Adam, "A gleaming wire! I'm beginning to get an idea about what the Oracle meant!"
			)
			(4
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance mirrorCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 73))
					(gDelph setMotion: PolyPath 260 50)
				)
				(gEgo setMotion: PolyPath 173 90 self)
			)
			(1
				(SetScore 10 312)
				(if local1
					(self setScript: octFromAboveToFront self)
				else
					(= ticks 4)
				)
			)
			(2
				(if (not (IsFlag 73))
					(gDelph setMotion: MoveTo 250 50 self)
				else
					(= ticks 1)
				)
			)
			(3
				(gEgo
					setCycle: 0
					view: 481
					loop: 4
					cel: 0
					x: 134
					y: 94
					cycleSpeed: 30
				)
				(= cycles 30)
			)
			(4
				(= local9 0)
				(cond
					((IsFlag 136)
						(Narrator posn: -1 30 init: 32 self) ; "Adam does his trick with the mirror again!"
					)
					((IsFlag 139)
						(Narrator posn: -1 30 init: 24 self) ; "Adam shines the mirror toward the octopus."
					)
					(else
						(= local9 1)
						(= ticks 1)
					)
				)
			)
			(5
				(if local0
					(self setScript: octFromFrontToHide self)
				else
					(= ticks 30)
				)
			)
			(6
				(HandsOff)
				(= ticks 30)
			)
			(7
				(if local9
					((ScriptID 2 0) init: 26 1 self) ; Delphineus, "Great idea! That'll smoke out anything that's hiding in there."
				else
					(Narrator posn: -1 30 init: 27 self) ; "The octopus peers into the mirror. Red with rage, he charges out to fight the "other" octopus!"
				)
			)
			(8
				(gEgo setCycle: CT 5 1)
				(octopus
					setCycle: 0
					view: 482
					loop: 4
					cel: 1
					x: 148
					y: 99
					cycleSpeed: 24
					setCycle: CT 6 1 self
				)
			)
			(9
				(if local9
					(Narrator posn: -1 30 init: 55 self) ; "An octopus comes charging out to fight the "other" octopus in the mirror."
				else
					(++ state)
					(= ticks 1)
				)
			)
			(10
				((ScriptID 2 0) init: 27 1 self) ; Delphineus, "He's furious! They're such hermits!"
			)
			(11
				(gEgo cel: 6)
				(octopus cel: 7)
				(= cycles 5)
			)
			(12
				(if (IsFlag 136)
					(= ticks 1)
				else
					(Narrator posn: -1 130 init: 25 self) ; "Whoops! The octopus sees Adam! A human! White with fear, he shoots a cloud of ink and flees!"
				)
			)
			(13
				(gSoundEffects number: 483 loop: 1 play:)
				(gEgo setCycle: End)
				(octopus setCycle: End self)
			)
			(14
				(octopus
					setLoop: 5
					x: 106
					y: 96
					xStep: 8
					cycleSpeed: 16
					setCycle: Fwd
					setMotion: PolyPath -50 (octopus y:) self
				)
				(gEgo posn: 193 94)
				(NormalEgo 7 802)
			)
			(15
				(octopus stopUpd: hide:)
				(= ticks 120)
			)
			(16
				(if (IsFlag 136)
					(Narrator posn: -1 30 init: 33 self) ; "The octopus is good at lots of things, but remembering isn't one of them. He fell for it again!"
				else
					((ScriptID 2 1) init: 27 1 self) ; Adam, "Phew! Just like skunks!"
				)
			)
			(17
				(if (IsFlag 136)
					(= ticks 1)
				else
					((ScriptID 2 0) init: 20 1 self) ; Delphineus, "Actually, like octopi! That ink's supposed to be, like, a fake octopus to throw you off the track!"
				)
			)
			(18
				(if (not (IsFlag 73))
					(gDelph setMotion: MoveTo 215 64 self)
				else
					(= ticks 1)
				)
			)
			(19
				(= local5 0)
				(= local2 0)
				(= local1 0)
				(= local0 0)
				(SetFlag 139)
				(SetFlag 101)
				(SetFlag 136)
				(= local4 1)
				(if (not (IsFlag 73))
					(gDelph setMotion: PFollow gEgo 90)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoPlaceJar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 139))
					(Narrator init: 54 self) ; "On a hunch, Adam puts the jar down in front of the dark opening."
				else
					(= ticks 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 220 126 self)
			)
			(2
				(gEgo setMotion: PolyPath 208 121 self)
			)
			(3
				(gEgo
					setCycle: 0
					view: 481
					loop: 2
					cel: 0
					posn: 152 129
					cycleSpeed: 16
					setCycle: CT 2 1 self
				)
			)
			(4
				(Jar init: show:)
				(gEgo posn: 208 121)
				(NormalEgo)
				(gEgo setMotion: PolyPath 200 116 self)
			)
			(5
				(gEgo setHeading: 270)
				(gEgo put: 23 480) ; jar
				(= local7 1)
				(if (IsFlag 139)
					((ScriptID 2 0) init: 3 1 self) ; Delphineus, "What did I tell you? Octopi are really hung up! I doubt he'll touch it while you're watching. Better hide."
				else
					((ScriptID 2 0) init: 25 1 self) ; Delphineus, "Let's back off, Adam and see what happens. I think I hear something in that hole. Find someplace to hide!"
				)
				(NormalEgo)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoHides of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 200 110 self)
			)
			(1
				(gEgo setMotion: PolyPath 167 140 self)
			)
			(2
				(gEgo setCycle: 0)
				(= ticks 10)
			)
			(3
				(gEgo
					view: 481
					setLoop: 3
					x: 130
					y: 172
					setPri: 15
					cycleSpeed: 18
					cel: 0
					setCycle: End self
				)
				(SetScore 5 315)
			)
			(4
				(gEgo setCycle: CT 9 -1)
				(= ticks 120)
			)
			(5
				(gEgo setCycle: CT 11 1)
				(= ticks 120)
			)
			(6
				(HandsOn)
				(if (or (== local4 1) (== global233 1))
					(frond0 setScript: egoUnhides self)
				else
					(Narrator posn: -1 50 init: 46) ; "Adam burrows into the soft sponges. From this comfortable hiding spot, he peers out at the octopus."
					(if (== local7 1)
						(octopus setScript: octOpensJar self)
					else
						(frond0 setScript: egoUnhides self)
					)
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance egoUnhides of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: CT 9 -1 self)
			)
			(1
				(gEgo hide: view: 802 loop: 0 posn: 100 140)
				(= ticks 10)
			)
			(2
				(NormalEgo 0 802)
				(= ticks 10)
			)
			(3
				(if (not (IsFlag 73))
					(gDelph setMotion: MoveTo 215 66 self)
				else
					(= ticks 2)
				)
			)
			(4
				(gEgo show: setMotion: PolyPath 155 125)
				(self dispose:)
			)
		)
	)
)

(instance octFromAboveToFront of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(octopus
					view: 482
					setLoop: 7
					posn: 151 78
					cel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(octopus posn: 153 94 cel: 1 setCycle: End self)
			)
			(2
				(= local1 0)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance octFromFrontToHide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(octopus view: 482 setLoop: 9 setCycle: 0 cel: 4 posn: 154 110)
				(= cycles 14)
			)
			(1
				(octopus cel: 3)
				(= cycles 14)
			)
			(2
				(octopus posn: 152 99 cel: 2)
				(= cycles 14)
			)
			(3
				(octopus cel: 1)
				(= cycles 14)
			)
			(4
				(octopus posn: 145 99 cel: 0)
				(= cycles 14)
			)
			(5
				(= local0 0)
				(= local2 1)
				(self dispose:)
			)
		)
	)
)

(instance octFromHideToFront of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(octopus view: 482 setLoop: 9 setCycle: 0 cel: 1 posn: 152 99)
				(= cycles 14)
			)
			(1
				(octopus cel: 2)
				(= cycles 14)
			)
			(2
				(octopus posn: 154 110 cel: 3)
				(= cycles 14)
			)
			(3
				(octopus cel: 4)
				(= cycles 14)
			)
			(4
				(= local0 1)
				(= local2 0)
				(self dispose:)
			)
		)
	)
)

(instance octOpensJar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 73))
					(gDelph setMotion: PolyPath 260 50 self)
				else
					(self cue:)
				)
			)
			(1
				(if (not (IsFlag 73))
					(gDelph setMotion: PolyPath 240 60)
				)
				(cond
					((== local2 1)
						(self setScript: octFromHideToFront self)
					)
					((== local1 1)
						(self setScript: octFromAboveToFront self)
					)
					((== local0 1)
						(= ticks 1)
					)
				)
			)
			(2
				(HandsOff)
				(if (not (IsFlag 139))
					(SetFlag 139)
					((ScriptID 2 0) init: 24 1 self) ; Delphineus, "Lookit! An octopus - they're curious about everything but kind of cranky."
				else
					(self cue:)
				)
			)
			(3
				(Narrator posn: -1 20 init: 41) ; "The octopus thinks he's alone now. He sneaks a tentacle out and grabs hold of the jar."
				(octopus
					posn: 154 104
					setLoop: 1
					setCycle: End self
					cycleSpeed: 8
				)
				(Jar hide:)
				(= ticks 60)
			)
			(4
				(octopus setCycle: End self)
				(if (not (IsFlag 73))
					(gDelph setMotion: PolyPath 250 50)
				)
			)
			(5
				(octopus setLoop: 2 setCycle: End self)
			)
			(6
				(octopus setCycle: End self)
				(= register 3)
			)
			(7
				(octopus loop: 3 cycleSpeed: 18 setCycle: CT 12 1 self)
			)
			(8
				(gDelph setHeading: 225 self)
			)
			(9
				(Narrator posn: -1 20 init: 42 self) ; "He thoroughly explores the jar."
			)
			(10
				(octopus setCycle: CT 9 -1 self)
			)
			(11
				(gSoundEffects number: 481 loop: 1 play:)
				(octopus setCycle: CT 12 1 self)
			)
			(12
				(if (-- register)
					(-= state 3)
					(= cycles 1)
				else
					(octopus setCycle: End self)
				)
			)
			(13
				(= global233 1)
				((ScriptID 2 0) init: 8 1 self) ; Delphineus, "Look at that - he untwisted that lid. Kind of the Can Opener of the Sea! Harhar!"
				(SetScore 5 311)
			)
			(14
				(Jar setCel: 1 x: (- (Jar x:) 11) show:)
				(self setScript: octFromFrontToHide self)
			)
			(15
				(frond0 setScript: egoUnhides self)
			)
			(16
				(gEgo setMotion: PolyPath 210 103)
				(if (not (IsFlag 73))
					(gDelph setMotion: PFollow gEgo 90)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoPicksUpJar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 220 126 self)
			)
			(1
				(gEgo setMotion: PolyPath 202 121 self)
			)
			(2
				(gEgo get: 23) ; jar
				(= local7 0)
				(Jar hide: dispose:)
				(NormalEgo)
				(= ticks 30)
				(SetScore 2 314)
			)
			(3
				(cond
					((!= global233 1)
						(= ticks 1)
					)
					((or (IsFlag 101) (not (IsFlag 139)))
						(Narrator posn: -1 20 init: 80 self) ; "Adam picks up the open jar."
					)
					(else
						(Narrator posn: -1 20 init: 48 self) ; "Adam picks up the open jar but keeps one eye on the octopus!"
					)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance timedHelpBubbles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 4200)
				(self setScript: bubbleComment)
			)
			(1
				(= ticks 2400)
			)
			(2
				(helpBubbles
					posn: 300 5
					show:
					cel: 0
					setCycle: CT 8 1
					setMotion: MoveTo 280 20
				)
				(= ticks 240)
			)
			(3
				(helpBubbles hide:)
				(= ticks 480)
			)
			(4
				(helpBubbles
					posn: 300 5
					show:
					cel: 0
					setCycle: CT 8 1
					setMotion: MoveTo 280 20
				)
				(= ticks 240)
			)
			(5
				(helpBubbles hide:)
				(= ticks 60)
			)
			(6
				(if (not (IsFlag 67))
					(= state 0)
				)
				(self cue:)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance bubbleComment of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 13200)
			)
			(1
				(if (not (IsFlag 73))
					((ScriptID 2 0) init: 19 1 self) ; Delphineus, "Adam, I think I hear someone calling. It seems to be coming from somewhere above us!"
				else
					(= cycles 1)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

