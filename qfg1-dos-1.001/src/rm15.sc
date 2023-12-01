;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use n104)
(use n809)
(use LoadMany)
(use Chase)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm15 0
	kobold 1
	body 2
	poof 3
	ball 4
	puff 5
	dart 6
	koboldKey 7
	chest 8
	keySparkle 9
	egoShoots 10
	koboldShoots 11
	magicHit 12
)

(local
	local0
	local1
	local2
	[local3 5]
	[local8 5]
	local13
)

(instance magicHit of Sound
	(properties
		number 45
		priority 1
	)
)

(instance egoShoots of Sound
	(properties
		number 33
		priority 2
	)
)

(instance koboldShoots of Sound
	(properties
		number 34
		priority 2
	)
)

(instance koboldKey of Act
	(properties
		view 178
		loop 6
	)

	(method (handleEvent event)
		(if (MouseClaimed self event 3)
			(proc809_2 event {look key})
		)
	)
)

(instance keySparkle of Prop
	(properties
		view 175
		loop 8
	)
)

(instance poof of Prop
	(properties
		z 25
		view 177
		loop 6
	)
)

(instance ball of Act
	(properties
		z 25
		view 177
		illegalBits 0
	)
)

(instance puff of Prop
	(properties
		z 25
		view 522
		loop 3
	)
)

(instance dart of Act
	(properties
		z 25
		view 522
		illegalBits 0
	)
)

(instance kobold of Act
	(properties
		view 175
		loop 6
	)

	(method (handleEvent event)
		(if (or (MouseClaimed self event 3) (MouseClaimed body event 3))
			(proc809_2 event {look kobold})
		)
	)

	(method (doit)
		(if (and (== global315 4) (ball script:))
			(ball dispose:)
		)
		(if (and (== global315 2) (not (rm15 script:)))
			(cond
				((> local0 0)
					(-- local0)
				)
				(
					(and
						(== local0 0)
						(not script)
						(not (IsFlag 314))
						(not (IsFlag 316))
						(or
							(not (gEgo script:))
							(and
								(IsFlag 315)
								(not ((gEgo script:) script:))
							)
						)
					)
					(= local0 (Random 30 60))
					(SetFlag 280)
				)
			)
		)
		(super doit:)
	)
)

(instance body of View
	(properties
		y 85
		x 229
		view 175
		loop 5
	)
)

(instance toadstools of PV
	(properties
		y 117
		x 213
		view 15
		loop 3
		priority 9
	)
)

(instance onToads of RFeature
	(properties
		nsTop 110
		nsLeft 200
		nsBottom 118
		nsRight 225
	)

	(method (handleEvent event)
		(if (MouseClaimed self event 3)
			(proc809_2 event {look toadstool})
		)
	)
)

(instance drip of Prop
	(properties
		y 204
		x 79
		view 15
	)
)

(instance chest of Prop
	(properties
		y 173
		x 132
		view 15
		loop 1
	)

	(method (handleEvent event)
		(if (MouseClaimed self event 3)
			(proc809_2 event {look chest})
		)
	)

	(method (doit)
		(if (< (gEgo distanceTo: (ScriptID 15 8)) 20) ; chest
			(if (and (== (gEgo illegalBits:) -32768) (<= global322 2))
				(gEgo illegalBits: -24576)
			)
			(if (and (== (gEgo illegalBits:) -16384) (<= global322 2))
				(gEgo illegalBits: -8192)
			)
			(if (not (IsFlag 166))
				(SetFlag 166)
				(gEgo setMotion: 0)
				(LowPrint 15 0) ; "You seem to have bumped into an unseen object on the cave floor."
				(LowPrint 15 1) ; "You examine it by touch. It feels like a wooden chest."
				(LowPrint 15 2) ; "It must have been made invisible by the Kobold."
			)
		)
		(super doit:)
	)
)

(instance rm15 of Rm
	(properties
		picture 15
		style 8
		west 14
	)

	(method (dispose)
		(= global332 0)
		(= global333 0)
		(if (== global315 4)
			(SetFlag 231)
		)
		(if (!= global319 4)
			(= global319 0)
		)
		(ClearFlag 216)
		(SetFlag 5)
		(gDirHandler delete: self)
		(super dispose:)
		(LoadMany
			0
			115
			116
			117
			118
			119
			120
			121
			122
			123
			124
			125
			809
			126
			127
			113
			128
			130
			114
			972
		)
	)

	(method (init)
		Chase
		(cond
			((gEgo has: 6) ; blade
				(Load rsVIEW 501)
			)
			((gEgo has: 7) ; dagger
				(Load rsVIEW 512 524)
			)
		)
		(if (gEgo knows: 24) ; fetchSpell
			(Load rsVIEW 520)
		)
		(if (or (gEgo knows: 17) (gEgo knows: 20)) ; openSpell, dazzleSpell
			(Load rsVIEW 521)
		)
		(if (or (gEgo knows: 17) (gEgo knows: 19) (CanPickLocks)) ; openSpell, triggerSpell
			(LoadMany rsSOUND (SoundFX 36) (SoundFX 62))
		)
		(if (gEgo knows: 23) ; flameDartSpell
			(Load rsVIEW 522)
			(Load rsVIEW 532)
			(Load rsSOUND (SoundFX 33))
			(egoShoots number: (SoundFX 33) init:)
		)
		(if (< global315 4)
			(LoadMany rsSOUND (SoundFX 34) (SoundFX 45))
		)
		(LoadMany rsVIEW 513 175 176 178 510 502)
		(LoadMany
			rsSCRIPT
			115
			116
			117
			118
			119
			120
			121
			122
			123
			124
			126
			127
			113
			128
			130
			125
			809
			114
		)
		(SolvePuzzle 648 2)
		(SL enable:)
		(super init:)
		(gDirHandler add: self)
		(= local13 (Random 0 4))
		(= [local3 0] 79)
		(= [local8 0] 204)
		(= [local3 1] 113)
		(= [local8 1] 189)
		(= [local3 2] 172)
		(= [local8 2] 193)
		(= [local3 3] 226)
		(= [local8 3] 191)
		(= [local3 4] 306)
		(= [local8 4] 203)
		(if (not (IsFlag 5))
			(= global343 67)
		)
		(= global344
			(-
				(/
					(+
						(* [gEgoStats 5] 8) ; weapon-use
						(* [gEgoStats 2] 4) ; agility
						(* [gEgoStats 0] 2) ; strength
						[gEgoStats 1] ; intelligence
						[gEgoStats 4] ; luck
					)
					16
				)
				30
			)
		)
		(= global345 (+ 9 (/ [gEgoStats 0] 10))) ; strength
		(if (gEgo has: 6) ; blade
			(+= global345 3)
		)
		(= global346 (/ [gEgoStats 23] 2)) ; flameDartSpell
		(NormalEgo)
		(gEgo posn: 1 63 init:)
		(gAddToPics add: toadstools eachElementDo: #init doit:)
		(self setFeatures: onToads)
		(ball
			setStep: 15 10
			setPri: 12
			setLoop: 5
			ignoreActors:
			init:
			hide:
			stopUpd:
		)
		(dart
			setStep: 15 10
			setPri: 12
			setLoop: 2
			ignoreActors:
			init:
			hide:
			stopUpd:
		)
		(koboldShoots number: (SoundFX 34) init:)
		(magicHit number: (SoundFX 45) init:)
		(drip init: setScript: dripScript)
		(if (== global322 3)
			(chest setLoop: 2 setCel: 8 setPri: 12 init: ignoreActors: stopUpd:)
		else
			(chest setPri: 12 cycleSpeed: 1 init: ignoreActors: stopUpd:)
		)
		(poof init:)
		(puff init:)
		(cond
			((== global315 2)
				(kobold
					setLoop: 0
					illegalBits: 0
					posn: 229 85
					setPri: 6
					cycleSpeed: 3
					setCycle: Fwd
					init:
					startUpd:
					setScript: 0
				)
				(gContMusic number: 23 loop: -1 play:)
				(= global332 1)
				(= global333 1)
			)
			((< global315 4)
				(body setPri: 6 init: stopUpd:)
				(kobold
					illegalBits: 0
					setPri: 6
					cycleSpeed: 1
					posn: 229 68
					init:
					stopUpd:
				)
				(keySparkle posn: (body x:) (- (body y:) 13) setPri: 7 init:)
				(= global332 1)
				(= global333 1)
			)
		)
		(if (== global321 1)
			(koboldKey
				illegalBits: 0
				setPri: 4
				setCel: 12
				posn:
					(if (IsFlag 149) 52 else 229)
					(if (IsFlag 149) 84 else 85)
				init:
				stopUpd:
			)
		)
		(if (== global321 0)
			(koboldKey setPri: 7 init: stopUpd:)
		)
		(self setScript: (ScriptID 125 0)) ; intro
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== (event type:) $0040) ; direction
				(proc809_0 event)
				(DisposeScript 809)
			)
			((== (event type:) evSAID)
				(proc809_1 event)
				(DisposeScript 809)
			)
		)
		(event claimed:)
	)

	(method (doit)
		(= local2 (GetAngle (kobold x:) (kobold y:) (gEgo x:) (gEgo y:)))
		(if (and (not (kobold script:)) (== global315 2))
			(cond
				((IsFlag 149)
					(cond
						((< local2 120)
							(kobold setLoop: 1)
						)
						((< local2 150)
							(kobold setLoop: 3)
						)
						(else
							(kobold setLoop: 4)
						)
					)
				)
				((> local2 240)
					(kobold setLoop: 0)
				)
				((> local2 210)
					(kobold setLoop: 2)
				)
				(else
					(kobold setLoop: 4)
				)
			)
		)
		(cond
			((IsFlag 344)
				(ClearFlag 344)
				(kobold
					view: 175
					cycleSpeed: 3
					setCycle: Fwd
					startUpd:
					setScript: 0
				)
			)
			((and (IsFlag 280) (not (IsFlag 350)))
				(ClearFlag 280)
				(kobold setScript: (ScriptID 115 0)) ; lightning
			)
			((IsFlag 281)
				(ClearFlag 281)
				(ball setScript: (ScriptID 116 0)) ; ricochet
			)
			((IsFlag 324)
				(ClearFlag 324)
				(gEgo setScript: (ScriptID 130 0)) ; throwDagger
			)
			((IsFlag 290)
				(ClearFlag 290)
				(gEgo setScript: (ScriptID 122 0)) ; strike
			)
			((IsFlag 288)
				(ClearFlag 288)
				(dart setScript: (ScriptID 120 1)) ; bounceBack
			)
			((IsFlag 287)
				(ClearFlag 287)
				(dart setScript: (ScriptID 120 0)) ; bouncer
			)
			((IsFlag 297)
				(ClearFlag 297)
				(kobold setScript: (ScriptID 125 3)) ; getUp
			)
			((IsFlag 282)
				(ClearFlag 282)
				(kobold setScript: (ScriptID 117 0)) ; dartHit
			)
			((IsFlag 308)
				(SetFlag 315)
				(ClearFlag 308)
				(gEgo setScript: (ScriptID 126 0)) ; egoFight
			)
			((and (IsFlag 294) (!= (kobold script:) (ScriptID 118 0))) ; reversal
				(ClearFlag 294)
				(kobold setScript: (ScriptID 123 1)) ; koboldDazzle
			)
			((IsFlag 311)
				(ClearFlag 311)
				(gEgo setScript: (ScriptID 121 1)) ; putWeaponAway
			)
			((IsFlag 283)
				(if (not (kobold script:))
					(ClearFlag 283)
					(kobold setScript: (ScriptID 117 1)) ; koboldDies
				)
			)
			((IsFlag 289)
				(ClearFlag 289)
				(gEgo setScript: (ScriptID 121 0)) ; drawWeapon
			)
			((IsFlag 284)
				(ClearFlag 284)
				(kobold setScript: (ScriptID 118 0)) ; reversal
			)
			((IsFlag 285)
				(ClearFlag 285)
				(kobold setScript: (ScriptID 118 1)) ; teleport
			)
			((IsFlag 296)
				(ClearFlag 296)
				((ScriptID 15 1) setScript: (ScriptID 125 1)) ; kobold, wakeUp
			)
			((IsFlag 291)
				(ClearFlag 291)
				(gEgo setScript: (ScriptID 129 0)) ; openSpell
			)
			((IsFlag 349)
				(ClearFlag 349)
				(CastCalm)
				(SetFlag 306)
			)
			((IsFlag 299)
				(ClearFlag 299)
				(self setScript: (ScriptID 125 4)) ; detector
			)
			((IsFlag 293)
				(ClearFlag 293)
				(gEgo setScript: (ScriptID 123 0)) ; caveDazzle
			)
			((IsFlag 286)
				(ClearFlag 286)
				(gEgo setScript: (ScriptID 119 0)) ; flameDart
			)
			((IsFlag 295)
				(ClearFlag 295)
				(gEgo setScript: (ScriptID 124 0)) ; egoFetch
			)
			((IsFlag 298)
				(ClearFlag 298)
				((ScriptID 15 1) setScript: (ScriptID 125 2)) ; kobold, getOut
			)
			((IsFlag 292)
				(ClearFlag 292)
				(gEgo setScript: (ScriptID 129 1)) ; unlockChest
			)
		)
		(if (and (== (gEgo onControl: 1) 16384) (not (IsFlag 148)))
			(SetFlag 148)
		)
		(if
			(and
				(not (ball mover:))
				(not (ball script:))
				(not (kobold script:))
			)
			(ball hide:)
		)
		(cond
			(
				(and
					(IsFlag 157)
					(== global315 2)
					(not (kobold script:))
					(not (IsFlag 284))
				)
				(ClearFlag 157)
				(SetFlag 280)
			)
			(
				(and
					(not (kobold script:))
					(not (gEgo script:))
					(== global315 3)
					(not local1)
				)
				(= local1 1)
				(SetFlag 280)
			)
		)
		(cond
			(
				(and
					(< global315 4)
					(or
						(== (gEgo illegalBits:) -32768)
						(== (gEgo illegalBits:) -24576)
					)
				)
				(gEgo illegalBits: -16384)
			)
			(
				(and
					(== global315 4)
					(or
						(== (gEgo illegalBits:) -16384)
						(== (gEgo illegalBits:) -8192)
					)
				)
				(gEgo illegalBits: -32768)
			)
		)
		(cond
			((< 0 global315 4)
				(if (drip script:)
					(drip setScript: 0)
				)
			)
			((and (or (== global315 0) (== global315 4)) (not (drip script:)))
				(drip setScript: dripScript)
			)
		)
		(super doit:)
	)
)

(instance dripScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(drip posn: [local3 local13] [local8 local13] setCycle: End)
				(= cycles (Random 20 40))
			)
			(1
				(= local13 (Random 0 4))
				(self changeState: 0)
			)
		)
	)
)

