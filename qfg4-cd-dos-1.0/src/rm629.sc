;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 629)
(include sci.sh)
(use Main)
(use GloryRm)
(use DeathIcon)
(use GloryTalker)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm629 0
	goonTalker 1
	goonTalker2 2
)

(local
	local0
	local1
)

(instance rm629 of GloryRm
	(properties
		modNum 620
		picture 620
		north 661
	)

	(method (init)
		(if (== gPrevRoomNum 670)
			(gLongSong doSongs: 630 631 632)
		)
		(gEgo
			posn: 88 34
			init:
			setScaler: Scaler 105 32 180 31
			normalize:
			setScript: sEnterItemsDone
		)
		((ScriptID 633 0) init:) ; rm620Code
		(pGoon1 init:)
		(pGoon2 init:)
		(super init: &rest)
		(dStair1 init:)
		(dStair2 init:)
		(dStair3 init:)
		(gGlory save: 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 629) ; "You are on a winding stairway in the northeastern section of the castle. Two ugly goons guard a door at the bottom."
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		((ScriptID 633 3) stop: clean: (ScriptID 633 3)) ; wasMusic3, wasMusic3
		(if script
			(script dispose:)
		)
		(DisposeScript 633)
		(super dispose:)
	)
)

(instance sEnterItemsDone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 6)
			)
			(1
				(if (not (IsFlag 118))
					(gGlory handsOff:)
					(squeakySound play:)
					(gMessager say: 6 6 15 0 self 620) ; "I heard somting. D'you hear somting?"
				else
					(self cue:)
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(if (== gHeroType 3) ; Paladin
					(gGlory handsOff:)
					(gMessager say: 4 6 16 0 self 620) ; "You sense danger at the bottom of the stairwell. Maybe it has something to do with the two Goons guarding the lower door."
				else
					(self cue:)
				)
			)
			(4
				(= ticks 60)
			)
			(5
				(gGlory handsOff:)
				(gMessager say: 4 6 17 0 self 620) ; "You hear voices at the bottom of the stairs."
			)
			(6
				(gGlory handsOn:)
				(= seconds 8)
			)
			(7
				(gGlory handsOff:)
				(gMessager say: 4 6 18 0 self 620) ; "Boring. Dis is definitely boring."
			)
			(8
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDown1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local0)
					(gEgo setMotion: 0)
					(gGlory handsOff:)
					(gMessager say: 4 6 20 0 self 620) ; "You know, there are those two huge Goon guards down at the bottom. Are you sure this is such a good time to head down the stairs?"
				else
					(self dispose:)
				)
			)
			(1
				(gGlory handsOn:)
				(= local0 1)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance sDown2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local1)
					(gGlory handsOff:)
					(gEgo setMotion: 0)
					(gMessager say: 4 6 21 0 self 620) ; "This really isn't such a hot idea. It would be certain death to get too close to those guards."
				else
					(self dispose:)
				)
			)
			(1
				(= local1 1)
				(= local0 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDown3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(EgoDead 22 620) ; "The two Goons decide to have a Taffy (or maybe it's a Patsy) pulling contest. They're very disappointed when you break instead of stretching any further."
			)
		)
	)
)

(instance pGoon1 of Prop
	(properties
		noun 6
		modNum 620
		x 287
		y 171
		view 629
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(gMessager say: 4 6 19 0 0 620) ; "Right. There are these two guards about the size of thousand-year-old redwood trees guarding the stairs, and you want to talk to them. Why don't you just walk down the stairs and meet them close up while you're at it? I'll stay here."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pGoon2 of Prop
	(properties
		noun 6
		modNum 620
		x 250
		y 171
		priority 75
		fixPriority 1
		view 629
		loop 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(pGoon1 doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance dStair1 of Feature
	(properties
		nsLeft 42
		nsTop 50
		nsRight 73
		nsBottom 64
		sightAngle 180
		x 50
		y 51
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 50 51 73 50 64 64 42 64
						yourself:
					)
					2
					4
					5
					sDown2
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance dStair2 of Feature
	(properties
		nsLeft 61
		nsTop 40
		nsRight 95
		nsBottom 42
		sightAngle 180
		x 61
		y 40
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 93 40 85 42 61 42 71 40
						yourself:
					)
					2
					4
					5
					sDown1
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance dStair3 of Feature
	(properties
		nsLeft 39
		nsTop 67
		nsRight 63
		nsBottom 77
		sightAngle 180
		x 39
		y 67
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 41 67 63 67 62 77 39 77
						yourself:
					)
					2
					4
					5
					sDown3
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance goonTalker of GloryTalker
	(properties
		x 0
		y 8
		talkWidth 150
		view 628
		textX 140
		textY 5
	)

	(method (hide)
		(super hide:)
		(goonFinger hide:)
	)

	(method (showAgain)
		(super showAgain:)
		(goonFinger show:)
	)

	(method (init)
		(goonFinger init: cycleSpeed: 12 setCycle: Fwd)
		(super init: goonMouth 0 goonEyes goonFrame &rest)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(goonFinger dispose:)
		)
		(super dispose: param1)
	)
)

(instance goonFrame of View
	(properties
		y 8
		view 628
	)
)

(instance goonMouth of Prop
	(properties
		x 79
		y 50
		view 628
		loop 1
	)
)

(instance goonEyes of Prop
	(properties
		x 85
		y 31
		view 628
		loop 2
	)
)

(instance goonFinger of Prop
	(properties
		x 73
		y 89
		view 628
		loop 3
	)
)

(instance goonTalker2 of GloryTalker
	(properties
		x 0
		y 4
		talkWidth 150
		view 626
		textX 140
		textY 5
	)

	(method (init)
		(goon2Brow init: cycleSpeed: 12 setCycle: Fwd)
		(super init: goon2Mouth 0 goon2Eyes goon2Frame &rest)
	)

	(method (hide)
		(super hide:)
		(goon2Brow hide:)
	)

	(method (showAgain)
		(super showAgain:)
		(goon2Brow show:)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(goon2Brow dispose:)
		)
		(super dispose: param1)
	)
)

(instance goon2Frame of View
	(properties
		y 4
		view 626
	)
)

(instance goon2Mouth of Prop
	(properties
		x 60
		y 47
		view 626
		loop 1
	)
)

(instance goon2Eyes of Prop
	(properties
		x 77
		y 41
		view 626
		loop 2
	)
)

(instance goon2Brow of Prop
	(properties
		x 66
		y 36
		view 626
		loop 3
	)
)

(instance squeakySound of Sound
	(properties
		number 143
	)
)

