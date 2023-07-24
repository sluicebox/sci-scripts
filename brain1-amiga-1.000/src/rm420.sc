;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use Interface)
(use s)
(use concentrate)
(use solar)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)

(public
	rm420 0
	proc420_1 1
	consFinished 2
	proc420_3 3
	Globespinning 4
	monoAppears 5
	monolith 6
	outWhite 7
)

(local
	local0
	local1
)

(procedure (proc420_3 param1 param2)
	(switch param2
		(3
			(proc5_9 420 4) ; "Not even Dr. Brain knows how to move a constellation!"
		)
		(2
			(switch param1
				(0
					(proc5_9 420 5) ; "Perseus was the Greek hero who killed Medusa (who turned anyone who saw her face to stone), and rescued Andromeda from Cetus, the sea monster."
				)
				(1
					(proc5_9 420 6) ; "Ursa Major, or the Great Bear, includes the familiar Big Dipper. The cup part of the Dipper points toward Polaris, the North Star. The Great Bear was originally a human woman, Callisto, who was Zeus's lover. Hera got mad and changed her into a bear."
				)
				(2
					(proc5_9 420 7) ; "Cancer was a giant crab in Greek myth. (Cancer fought Hercules at one point, but Hercules won. Perhaps this is why Cancer is so crabby.)"
				)
				(3
					(proc5_9 420 8) ; "The mighty hunter Orion was companion to Artemis, goddess of the hunt. Orion carries his hunting equipment on his three-star belt."
				)
			)
		)
	)
)

(procedure (localproc_0 &tmp temp0 temp1)
	(cond
		((IsFlag 30)
			(= temp1 4)
		)
		((IsFlag 29)
			(= temp1 3)
		)
		((IsFlag 28)
			(= temp1 2)
		)
		((IsFlag 27)
			(= temp1 1)
		)
		(else
			(= temp1 0)
		)
	)
	(for ((= global171 0)) (< global171 temp1) ((++ global171))
		(proc420_1 0)
	)
	(= global171 temp1)
)

(procedure (proc420_1 param1 &tmp temp0 temp1)
	(= temp1 (IsFlag 31))
	(switch global171
		(0
			(if (not temp1)
				(= global172 perseus)
			else
				(= global172 perseusPV)
			)
		)
		(1
			(if (not temp1)
				(= global172 UrsaMajor)
			else
				(= global172 UrsaMajorPV)
			)
		)
		(2
			(if (not temp1)
				(= global172 cancer)
			else
				(= global172 cancerPV)
			)
		)
		(3
			(if (not temp1)
				(= global172 Orion)
			else
				(= global172 OrionPV)
			)
		)
	)
	(global172 cel: (if (== param1 1) 0 else 1) signal: 4096 init:)
	(if temp1
		(gAddToPics doit:)
	)
	(Animate (gCast elements:) 0)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 100)) (<= temp0 5000) ((+= temp0 30))
		(Palette palSET_INTENSITY 0 255 temp0)
	)
	(gCurRoom drawPic: 421 9)
)

(procedure (localproc_2)
	(medSmallBluePlan init:)
	(RingedPlan init:)
	(medSmallBrownPlan init:)
	(larLightBrownPlan init:)
	(larPockMarkedPlan init:)
	(smallPockMarkedPlan init:)
	(spiralNebula init:)
)

(instance rm420 of Rm
	(properties
		lookStr {Dr. Brain is more interested in looking at the stars than being one.}
		picture 420
		style 7
		south 200
	)

	(method (init &tmp temp0)
		(super init:)
		(gCMusic number: 420 setLoop: -1 flags: 1 play:)
		(LoadMany rsSOUND 420 421 422 423 424 921 939 963 966)
		(LoadMany rsVIEW 425 426 427)
		(Load rsPIC 421)
		(localproc_0)
		(localproc_2)
		(consFeat onMeCheck: 2048 init:)
		(if (IsFlag 36)
			(monolith
				init:
				cel:
					(if (IsFlag 36)
						(- (NumCels monolith) 1)
					else
						0
					)
			)
		)
		(Globespinning setCycle: Fwd init:)
		(cabinet onMeCheck: 1024 init:)
		(if (IsFlag 45)
			(leftCabDoor init:)
			(rightCabDoor init:)
		)
		(Animate (gCast elements:) 0)
		(sun onMeCheck: 16384 setCycle: Fwd init:)
		(Animate (gCast elements:) 0)
		(proc5_9 420 0) ; "You are in Dr. Brain's private planetarium in the castle tower. Only Dr. Brain would put the sun and stars in the sky at the same time."
	)

	(method (dispose)
		(if local1
			(SetFlag 45)
		)
		(cond
			((not (IsFlag 31))
				(proc425_2)
			)
			((not (IsFlag 36))
				(proc427_1)
			)
			((not (IsFlag 35))
				(proc428_1)
			)
		)
		(gCMusic fade: 0 15 12 1)
		(gCMusic2 fade: 0 15 12 1)
		(super dispose: &rest)
	)
)

(instance monolith of Prop
	(properties
		x 160
		y 184
		description {monolith}
		lookStr {At the dawn of mankind, some mysterious power conferred intelligence on our ancestors. Now the monolith is the gateway to even greater knowledge -- the Office of Dr. Brain.}
		view 420
		loop 1
		cel 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(cond
				((IsFlag 35)
					(gCurRoom newRoom: 440)
				)
				((IsFlag 36)
					(sun setCycle: 0 stopUpd:)
					((ScriptID 428 0) init:) ; solar
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance leftCabDoor of View
	(properties
		x 80
		y 184
		view 420
		loop 4
	)

	(method (doVerb theVerb invItem)
		(cabinet doVerb: theVerb invItem)
	)
)

(instance rightCabDoor of View
	(properties
		x 80
		y 184
		view 420
		loop 4
		cel 1
	)

	(method (doVerb theVerb)
		(cabinet doVerb: theVerb)
	)
)

(instance medSmallBluePlan of Feature
	(properties
		description {blue planet}
		onMeCheck 64
		lookStr {This is either an Earth-like planet, or a hard-boiled egg.}
	)
)

(instance RingedPlan of Feature
	(properties
		description {ringed planet}
		onMeCheck 8
		lookStr {You think this planet might be Saturn, at least that has the right ring to it.}
	)
)

(instance medSmallBrownPlan of Feature
	(properties
		description {brown planet}
		onMeCheck 128
		lookStr {At last you know what happens to the hole after they cut it out of a donut.}
	)
)

(instance larLightBrownPlan of Feature
	(properties
		description {large brown planet}
		onMeCheck 4
		lookStr {Dr. Brain has been missing this baked potato for some time.}
	)
)

(instance larPockMarkedPlan of Feature
	(properties
		description {large pock-marked planet}
		onMeCheck 2
		lookStr {Nobody seemed to be using this manhole cover, so Dr. Brain picked it up to use as a planet.}
	)
)

(instance smallPockMarkedPlan of Feature
	(properties
		description {small pock-marked planet}
		onMeCheck 32
		lookStr {It's another one of those shirt buttons that keep getting lost in the wash.}
	)
)

(instance spiralNebula of Feature
	(properties
		description {spiral nebula}
		onMeCheck 256
		lookStr {Dr. Brain picked up this spiral nebula at a great discount (using his revolving charge, of course).}
	)
)

(instance pillars of Feature ; UNUSED
	(properties
		description {pillar}
		lookStr {It was once believed that the sky was a great glass dome, held up from the earth by pillars. Dr. Brain doesn't really believe this, but he thought some pillars would make a nice touch.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3
				(proc5_9 420 1) ; "Even Hercules couldn't support the weight of the sky for long. Better leave that work to Atlas."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance saucer of Actor
	(properties
		x 95
		y 156
		description {flying saucer}
		view 420
		loop 5
	)

	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(if (not (gCurRoom script:))
			(= temp0 (+ x (Random 0 32) -16))
			(= temp1 (+ y (Random 0 28) -14))
			(if (< temp0 0)
				(= temp0 0)
			)
			(if (> temp0 319)
				(= temp0 319)
			)
			(if (< temp1 0)
				(= temp1 0)
			)
			(if (> temp1 199)
				(= temp1 199)
			)
			(self posn: temp0 temp1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc5_9 420 2) ; "The poor alien in the flying saucer looks terribly lost. You should try to help him find his home."
			)
			(3
				(proc5_9 420 3) ; "Free! Free at last!"
				(gCurRoom setScript: leave)
			)
		)
	)
)

(instance Globespinning of Actor
	(properties
		x 228
		y 181
		description { spinning globe}
		lookStr {This spinning globe accurately depicts all of the Earth's major geophysical and political features. Oops, there go the Baltic states!}
		view 420
		cel 1
	)
)

(instance outWhite of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 90)
			)
			(1
				(gCMusic number: 966 setLoop: 1 flags: 1 play: self)
			)
			(2
				(= ticks 60)
			)
			(3
				(gCMusic number: 423 setLoop: 0 flags: 1 play:)
				(= cycles 60)
			)
			(4
				(monolith setLoop: 3 setCel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(5
				(localproc_1)
				(= cycles 1)
			)
			(6
				(gCast eachElementDo: #dispose)
				(Palette palSET_INTENSITY 0 255 100)
				(proc428_1)
				(= ticks 120)
			)
			(7
				(gCMusic number: 963 setLoop: 1 flags: 1 play: self)
			)
			(8
				(gCurRoom newRoom: 440)
				(self dispose:)
			)
		)
	)
)

(instance perseus of View
	(properties
		x 67
		y 30
		description {Perseus}
		view 425
		loop 2
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 3) (== theVerb 2))
			(proc420_3 0 theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance perseusPV of PicView
	(properties
		x 67
		y 30
		description {Perseus}
		view 425
		loop 2
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 3) (== theVerb 2))
			(proc420_3 0 theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance UrsaMajor of View
	(properties
		x 118
		y 60
		description {Ursa Major (the Great Bear)}
		view 425
		loop 3
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 3) (== theVerb 2))
			(proc420_3 1 theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance UrsaMajorPV of PicView
	(properties
		x 118
		y 60
		description {Ursa Major (the Great Bear)}
		view 425
		loop 3
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 3) (== theVerb 2))
			(proc420_3 1 theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance cancer of View
	(properties
		x 199
		y 72
		description {Cancer the Crab}
		view 425
		loop 4
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 3) (== theVerb 2))
			(proc420_3 2 theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance cancerPV of PicView
	(properties
		x 199
		y 72
		description {Cancer the Crab}
		view 425
		loop 4
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 3) (== theVerb 2))
			(proc420_3 2 theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance Orion of View
	(properties
		x 241
		y 36
		description {Orion the Hunter}
		view 425
		loop 5
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 3) (== theVerb 2))
			(proc420_3 3 theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance OrionPV of PicView
	(properties
		x 241
		y 36
		view 425
		loop 5
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 3) (== theVerb 2))
			(proc420_3 3 theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance consFeat of Feature
	(properties
		description {star map}
		lookStr {Dr. Brain has arranged for several of his favorite constellations to appear on the planetarium dome. Your gaze moves across the majestic heavens, just above the smog line.}
	)

	(method (doVerb theVerb invItem &tmp [temp0 102])
		(switch theVerb
			(3
				(if (not (IsFlag 31))
					(sun setCycle: 0 stopUpd:)
					(if (not local0)
						(= local0 1)
						(proc425_0)
					else
						(proc425_1)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cabinetSound of Sound
	(properties
		flags 1
		number 939
	)
)

(instance consFinished of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(perseus dispose:)
				(UrsaMajor dispose:)
				(cancer dispose:)
				(Orion dispose:)
				(localproc_0)
				(gFeatures delete: consFeat addToEnd: consFeat)
				(= cycles 1)
			)
			(1
				(cabinetSound play:)
				(leftCabDoor init:)
				(rightCabDoor init:)
				(= cycles 1)
			)
			(2
				(saucer init: setLoop: 5 setCycle: Fwd setPri: 15)
				(gCMusic2 number: 424 setLoop: -1 flags: 1 play:)
				(= local1 1)
				(= cycles 1)
			)
			(3
				(proc425_2)
				(= cycles 1)
			)
			(4
				(DisposeScript 425)
				(self dispose:)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		description {cabinet}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3
				(cond
					((IsFlag 31)
						(cond
							((not (IsFlag 45))
								(proc5_9 420 9) ; "No! I'm not going back in there!"
								(gCurRoom setScript: leave)
							)
							((not (IsFlag 36))
								(if (!= (gCMusic number:) 421)
									(gCMusic
										stop:
										number: 421
										setLoop: -1
										flags: 1
										play:
									)
								)
								(sun setCycle: 0 stopUpd:)
								((ScriptID 427 0) init:) ; concentrate
							)
							(else
								(proc5_9 420 10) ; "Your feat of Galactic diplomacy has been duly signed, sealed, and recorded."
							)
						)
					)
					((not global173)
						(Print 420 11) ; "The cabinet is securely locked."
					)
				)
			)
			(2
				(if (IsFlag 31)
					(proc5_9 420 12) ; "You could have sworn you saw a little flying saucer come out of this cabinet. In any case, it's no longer locked."
				else
					(proc5_9 420 13) ; "This polished wood cabinet looks totally out of place in the astronomy room. It's securely locked."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sun of Prop
	(properties
		x 153
		description {sun}
		view 420
		loop 6
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2
				(Print 420 14) ; "It's a good thing this is just a painted image of the sun, or you wouldn't be able to see the stars at all!"
			)
			(3
				(Print 420 15) ; "Don't touch the sun -- nuclear fusion in progress!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance leave of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCMusic stop: number: 421 setLoop: -1 flags: 1 play:)
				(SetFlag 45)
				(saucer
					illegalBits: 0
					ignoreActors: 1
					moveSpeed: 0
					xStep: 20
					yStep: 20
					setMotion: MoveTo 155 47 self
				)
			)
			(1
				(saucer setMotion: MoveTo 330 47 self)
			)
			(2
				(gCMusic2 fade: 0 15 12 1)
				(saucer dispose:)
				(= cycles 5)
			)
			(3
				(sun setCycle: 0 stopUpd:)
				(self dispose:)
				((ScriptID 427 0) init:) ; concentrate
			)
		)
	)
)

(instance monoAppears of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCMusic number: 422 setLoop: 0 flags: 1 play:)
				(= ticks 180)
			)
			(1
				(gCMusic2 number: 921 flags: 1 setLoop: 1 setVol: 127 play:)
				(ShakeScreen 20 ssLEFTRIGHT)
				(= ticks 60)
			)
			(2
				(monolith init: cycleSpeed: 12 setCycle: End self)
			)
			(3
				(monolith setLoop: 2 setCel: 0 setCycle: End self)
			)
			(4
				(if (== (gCMusic prevSignal:) -1)
					(= cycles 1)
				else
					(-- state)
					(= cycles 10)
				)
			)
			(5
				(proc5_9 (monolith lookStr:))
				(proc5_9 420 16) ; "But to pass through the monolith, you must show that you know the cradle of mankind -- your own star system. Tag each of the planets with its name -- if you can catch it!"
				(= cycles 1)
			)
			(6
				(proc427_1)
				(DisposeScript 427)
				(self dispose:)
				((ScriptID 428 0) init:) ; solar
			)
		)
	)
)

