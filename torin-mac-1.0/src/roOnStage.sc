;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use n64896)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roOnStage 0
	soPlaySaw 1
)

(instance sawSound of TPSound
	(properties)
)

(instance soEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 195 267 self)
			)
			(1
				(gEgo setMotion: MoveTo 316 280 self)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(poTorin view: 51001 loop: 0 posn: 298 315 init:)
				((ScriptID 64017 0) set: 211) ; oFlags
				(gEgo dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poCopBody of Prop
	(properties
		x 165
		y 292
		priority 292
		fixPriority 1
		view 51002
		loop 3
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(poCopHead init: &rest)
		(poCopHat init: &rest setCycle: Fwd)
		(= gtCop toCopTalker)
	)

	(method (dispose)
		(super dispose: &rest)
		(poCopHead dispose: &rest)
		(poCopHat dispose: &rest)
		(= gtCop 0)
	)
)

(instance toCopTalker of Talker
	(properties
		x 165
		y 292
		view 51002
		loop 4
		priority 291
	)

	(method (init)
		(poCopHead hide:)
		(super init: &rest)
	)

	(method (dispose)
		(poCopHead show:)
		(super dispose:)
	)
)

(instance poCopHead of Prop
	(properties
		x 165
		y 292
		priority 291
		fixPriority 1
		view 51002
		loop 4
	)

	(method (init)
		(super init: &rest)
		(poCopHat init: &rest setCycle: Fwd)
	)

	(method (dispose)
		(super dispose: &rest)
		(poCopHat dispose: &rest)
	)

	(method (posn nx ny &tmp dx dy)
		(= dx (- nx x))
		(= dy (- ny y))
		(super posn: nx ny)
		(if (toCopTalker mouth:)
			((toCopTalker mouth:)
				posn:
					(+ ((toCopTalker mouth:) x:) dx)
					(+ ((toCopTalker mouth:) y:) dy)
			)
		)
		(poCopHat posn: (+ (poCopHat x:) dx) (+ (poCopHat y:) dy))
	)
)

(instance poCopHat of Prop
	(properties
		x 213
		y 149
		priority 316
		fixPriority 1
		view 51002
		loop 5
		cycleSpeed 10
	)
)

(instance oFootTap of TPSound
	(properties)
)

(instance oBatonWhack of TPSound
	(properties)
)

(instance soCopWhack of Script
	(properties)

	(method (init)
		(poCop hide:)
		(poCopBody init:)
		(super init: &rest)
	)

	(method (dispose)
		(poCopBody dispose:)
		(poCop show:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oFootTap playSound: 51002)
				(poCopBody setCel: 0)
				(poCopHead posn: 166 296)
				(= ticks (poCopBody cycleSpeed:))
			)
			(1
				(poCopBody setCel: 1)
				(poCopHead posn: 164 295)
				(= ticks (poCopBody cycleSpeed:))
			)
			(2
				(poCopBody setCel: 2)
				(poCopHead posn: 162 292)
				(= ticks (poCopBody cycleSpeed:))
			)
			(3
				(oFootTap playSound: 51002)
				(poCopBody setCel: 3)
				(= ticks (poCopBody cycleSpeed:))
			)
			(4
				(poCopBody setCel: 4)
				(poCopHead posn: 161 292)
				(= ticks (poCopBody cycleSpeed:))
			)
			(5
				(oBatonWhack playSound: 51004)
				(poCopBody setCel: 5)
				(poCopHead posn: 163 292)
				(= ticks (poCopBody cycleSpeed:))
			)
			(6
				(poCopBody setCel: 6)
				(poCopHead posn: 162 293)
				(= ticks (poCopBody cycleSpeed:))
				(= state -1)
			)
		)
	)
)

(instance soCopEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 playSound: 50499)
				(poCop setCel: 0 setLoop: 1 init: setCycle: End self)
			)
			(1
				(poCop setScript: soCopWhack)
				(self dispose:)
			)
		)
	)
)

(instance soStopSaw of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (poTorin cel:) (poTorin lastCel:))
					(poTorin setCycle: End self)
				else
					(= ticks 1)
				)
			)
			(1
				(poTorin setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soPlaySaw of TPScript
	(properties)

	(method (init)
		(sawSound preload: 51003)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					put:
						((ScriptID 64001 0) get: 55) ; oInvHandler, ioSaw
						((ScriptID 64001 0) get: 60) ; oInvHandler, ioRosinedBow
				)
				(gEgo
					get:
						((ScriptID 64001 0) get: 55) ; oInvHandler, ioSaw
						((ScriptID 64001 0) get: 60) ; oInvHandler, ioRosinedBow
				)
				((ScriptID 64017 0) set: 212) ; oFlags
				(poTorin cel: 0 setCycle: End self)
			)
			(1
				(= gtTorin toTorin)
				(toTorin x: 276 y: 172)
				(gMessager say: 0 0 0 1 self) ; "(WITH LITTLE CONFIDENCE) And now, a medley of my favorite songs from The Lands Above!"
			)
			(2
				(= gtTorin 0)
				(poTorin view: 51004 setLoop: 0 init: setCycle: End self)
			)
			(3
				((ScriptID 64017 0) set: 212) ; oFlags
				(= ticks 15)
			)
			(4
				(gMessager say: 0 0 2 0 self) ; "(YOU CAN'T SING THIS BADLY ENOUGH) Where the peat moss croons, In the light of three full moons, And those crystal mountains summon my heart home. Yes, The Lands Above, Are the place I'll always love, No-o matter through how many worlds I roam!"
				(poTorin view: 51003 setLoop: 0 setCel: 0 setCycle: Fwd)
			)
			(5
				(self setScript: soCopEnter self)
			)
			(6
				(gMessager say: 0 0 0 2 self) ; "That's it. That's it! Now come with me."
				(self setScript: soStopSaw self)
			)
			(7)
			(8
				(= gtTorin toTorin)
				(toTorin x: 277 y: 173)
				(gMessager sayRange: 0 0 0 3 6 self) ; "But, officer! (NOTICING, HOPEFUL) Why, you have tears in your eyes! Are you from The Lands Above, too?"
			)
			(9
				(= gtTorin 0)
				(poCop setScript: 0 setCel: 0 setLoop: 2 setCycle: CT 5 1 self)
			)
			(10
				(poTorin dispose:)
				(poCop setCycle: CT 10 1 self)
				(gEgo put: ((ScriptID 64001 0) get: 55)) ; oInvHandler, ioSaw
				(gEgo put: ((ScriptID 64001 0) get: 56)) ; oInvHandler, ioBow
			)
			(11
				(sawSound playSound: 51003)
				(poCop setCycle: End self)
			)
			(12
				(FadeToBlack 1 10 self)
				(goSound1 fadeOut: 1 9 self)
			)
			(13)
			(14
				(self dispose:)
				(gCurRoom newRoom: 55000) ; roJudge2Movie
			)
		)
	)
)

(instance poCop of Prop
	(properties
		x 165
		y 292
		view 51002
		loop 1
		cycleSpeed 10
	)
)

(instance foStool of Feature
	(properties
		x 299
		y 275
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 272 304 278 245 291 236 307 237 320 242 326 306 320 309 318 296 301 299 300 314 295 315 294 300 278 294 278 306
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance toTorin of Talker
	(properties
		view 51003
		loop 3
	)

	(method (init)
		(= priority (+ 1 (poTorin priority:)))
		(super init: &rest)
	)
)

(instance poTorin of Prop
	(properties
		view 51001
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self addHotspotVerb: 67)
		(foStool init:)
	)

	(method (onMe ev)
		(return (and (super onMe: ev) (not (foStool onMe: ev))))
	)

	(method (doVerb theVerb)
		(if (== theVerb 67) ; ioSaw
			(gCurRoom setScript: soPlaySaw)
		)
	)
)

(instance roOnStage of TPRoom
	(properties
		picture 51000
		purge 2500
	)

	(method (init)
		(super init: &rest)
		(DisposeScript 50901)
		((ScriptID 64017 0) set: 211) ; oFlags
		(goSound1 preload: 50499)
		(Load rsVIEW 51001)
		(gGame handsOff:)
		(gEgo normalize: posn: -20 440 setScalePercent: 145 init:)
		(gCurRoom setScript: soEnterRoom)
	)
)

