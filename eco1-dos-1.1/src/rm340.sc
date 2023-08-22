;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use Polygon)
(use Motion)
(use System)

(public
	rm340 0
)

(local
	[local0 14] = [-1 -1 -30 29 15 360 67 -30 108 4096 0 290 210 -32768]
	[local14 16] = [-1 0 -20 300 0 -30 30 360 35 4096 15 -30 168 195 360 -32768]
	[local30 16] = [-1 1 360 170 15 -20 210 360 183 160 167 8192 -1 -30 177 16384]
)

(instance rm340 of EcoRoom
	(properties
		lookStr 1
		picture 340
		style 7
		horizon 15
		north 322
		south 260
		walkOffTop 1
	)

	(method (init)
		(= global250 3)
		(NormalEgo)
		(NormalDelph)
		(gEgo init: x: 170 ignoreHorizon:)
		(gDelph
			z: 0
			x: 150
			setPri: 14
			setStep: 4 6
			ignoreHorizon:
			setScript: delScript
		)
		(if (== gPrevRoomNum north)
			(gDelph init: y: -70 setMotion: MoveTo 140 80 delScript)
			(gEgo setHeading: 180)
		else
			(gDelph init: y: 250 setMotion: MoveTo 140 120 delScript)
			(gEgo setHeading: 0)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:) type: PBarredAccess init: 0 189 0 0 16 0 16 189 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 296 189 296 0 319 0 319 189
					yourself:
				)
			setRegions: 51 50 ; bubblesRegion, regionFish
		)
		(super init: &rest)
		((ScriptID 50 0) addFish: @local30 @local14 @local0) ; regionFish
		(gLongSong number: 332 loop: -1 play:)
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_TOP)
				(gEgo edgeHit: EDGE_NONE)
				(gCurRoom setScript: dontGo)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(gDelph setMotion: MoveTo (gEgo x:) 250)
			)
		)
		(super doit:)
	)
)

(instance dontGo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 0) init: 1 0 0 5 1 self) ; Delphineus, "Please don't turn back now, Adam. Eluria needs you."
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) 30 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance delScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(Face gDelph gEgo self)
			)
			(2
				(if (== gPrevRoomNum (gCurRoom north:))
					(self setScript: firstKelpTalk self)
				else
					((ScriptID 2 0) init: 1 0 0 5 1 self) ; Delphineus, "Please don't turn back now, Adam. Eluria needs you."
				)
			)
			(3
				(= seconds 12)
			)
			(4
				(HandsOff)
				((ScriptID 2 0) init: 1 0 0 4 1 self) ; Delphineus, "I'm counting on you to find our way through the weeds, Adam!"
			)
			(5
				(gEgo setMotion: MoveTo (gEgo x:) 200 self)
				(gDelph setMotion: MoveTo (gDelph x:) 250)
			)
			(6
				(gCurRoom newRoom: (gCurRoom south:))
				(self dispose:)
			)
		)
	)
)

(instance firstKelpTalk of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 1 0 0 1 1 self) ; Delphineus, "Oh, my head! I feel kinda funny. I mean, funny peculiar."
			)
			(1
				((ScriptID 2 1) init: 2 0 0 1 1 self) ; Adam, "Maybe we ought to go back. You could still be hurt!"
			)
			(2
				(= seconds 3)
			)
			(3
				((ScriptID 2 0) init: 1 0 0 2 1 self) ; Delphineus, "No, it's not that. I think there was something in that garbage we swam through. It's interfered with my sonar - you know, my direction-finding senses."
			)
			(4
				(= seconds 3)
			)
			(5
				((ScriptID 2 1) init: 2 0 0 2 1 self) ; Adam, "What do you want to do? That's a lot of tangled seaweed up ahead."
			)
			(6
				((ScriptID 2 0) init: 1 0 0 3 1 self) ; Delphineus, "We have to go through. Cetus used to clear a path for us, but it's gotten overgrown. There's one way through. I can follow if you lead."
			)
			(7
				(= seconds 1)
			)
			(8
				((ScriptID 2 1) init: 2 0 0 3 1 self) ; Adam, "Okay, I'll try!"
			)
			(9
				(self dispose:)
			)
		)
	)
)

