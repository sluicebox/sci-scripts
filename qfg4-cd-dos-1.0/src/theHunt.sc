;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use Array)
(use PChase)
(use LoadMany)
(use Grooper)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	theHunt 0
	nec1 1
	nec2 2
	nec3 3
	sBlackOut 4
)

(local
	local0
	local1
)

(instance theHunt of Rgn
	(properties
		modNum 51
	)

	(method (init)
		(= local1 (IntArray with: 0 60 63 80))
		(= global366 0)
		(= gCombatMonsterNum 0)
		(LoadMany rsSCRIPT 64991)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; theRocks
				(gCurRoom setScript: (ScriptID 32) gCurRoom 21) ; project
			)
			(37 ; theThrowdagger
				(gCurRoom setScript: (ScriptID 32) gCurRoom 37) ; project
			)
			(86 ; flameDartSpell
				(gCurRoom setScript: (ScriptID 32) gCurRoom 86) ; project
			)
			(88 ; forceBoltSpell
				(gCurRoom setScript: (ScriptID 32) gCurRoom 88) ; project
			)
			(93 ; lightningBallSpell
				(gCurRoom setScript: (ScriptID 32) gCurRoom 93) ; project
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(local1 dispose:)
		(super dispose: &rest)
	)
)

(instance sBlackOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: nec1)
					(cond
						((not (nec1 mover:))
							(if (> (gEgo distanceTo: nec1) 25)
								(nec1 setMotion: PChase gEgo 25 nec1)
							else
								(nec1 cue:)
							)
						)
						(((nec1 mover:) isMemberOf: PChase)
							((nec1 mover:) caller: nec1)
						)
					)
				else
					(++ state)
				)
				(if (gCast contains: nec2)
					(cond
						((not (nec2 mover:))
							(if (> (gEgo distanceTo: nec2) 25)
								(nec2 setMotion: PChase gEgo 25 nec2)
							else
								(nec2 cue:)
							)
						)
						(((nec2 mover:) isMemberOf: PChase)
							((nec2 mover:) caller: nec2)
						)
					)
				else
					(++ state)
				)
				(if (gCast contains: nec3)
					(cond
						((not (nec3 mover:))
							(if (> (gEgo distanceTo: nec3) 25)
								(nec3 setMotion: PChase gEgo 25 nec3)
							else
								(nec3 cue:)
							)
						)
						(((nec3 mover:) isMemberOf: PChase)
							((nec3 mover:) caller: nec3)
						)
					)
				else
					(++ state)
				)
				(gEgo
					setMotion: 0
					view: 43
					setLoop: -1
					setLoop: (if (< (gEgo heading:) 180) 0 else 1)
					setCel: 0
					setCycle: End
				)
				(self cue:)
			)
			(1 0)
			(2
				(if (not (gCast contains: nec2))
					(= ticks 1)
				)
			)
			(3
				(SetFlag 36)
				(gCast eachElementDo: #hide)
				(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
				((ScriptID 0 21) doit: 100) ; statusCode
				(gLongSong fade:)
				(= cycles 300)
			)
			(4
				(gEgo changeGait: 0) ; walking
				(gCurRoom newRoom: 670)
			)
		)
	)
)

(instance nec1 of Actor
	(properties
		noun 3
		modNum 51
		view 870
		cel 3
		signal 24577
	)

	(method (init)
		(self setStep: 7 4 setLooper: Grooper setCycle: Walk setScaler: gEgo)
		(super init: &rest)
	)

	(method (cue)
		(if approachDist
			(sBlackOut cue:)
		else
			(self
				setCel: 0
				setCycle: CT 3 1
				approachDist: 1
				setMotion: JumpTo (gEgo x:) (gEgo y:) self
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (and (not local0) (< (self distanceTo: gEgo) 30))
			(= local0 1)
			(gGlory handsOff:)
			(gEgo setMotion: 0)
			(gCurRoom notify: 1)
		)
		(= temp0 (local1 at: (/ (- (gCurRoom picture:) 400) 10)))
		(cond
			((and (< y temp0) (< z 1000))
				(+= z 1000)
			)
			((and (> y temp0) (>= z 1000))
				(-= z 1000)
			)
		)
	)

	(method (doVerb theVerb)
		(if
			(OneOf
				theVerb
				36 ; theSword
				20 ; ???
				21 ; theRocks
				85 ; calmSpell
				83 ; dazzleSpell
				81 ; detectMagicSpell
				87 ; fetchSpell
				86 ; flameDartSpell
				88 ; forceBoltSpell
				79 ; frostSpell
				102 ; healingSpell
				91 ; jugglingLightsSpell
				89 ; levitateSpell
				93 ; lightningBallSpell
				80 ; openSpell
				90 ; reversalSpell
				94 ; ritualSpell
				92 ; summonStaffSpell
				82 ; triggerSpell
				84 ; zapSpell
				95 ; invisibleSpell
				96 ; auraSpell
				97 ; protectionSpell
				98 ; resistanceSpell
				11 ; glideSpell
			)
			(theHunt doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance nec2 of Actor
	(properties
		noun 3
		modNum 51
		view 870
		cel 3
		signal 24577
	)

	(method (init)
		(self setStep: 7 4 setLooper: Grooper setCycle: Walk setScaler: gEgo)
		(super init: &rest)
	)

	(method (cue)
		(if approachDist
			(sBlackOut cue:)
		else
			(self
				setCel: 0
				setCycle: CT 3 1
				approachDist: 1
				setMotion: JumpTo (gEgo x:) (gEgo y:) self
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (and (not local0) (< (self distanceTo: gEgo) 30))
			(= local0 1)
			(gGlory handsOff:)
			(gEgo setMotion: 0)
			(gCurRoom notify: 1)
		)
		(= temp0 (local1 at: (/ (- (gCurRoom picture:) 400) 10)))
		(cond
			((and (< y temp0) (< z 1000))
				(+= z 1000)
			)
			((and (> y temp0) (>= z 1000))
				(-= z 1000)
			)
		)
	)

	(method (doVerb theVerb)
		(if
			(OneOf
				theVerb
				36 ; theSword
				20 ; ???
				21 ; theRocks
				85 ; calmSpell
				83 ; dazzleSpell
				81 ; detectMagicSpell
				87 ; fetchSpell
				86 ; flameDartSpell
				88 ; forceBoltSpell
				79 ; frostSpell
				102 ; healingSpell
				91 ; jugglingLightsSpell
				89 ; levitateSpell
				93 ; lightningBallSpell
				80 ; openSpell
				90 ; reversalSpell
				94 ; ritualSpell
				92 ; summonStaffSpell
				82 ; triggerSpell
				84 ; zapSpell
				95 ; invisibleSpell
				96 ; auraSpell
				97 ; protectionSpell
				98 ; resistanceSpell
				11 ; glideSpell
			)
			(theHunt doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance nec3 of Actor
	(properties
		noun 3
		modNum 51
		view 870
		cel 3
		signal 24577
	)

	(method (init)
		(self setStep: 7 4 setLooper: Grooper setCycle: Walk setScaler: gEgo)
		(super init: &rest)
	)

	(method (cue)
		(if approachDist
			(sBlackOut cue:)
		else
			(self
				setCel: 0
				setCycle: CT 3 1
				approachDist: 1
				setMotion: JumpTo (gEgo x:) (gEgo y:) self
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (and (not local0) (< (self distanceTo: gEgo) 30))
			(= local0 1)
			(gGlory handsOff:)
			(gEgo setMotion: 0)
			(gCurRoom notify: 1)
		)
		(= temp0 (local1 at: (/ (- (gCurRoom picture:) 400) 10)))
		(cond
			((and (< y temp0) (< z 1000))
				(+= z 1000)
			)
			((and (> y temp0) (>= z 1000))
				(-= z 1000)
			)
		)
	)

	(method (doVerb theVerb)
		(if
			(OneOf
				theVerb
				36 ; theSword
				20 ; ???
				21 ; theRocks
				85 ; calmSpell
				83 ; dazzleSpell
				81 ; detectMagicSpell
				87 ; fetchSpell
				86 ; flameDartSpell
				88 ; forceBoltSpell
				79 ; frostSpell
				102 ; healingSpell
				91 ; jugglingLightsSpell
				89 ; levitateSpell
				93 ; lightningBallSpell
				80 ; openSpell
				90 ; reversalSpell
				94 ; ritualSpell
				92 ; summonStaffSpell
				82 ; triggerSpell
				84 ; zapSpell
				95 ; invisibleSpell
				96 ; auraSpell
				97 ; protectionSpell
				98 ; resistanceSpell
				11 ; glideSpell
			)
			(theHunt doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

