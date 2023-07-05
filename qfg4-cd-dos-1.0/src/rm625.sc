;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 625)
(include sci.sh)
(use Main)
(use GloryRm)
(use Scaler)
(use Osc)
(use PolyPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm625 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm625 of GloryRm
	(properties
		modNum 620
		picture 620
		north 643
	)

	(method (init)
		(RemapColors 2 253 140) ; ByPercent
		(RemapColors 2 254 60) ; ByPercent
		(switch gPrevRoomNum
			(643
				(gEgo posn: 88 32)
			)
			(630
				(gEgo posn: 276 152)
			)
			(else
				(gEgo posn: 276 152)
			)
		)
		(gEgo init: setScaler: Scaler 105 32 180 31 normalize:)
		((ScriptID 633 0) init:) ; rm620Code
		(super init: &rest)
		(theGhost init: setScaler: Scaler 103 43 117 33 hide:)
		(gGlory handsOn:)
		(theGhost setScript: doMyThing)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: 0 1 0 0 0 625) ; "You are on a winding stairway. The door at the bottom heads south into the Great Hall. Torches line the walls. You feel a ghostly, uneasy presence here."
			)
			((== theVerb 86) ; flameDartSpell
				(= local3 3)
				(gCurRoom setScript: sThrowIt)
			)
			((== theVerb 93) ; lightningBallSpell
				(= local3 4)
				(gCurRoom setScript: sThrowIt)
			)
			((== theVerb 88) ; forceBoltSpell
				(= local3 5)
				(gCurRoom setScript: sThrowIt)
			)
			((== theVerb 79) ; frostSpell
				(= local3 6)
				(gCurRoom setScript: sThrowIt)
			)
			((== theVerb 21) ; theRocks
				(gEgo use: 6 1) ; theRocks
				(= local3 2)
				(gCurRoom setScript: sThrowIt)
			)
			((== theVerb 83) ; dazzleSpell
				(Palette 2 0 255 500) ; PalIntensity
				(Palette 2 0 255 100) ; PalIntensity
				(gMessager say: 4 6 28 1 0 620) ; "Your actions have no effect."
				(return 1)
			)
			((== theVerb 37) ; theThrowdagger
				(if (== (gEgo has: 5) 1) ; theThrowdagger
					(gMessager say: 4 6 34) ; MISSING MESSAGE
				else
					(gEgo use: 5 1) ; theThrowdagger
					(= local3 1)
					(gCurRoom setScript: sThrowIt)
				)
			)
			((== theVerb 36) ; theSword
				(gCurRoom setScript: sSlash)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if script
			(script dispose:)
		)
		((ScriptID 633 3) stop: clean: (ScriptID 633 3)) ; wasMusic3, wasMusic3
		(DisposeScript 633)
		(super dispose:)
	)
)

(instance sSlash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath (theGhost x:) (theGhost y:) self)
			)
			(1
				(Face gEgo theGhost self)
			)
			(2
				(gEgo
					view: 38
					setLoop: 1
					setCel: 0
					posn: (- (gEgo x:) 1) (+ (gEgo y:) 2)
					setCycle: End self
				)
			)
			(3
				(sndSwish play:)
				(gEgo
					setLoop: 5
					setCel: 0
					x: (+ (gEgo x:) 2)
					setCycle: Osc 4 self
				)
			)
			(4
				(gEgo setCel: 8 setCycle: Beg self)
			)
			(5
				(sndSwish stop:)
				(gEgo
					setLoop: 1
					setCel: 10
					x: (- (gEgo x:) 2)
					setCycle: Beg self
				)
			)
			(6
				(gEgo posn: (+ (gEgo x:) 1) (- (gEgo y:) 2) normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch local3
					(1
						(if (== (gEgo has: 5) 1) ; theThrowdagger
							(gMessager say: 4 6 34) ; MISSING MESSAGE
						else
							(self setScript: (ScriptID 32) self 37) ; project
						)
					)
					(2
						(self setScript: (ScriptID 32) self 21) ; project
					)
					(3
						(self setScript: (ScriptID 32) self 86) ; project
					)
					(4
						(self setScript: (ScriptID 32) self 93) ; project
					)
					(5
						(self setScript: (ScriptID 32) self 88) ; project
					)
					(6
						(self setScript: (ScriptID 32) self 79) ; project
					)
				)
			)
			(1
				(= seconds 8)
			)
			(2
				(gEgo normalize:)
				(gMessager say: 4 6 28 1 self 620) ; "Your actions have no effect."
			)
			(3
				(= local3 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doMyThing of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (<= (gEgo distanceTo: theGhost) 30) (not local2))
			(gMessager say: 4 6 8 0 0 620) ; "You shiver as the ghost passes through you. A cold chill remains behind."
			(= local2 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (and (== gHeroType 3) (not local1)) ; Paladin
					(= local1 1)
					(gMessager say: 4 6 7 0 self 620) ; "You feel a strong sense of sorrow and loss."
				else
					(self cue:)
				)
			)
			(2
				(sndEerie play:)
				(theGhost
					posn: 81 35
					setPri: 238
					show:
					ignoreActors: 1
					setCycle: Fwd
					cycleSpeed: 12
					setMotion: MoveTo 57 61 self
				)
			)
			(3
				(sndEerie stop:)
				(theGhost setMotion: MoveTo 78 107 self)
			)
			(4
				(theGhost setMotion: MoveTo 161 142 self)
			)
			(5
				(theGhost setMotion: MoveTo 335 189 self)
			)
			(6
				(theGhost hide:)
				(= local0 (Random 1 2))
				(= seconds (Random 20 30))
			)
			(7
				(= local2 0)
				(self changeState: 0)
			)
		)
	)
)

(instance aZap of Actor ; UNUSED
	(properties
		x 79
		y 166
		view 31
		loop 2
		signal 16385
	)
)

(instance theGhost of Actor
	(properties
		noun 9
		modNum 620
		priority 238
		fixPriority 1
		view 845
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 86) ; flameDartSpell
				(= local3 3)
				(gCurRoom setScript: sThrowIt)
			)
			((== theVerb 93) ; lightningBallSpell
				(= local3 4)
				(gCurRoom setScript: sThrowIt)
			)
			((== theVerb 88) ; forceBoltSpell
				(= local3 5)
				(gCurRoom setScript: sThrowIt)
			)
			((== theVerb 79) ; frostSpell
				(= local3 6)
				(gCurRoom setScript: sThrowIt)
			)
			((== theVerb 21) ; theRocks
				(gEgo use: 6 1) ; theRocks
				(= local3 2)
				(gCurRoom setScript: sThrowIt)
			)
			((== theVerb 83) ; dazzleSpell
				(Palette 2 0 255 500) ; PalIntensity
				(Palette 2 0 255 100) ; PalIntensity
				(gMessager say: 4 6 28 1 0 620) ; "Your actions have no effect."
				(return 1)
			)
			((== theVerb 37) ; theThrowdagger
				(if (== (gEgo has: 5) 1) ; theThrowdagger
					(gMessager say: 4 6 34) ; MISSING MESSAGE
				else
					(gEgo use: 5 1) ; theThrowdagger
					(= local3 1)
					(gCurRoom setScript: sThrowIt)
				)
			)
			((== theVerb 36) ; theSword
				(gCurRoom setScript: sSlash)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sndSwish of Sound
	(properties
		number 967
		loop -1
	)
)

(instance sndEerie of Sound
	(properties
		number 612
	)
)

