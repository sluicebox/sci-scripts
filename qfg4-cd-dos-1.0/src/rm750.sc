;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 750)
(include sci.sh)
(use Main)
(use GloryRm)
(use DeathIcon)
(use Array)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm750 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
)

(procedure (localproc_0 param1)
	(switch param1
		(0
			(blob1 setCycle: 0)
			(blob2 setCycle: 0)
			(tent1 setLoop: 2 setCycle: 0)
			(tent2 setLoop: 7 setCycle: 0)
			(tent3 setLoop: 10 setCycle: 0)
			(tent4 setLoop: 4 setCycle: 0)
			(tent5 setLoop: 8 setCycle: 0)
		)
		(1
			(notes number: 1005 play:)
			(blob1 setLoop: 1 setCycle: Fwd)
			(blob2 setLoop: 6 setCycle: Fwd)
			(tent1 setLoop: 4 setCycle: Fwd)
			(tent2 setLoop: 9 setCycle: Fwd)
			(tent3 setLoop: 12 setCycle: Fwd)
			(tent4 setLoop: 7 setCycle: Fwd)
			(tent5 setLoop: 11 setCycle: Fwd)
		)
		(2
			(notes number: 1006 play:)
			(blob1 setLoop: 0 setCycle: Fwd)
			(blob2 setLoop: 5 setCycle: Fwd)
			(tent1 setLoop: 3 setCycle: Fwd)
			(tent2 setLoop: 8 setCycle: Fwd)
			(tent3 setLoop: 11 setCycle: Fwd)
			(tent4 setLoop: 5 setCycle: Fwd)
			(tent5 setLoop: 9 setCycle: Fwd)
		)
	)
)

(procedure (localproc_1)
	(cond
		((and (== local2 0) (== (sBlowTent register:) lRTent))
			(notes number: 988 client: self play:)
			(++ local2)
			(return 1)
		)
		((and (== local2 1) (== (sBlowTent register:) lLTent))
			(notes number: 989 client: self play:)
			(++ local2)
			(return 1)
		)
		((and (== local2 2) (== (sBlowTent register:) lMidTent))
			(notes number: 990 client: self play:)
			(++ local2)
			(return 1)
		)
		((and (== local2 3) (== (sBlowTent register:) uMidTent))
			(notes number: 991 client: self play:)
			(++ local2)
			(return 1)
		)
		((== local2 4)
			(return 1)
		)
		(else
			(= local2 0)
			(return 0)
		)
	)
)

(instance rm750 of GloryRm
	(properties
		noun 1
		picture 750
	)

	(method (init)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 285 59 319 59 319 189 0 189 0 0 319 0 319 56 278 56 282 67 254 77 309 90 309 100 287 112 231 116 266 125 260 137 191 148 127 148 98 132 108 126 88 121 99 113 146 113 158 125 122 125 122 136 145 144 183 144 226 137 214 127 214 113 195 105 242 96 249 70 234 70 214 90 166 90 155 77 174 68 152 67 146 84 173 109 124 109 96 109 76 116 63 109 63 93 102 93 102 90 63 90 63 76 118 76 118 68 141 68 113 62 81 70 22 70 7 78 47 96 60 115 120 153 91 153 133 173 193 173 283 157 316 102 316 78 308 78 308 64 286 64
					yourself:
				)
		)
		(SetFlag 373)
		(gEgo
			init:
			x: 300
			y: 57
			setScaler: Scaler 70 30 75 59
			normalize:
			changeGait:
		)
		(torchEff init: setScaler: gEgo setCycle: RandCycle)
		(notes init:)
		(hole init:)
		(blob1 init:)
		(blob2 init:)
		(tent1 init:)
		(tent2 init:)
		(tent3 init:)
		(tent4 init:)
		(tent5 init:)
		(lRTent approachVerbs: 4 70 init:) ; Do, theBreathRit
		(uLTent approachVerbs: 4 70 init:) ; Do, theBreathRit
		(lLTent approachVerbs: 4 70 init:) ; Do, theBreathRit
		(uRTent approachVerbs: 4 70 init:) ; Do, theBreathRit
		(uMidTent approachVerbs: 4 70 init:) ; Do, theBreathRit
		(lMidTent approachVerbs: 4 70 init:) ; Do, theBreathRit
		(altar approachVerbs: 4 70 init:) ; Do, theBreathRit
		(headRock init:)
		(sphincter init:)
		(theExit init: approachVerbs: 4) ; Do
		(bubbleHead init:)
		(midBubble init:)
		(foreBubbles init:)
		(moreBubbles init:)
		(gCurRoom setScript: sEnter)
		(gGlory save: 1)
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			(self doVerb: (event message:))
			(event claimed: 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			(
				(gEgo
					inRect:
						(theExit nsLeft:)
						(theExit nsTop:)
						(theExit nsRight:)
						(theExit nsBottom:)
				)
				(gCurRoom setScript: sExit)
			)
		)
	)

	(method (notify param1 &tmp temp0)
		(switch param1
			(85
				(= temp0 25)
				(if (== (gCurRoom script:) sSuckEgo)
					(soundFX number: 936 play:)
					(gMessager say: 11 6 11) ; "The wind seems to have stopped momentarily. You have a few seconds in which to try to escape."
					(= local10 1)
				else
					(gCurRoom setScript: sPlaySpellSound 0 936)
				)
			)
			(83
				(= temp0 23)
				(gCurRoom setScript: sPlaySpellSound 0 940)
			)
			(81
				(= temp0 21)
				(gCurRoom setScript: sPlaySpellSound 0 942)
			)
			(86
				(= temp0 26)
				(gCurRoom setScript: sPlaySpellSound 0 933)
			)
			(88
				(= temp0 28)
				(gCurRoom setScript: sPlaySpellSound 0 938)
			)
			(79
				(= temp0 34)
				(gCurRoom setScript: sPlaySpellSound 0 983)
			)
			(95
				(= temp0 36)
				(gCurRoom setScript: sPlaySpellSound 0 934)
			)
			(91
				(= temp0 31)
				(gCurRoom setScript: sPlaySpellSound 0 944)
			)
			(89
				(= temp0 29)
				(gCurRoom setScript: sPlaySpellSound 0 941)
			)
			(93
				(= temp0 33)
				(gCurRoom setScript: sPlaySpellSound 0 974)
			)
			(80
				(= temp0 20)
				(if (== (gCurRoom script:) sSuckEgo)
					(if local10
						(soundFX number: 934 play:)
						(gEgo setScript: sStopBreathing)
					else
						(gMessager say: 11 6 10) ; "The "breaths" are coming too quickly for that to help. You'll need some relaxation in here to give you, well, a breathing space."
					)
				else
					(gCurRoom setScript: sPlaySpellSound 0 934)
				)
			)
			(98
				(= temp0 39)
				(gCurRoom setScript: sPlaySpellSound 0 934)
			)
			(90
				(= temp0 30)
				(gCurRoom setScript: sPlaySpellSound 0 937)
			)
			(84
				(= temp0 24)
				(gCurRoom setScript: sPlaySpellSound 0 932)
			)
			(94
				(= temp0 35)
				(gCurRoom setScript: sPlaySpellSound 0 943)
			)
			(87
				(= temp0 27)
				(gCurRoom setScript: sPlaySpellSound 0 934)
			)
			(82
				(= temp0 22)
				(gCurRoom setScript: sPlaySpellSound 0 934)
			)
			(92
				(= temp0 32)
				(gCurRoom setScript: sPlaySpellSound 0 934)
			)
			(97
				(= temp0 38)
				(gCurRoom setScript: sPlaySpellSound 0 934)
			)
			(96
				(= temp0 37)
				(gCurRoom setScript: sPlaySpellSound 0 934)
			)
			(11
				(= temp0 40)
				(gCurRoom setScript: sPlaySpellSound 0 934)
			)
			(102
				(= temp0 41)
				(gCurRoom setScript: sPlaySpellSound 0 934)
			)
		)
		(gEgo castSpell: temp0)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local3
					(gMessager say: noun theVerb 2 0) ; "Dust swirls through the chamber as the giant "lung" blows its powerful wind through the cave."
				else
					(gMessager say: noun theVerb 1 0) ; "The stone has formed into a number of strange globes in this part of the cave. A stone image of a huge, unearthly creature with tentacles has been carved out of the rock on the left side."
				)
				(return 1)
			)
			(4 ; Do
				(if
					(or
						local9
						(and
							(== gHeroType 2) ; Thief
							(IsFlag 356)
							(== (sSuckEgo state:) 3)
						)
					)
					(= local7 ((User curEvent:) x:))
					(= local8 ((User curEvent:) y:))
					(gCurRoom setScript: sMoveEgo)
					(sBreath start: 5)
					(hole setScript: sBreath)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sPlaySpellSound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(soundFX number: register play:)
				(= seconds 2)
			)
			(1
				(gMessager say: 11 6 9 0 self) ; "Your spell has no effect."
			)
			(2
				(gGlory handsOn:)
				(if (IsFlag 356)
					(gTheIconBar disable: 0 4 7 6)
				)
				(self dispose:)
			)
		)
	)
)

(instance sStopBreathing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(sSuckEgo dispose:)
				(= local11 gEgoGait)
				(gEgo
					normalize:
					setPri: 0
					setScaler: Scaler 70 40 62 55
					changeGait: 1 ; running
					cycleSpeed: (gEgo moveSpeed:)
					x: 156
					y: 55
				)
				(torchEff setScaler: gEgo)
				(localproc_0 0)
				(hole signal: (| (hole signal:) $0001) setCycle: End self)
			)
			(1
				(hole signal: (& (hole signal:) $fffe))
				(gEgo setPri: -1 setMotion: MoveTo 156 80 self)
			)
			(2
				(gEgo
					setScaler: Scaler 100 70 153 62
					setMotion: PolyPath 274 154 self
				)
				(torchEff show: setScaler: gEgo)
			)
			(3
				(gEgo changeGait: local11)
				(hole setScript: sBreath)
				(ClearFlag 356)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoKnockDn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo view: 6 setLoop: 1 setCel: 0 setCycle: End self)
				(torchEff hide:)
			)
			(1
				(= ticks 36)
			)
			(2
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(3
				(torchEff show:)
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoKnockDead of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo view: 6 setLoop: 1 setCel: 0 setCycle: End)
				(lgRock signal: (| (lgRock signal:) $0001))
				(medRock signal: (| (medRock signal:) $0001))
				(smRock signal: (| (smRock signal:) $0001))
				(torchEff dispose:)
				(= local1 (IntArray new: 11))
				(local1
					at:
						0
						((lgRock new:)
							setStep: 1 12
							setCycle: Fwd
							setMotion: MoveTo (Random 50 65) 72 self
							init:
							yourself:
						)
				)
				(local1
					at:
						1
						((medRock new:)
							setStep: 1 12
							setCycle: Fwd
							setMotion: MoveTo (Random 55 70) 70
							init:
							yourself:
						)
				)
				(local1
					at:
						2
						((lgRock new:)
							setStep: 1 12
							setLoop: 1
							setCycle: Fwd
							setMotion: MoveTo (Random 65 80) 69
							init:
							yourself:
						)
				)
				(local1
					at:
						3
						((medRock new:)
							setStep: 1 12
							setLoop: 3
							setCycle: Fwd
							setMotion: MoveTo (Random 60 70) (Random 65 68)
							init:
							yourself:
						)
				)
				(local1
					at:
						4
						((smRock new:)
							setStep: 1 12
							setCycle: Fwd
							setMotion: MoveTo (Random 65 80) 65
							init:
							yourself:
						)
				)
				(local1
					at:
						5
						((medRock new:)
							setStep: 1 12
							setLoop: 4
							setCycle: Fwd
							setMotion: MoveTo (Random 50 60) 74
							init:
							yourself:
						)
				)
				(local1
					at:
						6
						((smRock new:)
							setStep: 1 12
							setLoop: 8
							setCycle: Fwd
							setMotion: MoveTo (Random 45 50) 75
							init:
							yourself:
						)
				)
				(local1
					at:
						7
						((medRock new:)
							setStep: 1 12
							setLoop: 5
							setCycle: Fwd
							setMotion: MoveTo 83 70
							init:
							yourself:
						)
				)
				(local1
					at:
						8
						((smRock new:)
							setStep: 1 12
							setLoop: 9
							setCycle: Fwd
							setMotion: MoveTo 82 74
							init:
							yourself:
						)
				)
				(local1
					at:
						9
						((smRock new:)
							setStep: 1 12
							setLoop: 9
							setCycle: Fwd
							setMotion: MoveTo 82 73
							init:
							yourself:
						)
				)
				(local1
					at:
						10
						((smRock new:)
							setStep: 1 12
							setLoop: 10
							setCycle: Fwd
							setMotion: MoveTo (Random 85 89) 76
							init:
							yourself:
						)
				)
			)
			(1
				(for ((= temp0 0)) (< temp0 11) ((++ temp0))
					((local1 at: temp0) setCycle: 0)
				)
				(= cycles 12)
			)
			(2
				(local1 dispose:)
				(EgoDead 5 0 971 1 912)
			)
		)
	)
)

(instance sBlowTent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (== register uMidTent)
					(gEgo view: 31 loop: 1 cel: 0 setCycle: End self)
				else
					(gEgo view: 4 loop: 1 cel: 0 setCycle: CT 2 1 self)
				)
			)
			(1
				(gMessager say: 11 6 3 0 self) ; "You take a deep breath, then blow hard into the hollow tentacle."
			)
			(2
				(notes number: 997 client: self play:)
				(= ticks 180)
			)
			(3
				(cond
					((== register uMidTent)
						(if (localproc_1)
							(= local3 1)
							(gEgo drop: 54 1 solvePuzzle: 457 6) ; theBreathRit
							(gLongSong mute: 0 6 mute: 0 8)
							(SetFlag 327)
							(hole setScript: sBreath)
							(= cycles 3)
						else
							(switch local0
								(0
									(ShakeScreen 2 ssUPDOWN)
									(ShakeScreen 2 ssLEFTRIGHT)
									(++ local0)
									(notes number: 992 play:)
									(gCurRoom setScript: sEgoKnockDn self)
								)
								(1
									(ShakeScreen 2 ssUPDOWN)
									(ShakeScreen 3 ssLEFTRIGHT)
									(ShakeScreen 3 ssUPDOWN)
									(ShakeScreen 2 ssLEFTRIGHT)
									(++ local0)
									(notes number: 992 play:)
									(gCurRoom setScript: sEgoKnockDn self)
								)
								(2
									(ShakeScreen 2 ssUPDOWN)
									(ShakeScreen 3 ssLEFTRIGHT)
									(ShakeScreen 4 ssUPDOWN)
									(ShakeScreen 5 ssLEFTRIGHT)
									(notes number: 993 play:)
									(gCurRoom setScript: sEgoKnockDead)
								)
							)
						)
					)
					((localproc_1)
						(= ticks 120)
					)
					(else
						(notes number: 994 play:)
						(= ticks 120)
					)
				)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 1)
			)
			(1
				(RemapColors 2 254 60) ; ByPercent
				(RemapColors 1 253 112 175 62) ; ByRange
				(gEgo setMotion: PolyPath 288 77 self)
			)
			(2
				(gEgo setScaler: Scaler 100 70 153 62)
				(torchEff setScaler: gEgo)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (IsFlag 327)
					(gEgo solvePuzzle: 458 15)
				)
				(gEgo
					setScaler: Scaler 70 30 75 59
					setMotion: PolyPath 287 57 self
				)
				(torchEff setScaler: gEgo)
			)
			(1
				(gCurRoom newRoom: 720)
			)
		)
	)
)

(instance sBreath of Script
	(properties)

	(method (init)
		(hole signal: (| (hole signal:) $0001))
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (IsFlag 356))
				(>= (gEgo x:) 145)
				(<= (gEgo x:) 175)
			)
			(gCurRoom setScript: sSuckEgo)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hole setCycle: End self)
			)
			(1
				(localproc_0 2)
				(= ticks 300)
			)
			(2
				(tent4 setCycle: End self)
				(tent5 setCycle: End)
			)
			(3
				(tent4 setLoop: 4 cel: 0 setCycle: End self)
				(tent5 setLoop: 8 cel: 0 setCycle: End)
			)
			(4
				(localproc_0 1)
				(= ticks 300)
			)
			(5
				(hole setCycle: Beg self)
			)
			(6
				(localproc_0 0)
				(= ticks 120)
			)
			(7
				(tent4 setCycle: End self)
				(tent5 setCycle: End)
			)
			(8
				(tent4 setLoop: 6 cel: 0 setCycle: End self)
				(tent5 setLoop: 10 cel: 0 setCycle: End)
			)
			(9
				(self changeState: 0)
			)
		)
	)
)

(instance sSuckEgo of Script
	(properties)

	(method (init)
		(if (gEgo looper:)
			((gEgo looper:) dispose:)
		)
		(gEgo
			view: 751
			z: 15
			setLoop: 0 1
			cel: 0
			setCycle: Fwd
			cycleSpeed: global433
			setMotion: 0
			setStep: 2 3
			setScaler: Scaler 160 39 151 71
		)
		(torchEff hide:)
		(SetFlag 356)
		(if (OneOf (sBreath state:) 1 2)
			(self start: 1)
		)
		(if (== (sBreath state:) 3)
			(self start: 3)
		)
		(if (== (sBreath state:) 4)
			(self start: 4)
		)
		(hole setScript: 0)
		(gTheIconBar disable: 0 4 5 7 6)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable: 0 4 5 7 6)
				(hole setCycle: End self)
			)
			(1
				(localproc_0 2)
				(switch local5
					(1
						(sBreath start: 1)
						(hole setScript: sBreath)
						(gCurRoom setScript: sThrowEgoRight)
					)
					(2
						(sBreath start: 1)
						(hole setScript: sBreath)
						(gCurRoom setScript: sThrowEgoLeft)
					)
					(else
						(gEgo
							setPri: -1
							setLoop: 0 1
							setMotion: MoveTo 152 125 self
						)
					)
				)
			)
			(2
				(gEgo
					setPri: 190
					setLoop: 1 1
					posn: 152 125
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(if (not (gEgo takeDamage: 10))
					(EgoDead 13) ; "Your social life has gone rather flat. That wall is HARDly a place to keep banging your head."
				)
				(if (== gHeroType 2) ; Thief
					(= ticks 180)
				else
					(= ticks 1)
				)
			)
			(4
				(localproc_0 1)
				(switch local5
					(1
						(sBreath start: 5)
						(hole setScript: sBreath)
						(gCurRoom setScript: sThrowEgoRight)
					)
					(2
						(sBreath start: 5)
						(hole setScript: sBreath)
						(gCurRoom setScript: sThrowEgoLeft)
					)
					(else
						(gEgo
							setPri: -1
							setScaler: Scaler 174 39 131 71
							setLoop: 0 1
							setCycle: Fwd
							setMotion: MoveTo 156 65 self
						)
						(torchEff setScaler: gEgo)
					)
				)
			)
			(5
				(gEgo posn: 156 65 setPri: 0)
				(hole setCycle: Beg self)
			)
			(6
				(if (== gHeroType 1) ; Magic User
					(gTheIconBar enable: 5)
					(= ticks 180)
				else
					(= ticks 1)
				)
			)
			(7
				(if local10
					(= ticks 300)
				else
					(= ticks 1)
				)
			)
			(8
				(self changeState: 0)
			)
		)
	)
)

(instance sEgoSuckedOut1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(notes number: 997 client: self play:)
				(= ticks 180)
			)
			(1
				(uLTent
					signal: (| (uLTent signal:) $0001)
					view: 754
					loop: 3
					cel: 0
				)
				(= cycles 12)
			)
			(2
				(uLTent setCycle: End self)
				(gEgo hide:)
				(torchEff hide:)
			)
			(3
				(EgoDead 4) ; "Do you suppose that you created a vacuum inside the tentacle by blowing so hard? Or was it just hungry? Whatever the reason, explosive decompression has set in."
			)
		)
	)
)

(instance sMoveEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> local7 180)
					(= local7 200)
				)
				(if (< local7 140)
					(= local7 140)
				)
				(gEgo
					setLoop: 2
					setScale:
					setPri: 200
					setCycle: Fwd
					setMotion: MoveTo local7 local8 self
				)
			)
			(1
				(if (or (== (gEgo x:) 140) (== (gEgo x:) 200))
					(= local9 0)
					(gCurRoom setScript: sRestoreEgo)
				else
					(gEgo setCycle: 0)
					(= local9 1)
					(self dispose:)
				)
			)
		)
	)
)

(instance sRestoreEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setStep: 2 6 setMotion: MoveTo (gEgo x:) 260 self)
			)
			(1
				(gEgo
					normalize:
					setPri: 170
					setScaler: Scaler 100 70 153 62
					setMotion: MoveTo (gEgo x:) 170 self
				)
				(torchEff show: setPri: 170 setScaler: gEgo)
			)
			(2
				(gEgo cycleSpeed: (gEgo moveSpeed:) setPri: -1)
				(torchEff setPri: -1)
				(ClearFlag 356)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowEgoRight of Script
	(properties)

	(method (init)
		(= local6 0)
		(super init: &rest)
	)

	(method (doit)
		(if
			(and
				(not local6)
				(== (self state:) 1)
				(or (== (sBreath state:) 0) (== (sBreath state:) 6))
			)
			(= local6 1)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: 0
					setCycle: Fwd
					setPri: -1
					setMotion: MoveTo (gEgo x:) 83 self
				)
			)
			(1
				(tent5 hide:)
				(gEgo
					view: 751
					x: (+ (gEgo x:) 5)
					setLoop: 4
					setCycle: Fwd
				)
			)
			(2
				(tent5 show:)
				(gEgo
					setLoop: 5
					setScaler: Scaler 100 70 153 62
					setStep: 15 15
					setPri:
					setMotion: MoveTo 330 180 self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(gEgo
					normalize:
					posn: 320 170
					setScaler: Scaler 100 70 153 62
					cycleSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 274 154 self
				)
				(torchEff show: setScaler: gEgo)
			)
			(5
				(ClearFlag 356)
				(gGlory handsOn:)
				(= local5 0)
				(self dispose:)
			)
		)
	)
)

(instance sThrowEgoLeft of Script
	(properties)

	(method (init)
		(= local6 0)
		(super init: &rest)
	)

	(method (doit)
		(if
			(and
				(not local6)
				(== (self state:) 1)
				(or (== (sBreath state:) 0) (== (sBreath state:) 6))
			)
			(= local6 1)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setPri: -1
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo (+ 10 (gEgo x:)) 92 self
				)
			)
			(1
				(tent4 hide:)
				(gEgo
					view: 751
					x: (+ (gEgo x:) 5)
					y: (gEgo y:)
					setLoop: 3
					setCycle: Fwd
				)
			)
			(2
				(tent4 show:)
				(gEgo
					setLoop: 5
					setCycle: Rev
					setScaler: Scaler 100 70 153 62
					setStep: 15 15
					setPri:
					setMotion: MoveTo 10 160 self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(gEgo
					normalize:
					setScaler: Scaler 100 70 153 62
					cycleSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 39 90 self
				)
				(torchEff show: setScaler: gEgo)
			)
			(5
				(ClearFlag 356)
				(gGlory handsOn:)
				(= local5 0)
				(self dispose:)
			)
		)
	)
)

(instance sEgoSuckedOut2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(notes number: 997 client: self play:)
				(= ticks 180)
			)
			(1
				(uRTent
					signal: (| (uRTent signal:) $0001)
					view: 754
					loop: 1
					cel: 0
				)
				(= cycles 12)
			)
			(2
				(uRTent setCycle: End self)
				(gEgo hide:)
				(torchEff hide:)
			)
			(3
				(EgoDead 4) ; "Do you suppose that you created a vacuum inside the tentacle by blowing so hard? Or was it just hungry? Whatever the reason, explosive decompression has set in."
			)
		)
	)
)

(instance lgRock of Actor
	(properties
		x 75
		priority 108
		fixPriority 1
		view 757
		signal 24576
	)

	(method (setHeading param1)
		(return param1)
	)
)

(instance medRock of Actor
	(properties
		x 70
		priority 108
		fixPriority 1
		view 757
		loop 2
		signal 24576
	)

	(method (setHeading param1)
		(return param1)
	)
)

(instance smRock of Actor
	(properties
		x 70
		priority 108
		fixPriority 1
		view 757
		loop 7
		signal 24576
	)

	(method (setHeading param1)
		(return param1)
	)
)

(instance torchEff of Prop
	(properties
		view 775
	)

	(method (doit)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(= z (+ (gEgo z:) 1))
		(super doit: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance hole of Prop
	(properties
		x 154
		y 43
		view 750
		signal 24576
	)
)

(instance blob1 of Prop
	(properties
		x 136
		y 15
		priority 86
		fixPriority 1
		view 756
		signal 16384
		detailLevel 3
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance tent1 of Prop
	(properties
		x 302
		y 142
		priority 199
		fixPriority 1
		view 756
		loop 2
		signal 16384
		detailLevel 3
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance blob2 of Prop
	(properties
		x 234
		y 172
		priority 199
		fixPriority 1
		view 756
		loop 5
		signal 16384
		detailLevel 3
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance tent2 of Prop
	(properties
		x 218
		y 177
		priority 199
		fixPriority 1
		view 756
		loop 2
		signal 16384
		detailLevel 3
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance tent3 of Prop
	(properties
		x 112
		y 188
		priority 199
		fixPriority 1
		view 756
		loop 10
		signal 16384
		detailLevel 3
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance tent4 of Prop
	(properties
		x 134
		y 101
		view 750
		loop 4
		signal 16385
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			(self doVerb: (event message:))
			(event claimed: 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 356)
					(cond
						((or (== gHeroType 2) (== gHeroType 1)) ; Thief, Magic User
							(gMessager say: 11 6 6) ; "You're not strong enough to hold onto a tentacle against that force of wind. You'll have to find a different way out of here."
						)
						((<= (gEgo y:) 85)
							(gMessager say: 12 4 7) ; "You grab for the tendril and miss. Wait! Maybe you can get it on the return breath!"
							(return 1)
						)
						(else
							(gGlory handsOff:)
							(= local5 2)
							(return 1)
						)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tent5 of Prop
	(properties
		x 178
		y 86
		view 750
		loop 8
		signal 16385
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			(self doVerb: (event message:))
			(event claimed: 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 356)
					(cond
						((or (== gHeroType 2) (== gHeroType 1)) ; Thief, Magic User
							(gMessager say: 11 6 6) ; "You're not strong enough to hold onto a tentacle against that force of wind. You'll have to find a different way out of here."
						)
						((<= (gEgo y:) 75)
							(gMessager say: 12 4 7) ; "You grab for the tendril and miss. Wait! Maybe you can get it on the return breath!"
							(return 1)
						)
						(else
							(gGlory handsOff:)
							(= local5 1)
							(return 1)
						)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance uLTent of Prop
	(properties
		noun 9
		approachX 69
		approachY 68
		x 49
		y 48
		priority 69
		fixPriority 1
		view 754
		loop 2
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if local4
					(self setScript: sEgoSuckedOut1)
				else
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 70 69 67 72 74) ; theBreathRit, theBloodRit, theBoneRit, theSenseRit, theHeartRit
				(altar doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance uRTent of Prop
	(properties
		noun 9
		approachX 104
		approachY 69
		x 79
		y 30
		priority 64
		view 754
		loop 1
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if local4
					(self setScript: sEgoSuckedOut2)
				else
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 70 69 67 72 74) ; theBreathRit, theBloodRit, theBoneRit, theSenseRit, theHeartRit
				(altar doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance uMidTent of Feature
	(properties
		noun 8
		nsLeft 65
		nsTop 17
		nsRight 94
		nsBottom 46
		sightAngle 40
		approachX 97
		approachY 68
		x 79
		y 31
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if local4
					(gEgo setScript: sBlowTent 0 self)
				else
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 70 69 67 72 74) ; theBreathRit, theBloodRit, theBoneRit, theSenseRit, theHeartRit
				(altar doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lLTent of Feature
	(properties
		noun 10
		nsLeft 59
		nsTop 49
		nsRight 84
		nsBottom 64
		sightAngle 40
		approachX 94
		approachY 67
		x 71
		y 56
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:) type: PBarredAccess init: 69 50 84 50 84 64 70 64 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if local4
					(gEgo setScript: sBlowTent 0 self)
				else
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 70 69 67 72 74) ; theBreathRit, theBloodRit, theBoneRit, theSenseRit, theHeartRit
				(altar doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lMidTent of Feature
	(properties
		noun 10
		nsLeft 86
		nsTop 49
		nsRight 99
		nsBottom 63
		sightAngle 40
		approachX 108
		approachY 67
		x 92
		y 56
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PBarredAccess
					init: 86 49 98 49 101 60 87 61
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if local4
					(gEgo setScript: sBlowTent 0 self)
				else
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 70 69 67 72 74) ; theBreathRit, theBloodRit, theBoneRit, theSenseRit, theHeartRit
				(altar doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lRTent of Feature
	(properties
		noun 10
		nsLeft 100
		nsTop 46
		nsRight 110
		nsBottom 57
		sightAngle 40
		approachX 121
		approachY 64
		x 105
		y 51
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PBarredAccess
					init: 102 57 98 44 112 44 112 57
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if local4
					(gEgo setScript: sBlowTent 0 self)
				else
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 70 69 67 72 74) ; theBreathRit, theBloodRit, theBoneRit, theSenseRit, theHeartRit
				(altar doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance altar of Feature
	(properties
		noun 2
		nsLeft 5
		nsTop 9
		nsRight 107
		nsBottom 67
		sightAngle 180
		approachX 56
		approachY 38
		x 56
		y 20
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; theBreathRit
				(gMessager say: 2 70 0) ; "You unroll the scroll containing the Breath Ritual. The words are visible at last and you begin to read the Ritual."
				(= local4 1)
			)
			(69 ; theBloodRit
				(gMessager say: 0 69 0) ; "This is not the proper place for that Ritual."
			)
			(67 ; theBoneRit
				(gMessager say: 0 67 0) ; "This is not the proper place for that Ritual."
			)
			(72 ; theSenseRit
				(gMessager say: 0 72 0) ; "This is not the proper place for that Ritual."
			)
			(74 ; theHeartRit
				(gMessager say: 0 74 0) ; "This is not the proper place for that Ritual."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance headRock of Feature
	(properties
		noun 3
		nsLeft 10
		nsTop 69
		nsRight 57
		nsBottom 100
		sightAngle 180
		x 33
		y 84
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance sphincter of Feature
	(properties
		noun 4
		nsLeft 136
		nsTop 26
		nsRight 172
		nsBottom 62
		sightAngle 180
		x 154
		y 44
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance theExit of Feature
	(properties
		noun 5
		nsLeft 274
		nsTop 42
		nsRight 297
		nsBottom 75
		sightAngle 90
		approachX 287
		approachY 65
		x 285
		y 52
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sExit)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bubbleHead of Feature
	(properties
		noun 6
		nsLeft 130
		nsTop -1
		nsRight 171
		nsBottom 26
		sightAngle 180
		x 150
		y 12
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance midBubble of Feature
	(properties
		noun 7
		nsLeft 192
		nsTop 115
		nsRight 205
		nsBottom 128
		sightAngle 180
		x 198
		y 121
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance foreBubbles of Feature
	(properties
		noun 7
		nsTop 134
		nsRight 319
		nsBottom 189
		sightAngle 180
		x 159
		y 161
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PBarredAccess
					init: 1 139 26 134 38 136 41 151 85 154 95 164 99 184 130 187 140 183 151 185 155 179 164 177 175 183 191 189 220 169 227 168 235 156 240 156 249 169 255 164 261 163 266 156 276 158 280 161 297 154 312 156 319 164 319 189 0 189
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance moreBubbles of Feature
	(properties
		noun 7
		nsLeft 227
		nsTop 12
		nsRight 274
		nsBottom 44
		sightAngle 180
		x 250
		y 28
	)

	(method (handleEvent event)
		(if (IsFlag 356)
			0
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance notes of Sound
	(properties)
)

(instance soundFX of Sound
	(properties)
)

