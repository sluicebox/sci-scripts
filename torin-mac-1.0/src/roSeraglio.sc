;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20600)
(include sci.sh)
(use Main)
(use ScrollExit)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use CueMe)
(use n64896)
(use foEExit)
(use Plane)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roSeraglio 0
)

(local
	bBoogleAtBottom
	bTalking
	nNewStenchLoop = 2
	nGirlsFidgeting
)

(procedure (KillHaremTalk)
	(oHaremTalk stop:)
	(= bTalking 0)
	(soHaremGirlsChatter changeState: 1)
)

(procedure (KillHaremChatter)
	(oHaremTalk stop:)
	(oChatter stop:)
	(soHaremGirlsChatter dispose:)
	(= bTalking 0)
)

(procedure (StartHaremChatter)
	(poNull setScript: soHaremGirlsChatter)
)

(instance foToCliffExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 225 63 226 68 126 147 127 138 26 2 27
					yourself:
				)
		)
	)

	(method (doVerb)
		(if bBoogleAtBottom
			(gCurRoom setScript: soBoogleBackUpAndExit)
		else
			(gEgo setScript: soClimbOut)
		)
	)
)

(instance foExitCU of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom deleteRoomPlane: oSignCUPlane)
	)
)

(instance soClimbIn of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 20612)
				(poTorin
					view: 20600
					loop: 0
					cel: 0
					posn: 102 280
					init:
					setCycle: CT 4 1 self
				)
			)
			(1
				(goSound1 playSound: 20612)
				(poTorin setCycle: End self)
			)
			(2
				(poTorin dispose:)
				(gEgo posn: 102 280 normalize: 1 60100 4 show:)
				(gGame handsOn:)
			)
		)
	)
)

(instance soClimbOut of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 106 281 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 20614)
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 20617
					loop: 0
					cel: 0
					posn: 102 280
					init:
					setCycle: CT 16 1 self
				)
			)
			(3
				(goSound1 playSound: 20614)
				(poTorin setCycle: End self)
			)
			(4
				(gCurRoom newRoom: 20100) ; roCliffScroller
				(self dispose:)
			)
		)
	)
)

(instance poTorin of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self setPri: -1)
	)
)

(instance poBoogle of Prop
	(properties)
)

(instance voTableTop of View
	(properties
		x 368
		y 273
		view 20611
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
		(self setPri: 1)
	)

	(method (doVerb)
		(gEgo setScript: soTakeTableTop)
	)
)

(instance soTakeTableTop of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 362 288 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(2
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(3
				(gEgo get: ((ScriptID 64001 0) get: 18)) ; oInvHandler, ioTableTopTile
				((ScriptID 64017 0) set: 50) ; oFlags
				(voTableTop dispose:)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voPillow of View
	(properties
		x 664
		y 297
		view 20613
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
	)

	(method (doVerb)
		(gEgo setScript: soTakePillow)
	)
)

(instance soTakePillow of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 591 288 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 135 self)
			)
			(2
				(gEgo hide:)
				(voPillow dispose:)
				(poTorin
					view: 20621
					loop: 2
					cel: 0
					posn: 591 288
					init:
					setCycle: End self
				)
			)
			(3
				(poTorin dispose:)
				(gEgo show:)
				(gEgo get: ((ScriptID 64001 0) get: 27)) ; oInvHandler, ioHaremPillow
				((ScriptID 64017 0) set: 59) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voFan of View
	(properties
		x 565
		y 294
		view 20615
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
	)

	(method (doVerb)
		(gEgo setScript: soTakeFan)
	)
)

(instance soTakeFan of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 620 294 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 225 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 20601
					loop: 0
					cel: 0
					posn: 620 294
					init:
					setCycle: CT 3 1 self
				)
			)
			(3
				(= ticks (poTorin cycleSpeed:))
			)
			(4
				(voFan dispose:)
				(poTorin cel: 4 doit: setCycle: End self)
			)
			(5
				(poTorin dispose:)
				(gEgo posn: 630 296 normalize: 1 60100 2 show:)
				(gEgo get: ((ScriptID 64001 0) get: 30)) ; oInvHandler, ioFan
				((ScriptID 64017 0) set: 62) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foLedge of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 39 46 1)
		(if ((ScriptID 64017 0) test: 95) ; oFlags
			(self addHotspotVerb: 40)
		)
		(= noun 8)
		(self setRect: 82 410 158 487)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(39 ; ioStinkyCarpet
				(gEgo setScript: soDropStinkyCarpet)
			)
			(40 ; ioFan
				(if ((ScriptID 64017 0) test: 95) ; oFlags
					(gEgo setScript: soFanStink)
				)
			)
			(46 ; ioBoogleYoYo
				(KillHaremTalk)
				(= bTalking 1)
				(gMessager say: 8 46 0 0 coDoneTalking) ; "What if I tried that inside, by that ladder?"
			)
			(1 ; Do
				(KillHaremTalk)
				(= bTalking 1)
				(gMessager say: 8 1 0 0 coDoneTalking) ; "There's just no way I could climb down there without falling."
			)
		)
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= bTalking 0)
	)
)

(instance soDropStinkyCarpet of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 117 269 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 225 self)
				((gCurRoom plane:) panTo: 0 0 self 1)
			)
			(2)
			(3
				(gEgo hide:)
				(poTorin
					view: 20618
					loop: 0
					cel: 0
					posn: 117 269
					init:
					setPri: 500
					setCycle: End self
				)
			)
			(4
				((ScriptID 64017 0) set: 95) ; oFlags
				(gEgo put: ((ScriptID 64001 0) get: 29) 20600) ; oInvHandler, ioStinkyCarpet
				(voStinkyCarpetOnLedge init:)
				((gCurRoom plane:) panTo: 33536 264 self 1)
			)
			(5
				(= ticks 60)
				(gEgo posn: 120 270 normalize: 1 60100 2 show:)
				(poTorin dispose:)
			)
			(6
				((gCurRoom plane:) panTo: 0 0 self 1)
			)
			(7
				(foLedge addHotspotVerb: 40)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voStinkyCarpetOnLedge of View
	(properties
		x 54
		y 489
		priority 446
		fixPriority 1
		view 20614
		loop 1
	)

	(method (init)
		(super init: &rest)
		(foLedge addHotspotVerb: 40)
		(poCarpetStench init:)
	)
)

(instance poCarpetStench of Prop
	(properties
		x 115
		y 474
		priority 450
		fixPriority 1
		view 20614
		loop 2
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)

	(method (doit)
		(if (and (!= loop nNewStenchLoop) (== cel 0))
			(= loop nNewStenchLoop)
		)
		(super doit: &rest)
	)
)

(instance oButtSound of TPSound
	(properties)
)

(instance soFanStink of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(((ScriptID 64001 0) get: 30) moveTo: -3) ; oInvHandler, ioFan
				(gEgo setMotion: PolyPath 122 268 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 20619
					loop: 0
					cel: 0
					posn: 120 217
					init:
					setPri: 500
					setCycle: CT 21 1 self
				)
			)
			(3
				(KillHaremTalk)
				(= bTalking 1)
				(gMessager say: 8 40 11 1 self) ; "This ought to drive those women out of there!"
			)
			(4
				(= bTalking 0)
				(poTorin setCycle: CT 27 1 self)
			)
			(5
				(poTorin setScript: soKeepTorinFanning)
				(= nNewStenchLoop 3)
				((gCurRoom plane:) panTo: 33536 288 self 2 6 7)
			)
			(6
				(= ticks 180)
			)
			(7
				((gCurRoom plane:) panTo: 264 33536 self 2 4 5)
			)
			(8
				(oButtSound preload: 20610)
				(poGirl1 setScript: soGirl1Runs self)
				(poGirl2 setScript: soGirl2Runs self)
				(poGirl3 setScript: soGirl3Runs self)
				(poGirl4 setScript: soGirl4Runs self)
				(= nGirlsFidgeting 0)
				(= nNewStenchLoop 2)
				(poTorin dispose:)
				(gEgo put: ((ScriptID 64001 0) get: 30)) ; oInvHandler, ioFan
				(gEgo show:)
			)
			(9)
			(10)
			(11)
			(12
				((gCurRoom plane:) panTo: 0 0 self 1 8 7)
			)
			(13
				(gMessager say: 8 40 11 8 self) ; "Yes!"
			)
			(14
				((ScriptID 64017 0) set: 96) ; oFlags
				(goMusic1 setMusic: 20600)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (rewind)
		(poGirl1 view: 20608 loop: 0 cel: 0 posn: 620 446 init: setScript: 0)
		(poGirl2
			view: 20608
			loop: 2
			cel: 0
			posn: 407 454
			init:
			setPri: 100
			setScript: 0
		)
		(poGirl3 view: 20608 loop: 4 cel: 0 posn: 492 449 init: setScript: 0)
		(poGirl4 view: 20608 loop: 6 cel: 0 posn: 568 452 init: setScript: 0)
		(goSound1 stop:)
		(StartHaremChatter)
		(goMusic1 setMusic: 0)
		(poTorin dispose:)
		(gEgo posn: 122 268 show:)
		((gCurRoom plane:) scrollTo: 0 0)
		(= nGirlsFidgeting 0)
		(gEgo setScript: soFanStink)
	)

	(method (ff)
		(KillHaremChatter)
		(goMusic1 setMusic: 20600)
		(poGirl1 dispose:)
		(poGirl2 dispose:)
		(poGirl3 dispose:)
		(poGirl4 dispose:)
		(poTorin dispose:)
		(gEgo posn: 122 268 show:)
		((gCurRoom plane:) scrollTo: 0 0)
		(goSound1 stop:)
		((ScriptID 64017 0) set: 96) ; oFlags
		(gEgo put: ((ScriptID 64001 0) get: 30)) ; oInvHandler, ioFan
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soGirl1Runs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poGirl1
					view: 20608
					loop: 0
					cel: 0
					posn: 620 446
					setCycle: CT 5 1 self
				)
			)
			(1
				(KillHaremChatter)
				(goSound1 playSound: 20606)
				(poGirl1 setCycle: End self)
			)
			(2
				(poGirl1 loop: 1 cel: 0 posn: 675 485 setCycle: End self)
			)
			(3
				(poGirl1 dispose:)
			)
		)
	)
)

(instance soGirl2Runs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poGirl2
					view: 20608
					loop: 2
					cel: 0
					posn: 407 454
					setCycle: CT 21 1 self
				)
			)
			(1
				(poGirl2 setPri: 500 setCycle: End self)
			)
			(2
				(poGirl2 loop: 3 cel: 0 posn: 407 519 setCycle: CT 14 1 self)
			)
			(3
				(poGirl2 setPri: 5 setCycle: CT 24 1 self)
			)
			(4
				(oButtSound playSound: 20610)
				(poGirl2 setCycle: End self)
			)
			(5
				(poGirl2 dispose:)
			)
		)
	)
)

(instance soGirl3Runs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poGirl3
					view: 20608
					loop: 4
					cel: 0
					posn: 492 449
					setCycle: End self
				)
			)
			(1
				(poGirl3 loop: 5 cel: 0 posn: 627 519 setCycle: End self)
			)
			(2
				(poGirl3 dispose:)
			)
		)
	)
)

(instance soGirl4Runs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poGirl4
					view: 20608
					loop: 6
					cel: 0
					posn: 568 452
					setCycle: End self
				)
			)
			(1
				(poGirl4 loop: 7 cel: 0 posn: 570 452 setCycle: End self)
			)
			(2
				(poGirl4 dispose:)
			)
		)
	)
)

(instance soKeepTorinFanning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin cel: 28 setCycle: CT 33 1 self)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance voCarpet of View
	(properties
		x 546
		y 283
		priority 10
		fixPriority 1
		view 20614
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
	)

	(method (doVerb)
		(gEgo setScript: soTakeCarpet)
	)
)

(instance soTakeCarpet of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 459 289 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 20620
					loop: 1
					cel: 0
					posn: 459 289
					cycleSpeed: 9
					init:
					setCycle: CT 7 1 self
				)
			)
			(3
				(voCarpet dispose:)
				(poTorin setCycle: End self)
			)
			(4
				(gEgo show:)
				(poTorin cycleSpeed: 7 dispose:)
				(gEgo get: ((ScriptID 64001 0) get: 28)) ; oInvHandler, ioRedCarpet
				((ScriptID 64017 0) set: 60) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voLadder of View
	(properties
		x 834
		y 294
		view 20610
	)

	(method (init)
		(super init: &rest)
		(|= signal $1000)
		(self setPri: 10)
	)

	(method (testHotspotVerb)
		(foLadderHole testHotspotVerb: &rest)
	)

	(method (doVerb)
		(foLadderHole doVerb: &rest)
	)
)

(instance foLadderHole of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 46)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 809 266 900 266 918 277 932 288 827 287
					yourself:
				)
		)
	)

	(method (testHotspotVerb theVerb)
		(if (and (== theVerb 46) bBoogleAtBottom)
			(return 0)
		else
			(return (super testHotspotVerb: theVerb &rest))
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soLadderDeath)
			)
			(46 ; ioBoogleYoYo
				(gEgo setScript: soYoYoBoogle)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soLadderDeath of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 836 292 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(KillHaremTalk)
				(= bTalking 1)
				(gMessager sayRange: 7 1 0 1 2 self) ; "This ladder looks a little rickety, but I'm going to try it anyway."
			)
			(3
				(= bTalking 0)
				(gEgo hide:)
				(voLadder hide:)
				(poTorin
					view: 20603
					loop: 0
					cel: 0
					posn: 834 294
					init:
					setCycle: CT 10 1 self
				)
			)
			(4
				((gCurRoom plane:) panTo: 33536 177 0 1)
				(poTorin setPri: 10 setCycle: End self)
				(goSound1 playSound: 20601 self)
				(if (not ((ScriptID 64017 0) test: 96)) ; oFlags
					(KillHaremTalk)
				)
			)
			(5)
			(6
				(goSound1 playSound: 20602 self)
			)
			(7
				(gGame handsOn:)
				(KillHaremChatter)
				(if ((ScriptID 64019 0) show: 0 42 13) ; DeathDialog
					(poTorin dispose:)
					(voLadder show:)
					(if (not ((ScriptID 64017 0) test: 96)) ; oFlags
						(StartHaremChatter)
					)
					(gEgo show:)
					((gCurRoom plane:) scrollTo: 2000 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance soYoYoBoogle of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(((ScriptID 64001 1) get: 2) moveTo: -3) ; oBoogleHandler, ioBoogleYoYo
				(gEgo setMotion: PolyPath 780 290 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 60019)
				(gEgo setHeading: 90 self)
			)
			(2
				(KillHaremTalk)
				(= bTalking 1)
				(if ((ScriptID 64017 0) test: 96) ; oFlags
					(gMessager say: 7 46 7 0 self) ; "Now that the "girls" are gone, let's send you down there as a yo-yo, Boogle."
				else
					(gMessager say: 7 46 1 0 self) ; "Boogle, why don't you go down there as a yo-yo? I'm sure they won't bother you."
				)
			)
			(3
				(= bTalking 0)
				(gEgo hide:)
				(poTorin
					view: 20622
					loop: 0
					cel: 0
					posn: 782 290
					init:
					setPri: 287
					doit:
					setCycle: CT 10 1 self
				)
			)
			(4
				(poTorin setCycle: End self)
				((gCurRoom plane:) panTo: 33536 316 0 1 5 5)
			)
			(5
				(poTorin setPri: -1 dispose:)
				(gEgo show:)
				(poBoogle
					view: 20622
					loop: 1
					cel: 0
					posn: 670 497
					init:
					setCycle: End self
				)
				(goSound1 playSound: 60019)
			)
			(6
				(poBoogle dispose:)
				((ScriptID 64017 0) clear: 232) ; oFlags
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 670 497
					setLoop: 1
					heading: 270
					stopwalk:
					show:
				)
				(if (not ((ScriptID 64017 0) test: 96)) ; oFlags
					(self setScript: soGirlsPlayBall self)
				else
					((ScriptID 64017 0) set: 97) ; oFlags
					(= bBoogleAtBottom 1)
					(foBackToTop init:)
					(self cue:)
				)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oSoundThingy of TPSound
	(properties)
)

(instance soGirlsPlayBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(KillHaremChatter)
				(goSound1 preload: 20615 20608 20609 20611 20616 20603)
				(poGirl1 setScript: 0 view: 20604 loop: 3 cel: 0)
				(poGirl2 setScript: 0 view: 20604 loop: 0 cel: 0)
				(poGirl3 setScript: 0 view: 20604 loop: 1 cel: 0)
				(poGirl4 setScript: 0 view: 20604 loop: 2 cel: 0)
				(= nGirlsFidgeting 0)
				((ScriptID 64018 0) setMotion: MoveTo 645 524) ; oBoogle
				(poGirl3 view: 20625 loop: 0 cel: 0 setCycle: CT 13 1 self)
			)
			(1
				((ScriptID 64018 0) hide:) ; oBoogle
				(poGirl3 cel: 14)
				(poGirl3 setCycle: CT 28 1 self)
			)
			(2
				(poGirl3 setCycle: End self)
				(goMusic1 playSound: 20615)
			)
			(3
				(poGirl1 view: 20625 loop: 2 cel: 0 setCycle: CT 6 1 self)
			)
			(4
				(poGirl1 setCycle: CT 15 1 self)
				(poGirl3 view: 20625 loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(goSound1 playSound: 20609)
				(poGirl1 setCycle: End self)
			)
			(6)
			(7
				(poGirl2 view: 20625 loop: 3 cel: 0 setCycle: CT 6 1 self)
			)
			(8
				(goSound1 playSound: 20616)
				(voGongBonger hide:)
				(poGirl2 setCycle: End self)
			)
			(9
				(poGirl1 view: 20625 loop: 4 cel: 0 setCycle: CT 6 1 self)
			)
			(10
				(poGirl1 setCycle: End)
				(poGirl2 view: 20625 loop: 5 cel: 0 setCycle: CT 2 1 self)
			)
			(11
				(oSoundThingy playSound: 20608)
				(poGirl2 setCycle: CT 4 1 self)
			)
			(12
				(goSound1 playSound: 20611)
				(poGirl2 setCycle: CT 6 1 self)
			)
			(13
				(goSound1 playSound: 20611)
				(poGirl2 setCycle: End self)
			)
			(14
				(goSound1 playSound: 20611)
				(= ticks 20)
			)
			(15
				(goSound1 playSound: 20603 self)
			)
			(16
				(if ((ScriptID 64019 0) show: 0 42 1) ; DeathDialog
					((gCurRoom plane:) scrollTo: 400 0)
					((ScriptID 64018 0) hide:) ; oBoogle
					(voGongBonger show:)
					(poGirl1
						view: 20604
						loop: 3
						cel: 0
						setScript: (soWaitRandomForFidget new:)
					)
					(poGirl2
						view: 20604
						loop: 0
						cel: 0
						setScript: (soWaitRandomForFidget new:)
					)
					(poGirl3
						view: 20604
						loop: 1
						cel: 0
						setScript: (soWaitRandomForFidget new:)
					)
					(poGirl4
						view: 20604
						loop: 2
						cel: 0
						setScript: (soWaitRandomForFidget new:)
					)
					(StartHaremChatter)
				)
				((ScriptID 64017 0) set: 232) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foBackToTop of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 725 452 727 389 741 374 755 374 753 445
					yourself:
				)
		)
	)

	(method (doVerb)
		(gEgo setScript: soBoogleBackUp)
	)
)

(instance soBoogleBackUp of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((gCurRoom plane:) scrollToObj: foBackToTop)
				(goMusic1 fadeOut:)
				(goSound1 preload: 20607 20613)
				((ScriptID 64017 0) set: 98) ; oFlags
				(= ticks 20)
			)
			(1
				(gMessager say: 10 1 10 0 self) ; "Boogle! See where that doorway goes!"
			)
			(2
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					setPri: 0
					setMotion: PolyPath 708 474 self
				)
			)
			(3
				((ScriptID 64018 0) setMotion: MoveTo 780 451 self) ; oBoogle
			)
			(4
				(goSound1 playSound: 20607 self)
				(gEgo setMotion: MoveTo 608 277 self)
				(self setScript: soPanLots self)
				((ScriptID 64018 0) hide: setPri: -1) ; oBoogle
			)
			(5)
			(6)
			(7
				(gEgo setHeading: 270)
				(poBoogle
					view: 20624
					loop: 0
					cel: 0
					posn: 532 277
					init:
					setCycle: CT 1 1 self
				)
			)
			(8
				(goSound1 playSound: 20613)
				(poBoogle setCycle: End self)
			)
			(9
				(poBoogle dispose:)
				((ScriptID 64018 0) ; oBoogle
					posn: 532 277
					setLoop: 4
					heading: 135
					setWander: 0
					stopwalk:
					show:
				)
				(= bBoogleAtBottom 0)
				(gMessager say: 4 1 12 3 self) ; "(HEH, HEH, HEH) Bwark!"
			)
			(10
				(= ticks 120)
			)
			(11
				(self setScript: (ScriptID 64018 1) self) ; soBoogleIntoPouch
			)
			(12
				(goMusic1 setMusic: 20600)
				(foBackToTop dispose:)
				(if ((ScriptID 64017 0) test: 94) ; oFlags
					(gEgo get: ((ScriptID 64001 0) get: 20)) ; oInvHandler, ioTubTile
					((ScriptID 64017 0) set: 52) ; oFlags
				else
					((ScriptID 64017 0) clear: 97) ; oFlags
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (rewind)
		(self setScript: 0)
		((gCurRoom plane:) killPan:)
		(foBackToTop init:)
		((ScriptID 64017 0) clear: 232) ; oFlags
		((ScriptID 64018 0) ; oBoogle
			setWander: 0
			posn: 670 497
			setLoop: 1
			heading: 270
			stopwalk:
			show:
		)
		(goSound1 stop:)
		(goMusic1 setMusic: 20600)
		(gEgo setScript: self)
	)

	(method (ff)
		((ScriptID 64018 0) setMotion: 0 hide:) ; oBoogle
		(self setScript: 0)
		((gCurRoom plane:) scrollTo: 216 0)
		(gEgo setMotion: 0 posn: 608 277)
		(goSound1 stop:)
		(goMusic1 setMusic: 20600)
		(gGame handsOn:)
		(foBackToTop dispose:)
		(= bBoogleAtBottom 0)
		(if ((ScriptID 64017 0) test: 94) ; oFlags
			(gEgo get: ((ScriptID 64001 0) get: 20)) ; oInvHandler, ioTubTile
			((ScriptID 64017 0) set: 52) ; oFlags
		else
			((ScriptID 64017 0) clear: 97) ; oFlags
		)
		(self dispose:)
	)
)

(instance soPanLots of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gCurRoom plane:) panTo: 216 0 self 4 5 5)
				((gCurRoom plane:) panTo: 50 100 self 4 5 5)
			)
			(1
				(= ticks 90)
			)
			(2
				((gCurRoom plane:) panTo: 300 200 self 4 3 3)
			)
			(3
				(= ticks 45)
			)
			(4
				((gCurRoom plane:) panTo: 316 316 self 4 8 8)
			)
			(5
				(= ticks 20)
			)
			(6
				((gCurRoom plane:) panTo: 0 0 self 4 8 8)
			)
			(7
				((gCurRoom plane:) panTo: 50 300 self 4 12 12)
			)
			(8
				((gCurRoom plane:) panTo: 100 0 self 4 12 12)
			)
			(9
				((gCurRoom plane:) panTo: 150 300 self 4 12 12)
			)
			(10
				((gCurRoom plane:) panTo: 316 150 self 4 12 12)
			)
			(11
				((gCurRoom plane:) panTo: 216 0 self 4 5 5)
			)
			(12
				(self dispose:)
			)
		)
	)
)

(instance soBoogleBackUpAndExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: soBoogleBackUp self)
			)
			(1
				(foToCliffExit doVerb: 1)
			)
		)
	)
)

(instance soWaitRandomForFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 200 400))
			)
			(1
				(= ticks 10)
			)
			(2
				(if (>= nGirlsFidgeting 2)
					(self changeState: 1)
					(return)
				)
				(client setScript: (soFidgetGirls new:))
			)
		)
	)
)

(instance soFidgetGirls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ nGirlsFidgeting)
				(= register (client loop:))
				(switch register
					(0
						(client view: 20627)
					)
					(1
						(client view: 20628)
					)
					(2
						(client view: 20629)
					)
					(3
						(client view: 20626)
					)
				)
				(client loop: 0)
				(client setCycle: End self)
			)
			(1
				(client view: 20604 loop: register cel: 0)
				(= register 0)
				(-- nGirlsFidgeting)
				(client setScript: (soWaitRandomForFidget new:))
			)
		)
	)

	(method (dispose)
		(client setCycle: 0)
		(super dispose: &rest)
	)
)

(instance poGirl1 of Prop
	(properties
		x 620
		y 446
		view 20604
		loop 3
		cycleSpeed 6
	)

	(method (init)
		(super init: &rest)
		(self setScript: (soWaitRandomForFidget new:))
		(self setPri: 4)
	)
)

(instance poGirl2 of Prop
	(properties
		x 407
		y 454
		view 20604
		cycleSpeed 6
	)

	(method (init)
		(super init: &rest)
		(self setScript: (soWaitRandomForFidget new:))
		(self setPri: 100)
	)
)

(instance poGirl3 of Prop
	(properties
		x 492
		y 449
		view 20604
		loop 1
		cycleSpeed 6
	)

	(method (init)
		(super init: &rest)
		(self setScript: (soWaitRandomForFidget new:))
		(self setPri: 5)
	)
)

(instance poGirl4 of Prop
	(properties
		x 568
		y 452
		view 20604
		loop 2
		cycleSpeed 6
	)

	(method (init)
		(super init: &rest)
		(self setScript: (soWaitRandomForFidget new:))
		(self setPri: 3)
	)
)

(instance voWarningSign of View
	(properties
		x 913
		y 246
		view 20612
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
	)

	(method (doVerb)
		(gEgo setScript: soShowSign)
	)
)

(instance soShowSign of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 850 288 self)
			)
			(1
				(= cycles 1)
			)
			(2
				(gCurRoom addRoomPlane: oSignCUPlane)
				(self dispose:)
			)
		)
	)
)

(instance voGongBonger of View
	(properties
		x 407
		y 454
		view 20616
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
	)
)

(instance voGongChain of View
	(properties
		x 568
		y 514
		view 20605
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
	)
)

(instance voGongTile of View
	(properties
		x 568
		y 514
		view 20605
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
		(self setPri: 1)
	)

	(method (testHotspotVerb)
		(if (not ((ScriptID 64017 0) test: 94)) ; oFlags
			(return (super testHotspotVerb: &rest))
		else
			(return 0)
		)
	)

	(method (doVerb)
		(if bBoogleAtBottom
			(gEgo setScript: soTakeGong)
		else
			(KillHaremTalk)
			(= bTalking 1)
			(gMessager say: 4 1 0 0 coDoneTalking) ; "Hmm. That looks like another one of those tiles."
		)
	)
)

(instance soTakeGong of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 20616)
				(gMessager say: 4 1 12 1 self) ; "(YELLS) Boogle! Grab that tile hanging there!"
			)
			(1
				((ScriptID 64018 0) setMotion: PolyPath 568 514 self) ; oBoogle
			)
			(2
				((ScriptID 64018 0) setHeading: 315 self) ; oBoogle
			)
			(3
				((ScriptID 64018 0) hide:) ; oBoogle
				(poBoogle view: 20623 loop: 0 cel: 0 posn: 568 514 init:)
				(poBoogle setCycle: CT 25 1 self)
			)
			(4
				(voGongTile dispose:)
				(poBoogle setCycle: CT 32 1 self)
			)
			(5
				(goSound1 playSound: 20616)
				(gMessager say: 4 1 12 2) ; "Attaboy, Boog!"
				(poBoogle setCycle: CT 45 1 self)
			)
			(6
				(voGongChain init:)
				(poBoogle setCycle: End self)
			)
			(7
				(poBoogle dispose:)
				((ScriptID 64018 0) posn: 666 513 setLoop: 4 show:) ; oBoogle
				((ScriptID 64017 0) set: 94) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oChatter of TPSound
	(properties)
)

(instance oHaremTalk of TPSound
	(properties)
)

(instance poNull of Prop
	(properties)
)

(instance soHaremGirlsChatter of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oChatter setAmbient: 20605 setRelVol: 50)
				(oHaremTalk setRelVol: 25)
				(self cue:)
			)
			(1
				(= ticks (Random 200 300))
			)
			(2
				(if bTalking
					(self changeState: 1)
					(return)
				)
				(= bTalking 1)
				(oHaremTalk playMessage: 0 0 1 (Random 1 26) self 20600 1)
			)
			(3
				(= bTalking 0)
				(self changeState: 1)
			)
		)
	)
)

(instance voSignBG of View
	(properties
		view 20602
	)
)

(instance foSignCU of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 460 33 546 124 468 223 384 132
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gCurRoom setScript: soTakeSign)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance soTakeSign of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo get: ((ScriptID 64001 0) get: 19)) ; oInvHandler, ioWarningTile
				((ScriptID 64017 0) set: 51) ; oFlags
				(voWarningSign dispose:)
				(gCurRoom deleteRoomPlane: oSignCUPlane)
				(self dispose:)
			)
		)
	)
)

(instance oSignCUPlane of Plane
	(properties
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(voSignBG init:)
		(foSignCU init:)
		(foExitCU init:)
	)
)

(instance oSeraglioScrollPlane of TorScrollPlane
	(properties
		priority 20
	)

	(method (addPics)
		(LockNLoad 129 20600 20601 20602 20603)
		(AddPicAt self 20600 0 0)
		(AddPicAt self 20601 474 0)
		(AddPicAt self 20603 0 316)
		(AddPicAt self 20602 474 316)
	)

	(method (dispose)
		(UnlockNUnload 129 20600 20601 20602 20603)
		(super dispose: &rest)
	)
)

(instance roSeraglio of TPRoom
	(properties)

	(method (init)
		(super init: &rest)
		(= plane (oSeraglioScrollPlane init: 948 632 yourself:))
		((plane oNScrollExit:) dispose:)
		(plane oNScrollExit: -1)
		((plane oSScrollExit:) dispose:)
		(plane oSScrollExit: -1)
		(goMusic1 setMusic: 0)
		((ScriptID 64017 0) set: 93) ; oFlags
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 91 279 300 283 769 297 843 299 946 298 946 291 786 291 662 283 545 254 413 260 369 274 298 253 102 249
					yourself:
				)
		)
		(if (not ((ScriptID 64017 0) test: 50)) ; oFlags
			(voTableTop init:)
		)
		(if (not ((ScriptID 64017 0) test: 59)) ; oFlags
			(voPillow init:)
		)
		(if (not ((ScriptID 64017 0) test: 51)) ; oFlags
			(voWarningSign init:)
		)
		(if (not ((ScriptID 64017 0) test: 62)) ; oFlags
			(voFan init:)
		)
		(if (not ((ScriptID 64017 0) test: 60)) ; oFlags
			(voCarpet init:)
		)
		(if (not ((ScriptID 64017 0) test: 94)) ; oFlags
			(voGongTile init:)
		else
			(voGongChain init:)
		)
		(if (not ((ScriptID 64017 0) test: 96)) ; oFlags
			(poGirl1 init:)
			(poGirl2 init:)
			(poGirl3 init:)
			(poGirl4 init:)
			(poNull setScript: soHaremGirlsChatter)
		else
			(goMusic1 setMusic: 20600)
		)
		(foLedge init:)
		(if ((ScriptID 64017 0) test: 95) ; oFlags
			(voStinkyCarpetOnLedge init:)
		)
		(foLadderHole init:)
		(voLadder init:)
		(voGongBonger init:)
		(foToCliffExit init:)
		(gEgo init: normalize:)
		((ScriptID 64018 0) posn: 146 276 init: normalize: setWander: 0 hide:) ; oBoogle
		(gGame handsOn:)
		(gEgo posn: 102 280 hide:)
		(gEgo setScript: soClimbIn)
	)

	(method (dispose)
		(KillHaremChatter)
		(super dispose: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(if (poNull script:)
			((poNull script:) doit:)
		)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 1) get: 2)) ; oBoogleHandler, ioBoogleYoYo
		(gEgo get: ((ScriptID 64001 0) get: 29)) ; oInvHandler, ioStinkyCarpet
		(gEgo get: ((ScriptID 64001 0) get: 30)) ; oInvHandler, ioFan
	)
)

