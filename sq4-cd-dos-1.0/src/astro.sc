;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Dialog)
(use Sq4Feature)
(use Blk)
(use LoadMany)
(use Sound)
(use Motion)
(use System)

(public
	astro 0
)

(local
	local0 = 1
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
	local12
	local13
	local14
	[local15 6] = [0 5 4 3 2 1]
	[local21 6] = [0 9 8 7 6 5]
	local27 = 50
	local28 = 1
	local29
	local30
	local31
	local32
	local33
)

(instance theSound of Sound
	(properties)
)

(instance winged of Sound
	(properties
		number 56
	)
)

(instance eggSquirt of Sound
	(properties
		number 122
	)
)

(instance eggFall of Sound
	(properties
		number 131
	)
)

(instance eggSplatting of Sound
	(properties
		number 147
	)
)

(instance gunshot of Sound
	(properties
		number 144
	)
)

(instance cornPicker of Sound
	(properties
		number 146
	)
)

(instance dogBarking of Sound
	(properties
		number 827
	)
)

(instance astro of SQRoom
	(properties)

	(method (init)
		(= local30 gGameTime)
		(LoadMany rsVIEW 290 291)
		(Load rsPIC 291)
		(LoadMany rsSOUND 55 140 56 122 131 147 144 146 827)
		(self drawPic: 290 overlay: 291 0 setScript: startScript)
		(gUser canControl: 1 canInput: 1)
		(super init:)
		(= picture 290)
		(= local12 (gGame masterVolume:))
		(musicToggle init:)
		(gMouseDownHandler add: gCast gFeatures)
		(gTheIconBar disable:)
		(sq4 setCursor: 991)
		(gEgo init: hide:)
		(self setRegions: 700) ; mall
	)

	(method (dispose)
		(gMouseDownHandler delete: gCast gFeatures)
		(gTheIconBar enable:)
		(gGame masterVolume: local12)
		(DisposeScript 949)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (< (Abs (- gGameTime local31)) 6)
			0
		else
			(= local31 gGameTime)
			(Palette palANIMATE 48 55 1)
		)
		(if
			(and
				(> (Abs (- gGameTime local30)) 2400)
				(not (astroChicken script:))
				(not (astroIndicator script:))
				local0
			)
			(= local30 gGameTime)
			(astroIndicator setScript: sellOutScript)
		)
		(cond
			((gCurRoom script:))
			((not (-- local27))
				(= local27 50)
				(if (not (gCast contains: henHouseRight))
					(if (not (gCast contains: rock))
						(rock init:)
						(if
							(and
								(not (Random 0 20))
								(not (gCast contains: cedric))
								(not local33)
							)
							(cedric
								view: 272
								setLoop: 0
								setCel: 0
								posn: 360 (Random 20 30)
								setPri: 13
								init:
								scrollSpeed: (+ (/ (- 15 gGameSpeed) 4) 1 1)
								cycleSpeed: 6
								setCycle: Fwd
							)
						)
					)
					(if (not (gCast contains: grass))
						(grass init:)
					)
				)
			)
		)
		(cond
			((gCurRoom script:))
			(local4
				(if (and (not (-- local4)) local5)
					((cornStalk new:) init:)
					(= local4 (* 3 (+ (/ gGameSpeed 3) 1)))
					(-- local5)
				)
			)
			(
				(and
					(>= local9 300)
					(not (gCast contains: crazedFarmer))
					(not (gCast contains: windMill))
					(not (gCast contains: weasel))
					(not (gCast contains: rabidDog))
					(not (gCast contains: astroChicken2))
				)
				(henHouseLeft init:)
				(henHouseRight init:)
				(astroChicken2
					loop: (astroChicken loop:)
					x: (astroChicken x:)
					y: (astroChicken y:)
					init:
					setCycle: Fwd
				)
				(astroChicken hide: dispose:)
				(gCurRoom setScript: doHenHouse)
			)
			(
				(or
					(gCast contains: hill)
					(gCast contains: crazedFarmer)
					(gCast contains: windMill)
					(gCast contains: weasel)
					(gCast contains: chickenWire)
					(gCast contains: henHouseRight)
				))
			((or (gSounds contains: winged) (gSounds contains: 55)))
			((<= (= temp0 (Random 1 100)) 15)
				(hill init:)
				(switch (Random 0 2)
					(0
						(if (not (gCast contains: rabidDog))
							(rabidDog init:)
						)
					)
					(1
						(if (not (gCast contains: crazedFarmer))
							(crazedFarmer init:)
						)
					)
				)
			)
			((<= temp0 30)
				(crazedFarmer init:)
			)
			((<= temp0 40)
				(windMill init:)
			)
			((<= temp0 65)
				(if
					(and
						(< (astroChicken eggsLeft:) 5)
						(not (gCast contains: cornStalk))
					)
					(= local4 3)
					(= local5 (Random 2 8))
				)
			)
			((<= temp0 80)
				(if (== local28 1)
					(= local28 0)
				else
					(weasel init:)
				)
			)
			(
				(and
					(<= temp0 85)
					(not (astroChicken loop:))
					(not (gCast contains: chickenWire))
				)
				(chickenWire init:)
			)
			((not (gCast contains: rabidDog))
				(rabidDog init:)
			)
		)
	)

	(method (newRoom)
		(if local1
			(proc0_12 local1)
		)
		(if local2
			(proc0_12 local2)
		)
		(if local10
			(proc0_12 local10)
		)
		(if local11
			(proc0_12 local11)
		)
		(if local13
			(proc0_12 local13)
		)
		(if local14
			(proc0_12 local14)
		)
		(super newRoom: &rest)
	)
)

(class astroChicken of Sq4Actor
	(properties
		view 290
		signal 2048
		moveSpeed 2
		livesLeft 3
		eggsLeft 10
		wireLeft 0
	)

	(method (init &tmp [temp0 5])
		(gLongSong number: 54 loop: -1 vol: 127 play:)
		(super init:)
		(self
			moveSpeed: (+ (/ gGameSpeed 2) 1)
			show:
			x: 160
			y: 40
			eggsLeft: 10
			loop: 0
			wireLeft: 0
			showEggs:
			showPts:
		)
		(astroIndicator init:)
		(gDirectionHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(if local13
			(proc0_12 local13)
		)
		(if local14
			(proc0_12 local14)
		)
		(= local13 (proc0_12 {Eggs:} 64 150 178 25 global136))
		(= local14 (proc0_12 {Score:} 64 240 178 25 global136))
		(if local2
			(proc0_12 local2)
		)
		(= local2
			(proc0_12 (Format @temp0 {%d} local9) 64 275 178 25 global136 67 25)
		)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (gUser canControl:)
			(cond
				((& (event type:) $0040) ; direction
					(event claimed: 1)
					(switch (event message:)
						(JOY_LEFT
							(astroChicken setMotion: MoveTo 0 (astroChicken y:))
						)
						(JOY_RIGHT
							(astroChicken
								setMotion: MoveTo 320 (astroChicken y:)
							)
						)
						(JOY_UP
							(astroChicken setMotion: MoveTo (astroChicken x:) 0)
						)
						(JOY_DOWN
							(astroChicken
								setMotion: MoveTo (astroChicken x:) 190
							)
						)
					)
				)
				((== (event type:) evMOUSEBUTTON)
					(event claimed: 1)
					(if (== (event modifiers:) emSHIFT)
						(if
							(and
								eggsLeft
								(not (gCast contains: egg))
								(astroChicken isNotHidden:)
							)
							(eggSquirt play:)
							(egg init:)
							(-- eggsLeft)
							(self showEggs:)
						)
					else
						(= temp0 (Min 213 (Max 87 (event x:))))
						(astroChicken setMotion: MoveTo temp0 (event y:))
					)
				)
				((== (event type:) evKEYBOARD)
					(event claimed: 1)
					(if
						(and
							(== (event message:) KEY_RETURN)
							eggsLeft
							(not (gCast contains: egg))
							(astroChicken isNotHidden:)
						)
						(eggSquirt play:)
						(egg init:)
						(-- eggsLeft)
						(self showEggs:)
					)
				)
			)
		else
			(event claimed: 1)
		)
	)

	(method (die)
		(if (not (-- livesLeft))
			(HandsOff)
			(proc816_1 290 0)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(gCurRoom newRoom: 376)
		else
			(winged dispose:)
			(gCast eachElementDo: #dispose)
			(gCurRoom drawPic: 290 style: -32762)
			(self view: 290 setCycle: Fwd init:)
			(= local28 1)
			(astroIndicator cel: (- (astroIndicator cel:) 1) init: show:)
			(gUser canControl: 1 canInput: 1)
		)
	)

	(method (showEggs &tmp [temp0 5])
		(if local1
			(proc0_12 local1)
		)
		(= local1
			(proc0_12
				(Format @temp0 {%d} eggsLeft)
				64
				180
				178
				25
				global136
				67
				25
			)
		)
	)

	(method (showPts &tmp [temp0 5])
		(if local2
			(proc0_12 local2)
		)
		(= local2
			(proc0_12 (Format @temp0 {%d} local9) 64 275 178 25 global136 67 25)
		)
	)

	(method (getEgg &tmp temp0)
		(++ eggsLeft)
		(= temp0 (Max 0 (- eggsLeft 8)))
		(self showEggs:)
	)

	(method (incScore param1 &tmp [temp0 41] temp41)
		(if (> param1 1)
			(+= local9 param1)
		else
			(= temp41 (/ y 20))
			(if param1
				(+= local9 [local15 temp41])
			else
				(+= local9 [local21 temp41])
			)
		)
		(self showPts:)
	)
)

(class ScrollActor of Sq4Actor
	(properties
		view 290
		priority 12
		signal 2064
		moveSpeed 2
		scrollSpeed 4
		deathLoop 0
		deathMusic 0
	)

	(method (init)
		(self scrollSpeed: (+ (/ (- 15 gGameSpeed) 4) 1))
		(= nsRight (= nsBottom (= nsLeft (= nsTop 0))))
		(super init:)
		(= nsLeft -1)
		(= x 350)
	)

	(method (doit)
		(super doit:)
		(cond
			((< (-= x scrollSpeed) -50)
				(self dispose:)
			)
			((and (astroChicken isNotHidden:) (self onMe: astroChicken))
				(self doChicken:)
			)
			((and (gCast contains: egg) (self onMe: egg))
				(self doEgg:)
			)
		)
	)

	(method (doChicken)
		(if (and (not (astroChicken script:)) deathLoop)
			(gLongSong stop:)
			(eggSplatting stop:)
			(theSound number: deathMusic loop: 1 play: self)
			(astroChicken hide:)
			(self setLoop: deathLoop setCel: 0 cycleSpeed: 18 setCycle: End)
		)
	)

	(method (doEgg))

	(method (cue)
		(astroChicken die:)
	)
)

(instance cedric of ScrollActor
	(properties
		x 560
		y 20
		view 272
		priority 13
	)

	(method (doit)
		(super doit:)
		(if (and (self onMe: astroChicken) (not (astroChicken script:)))
			(astroChicken setScript: killCedricScript)
		)
	)

	(method (doChicken))

	(method (cue))
)

(instance hill of ScrollActor
	(properties
		y 143
		loop 11
		cel 4
	)

	(method (init)
		(self setCel: (Random 4 5))
		(super init:)
	)
)

(instance grass of ScrollActor
	(properties
		loop 11
		cel 6
	)

	(method (init)
		(super init:)
		(= scrollSpeed (+ (/ (- 15 gGameSpeed) 4) 1 1))
		(+= x (Random 0 150))
		(= y 155)
		(self setPri: 14)
	)
)

(instance rock of ScrollActor
	(properties
		y 143
		loop 11
		cel 7
		priority 13
	)

	(method (init)
		(super init:)
		(= scrollSpeed (+ (/ (- 15 gGameSpeed) 4) 1 1))
		(+= x (Random 0 150))
		(= y 155)
		(self setPri: 14)
	)
)

(instance weasel of ScrollActor
	(properties
		illegalBits 0
		deathLoop 7
		deathMusic 55
	)

	(method (init)
		(super init:)
		(= scrollSpeed (+ (/ (- 15 gGameSpeed) 4) 1 1))
		(= loop 4)
		(= y (astroChicken y:))
		(self setCycle: Fwd)
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 0)
		(cond
			(
				(not
					(and
						(<= nsLeft (param1 x:) (- nsRight 15))
						(<= (- nsTop 5) (param1 y:) (+ nsBottom 10))
					)
				))
			((== scrollSpeed (+ (/ (- 15 gGameSpeed) 4) 1)))
			((astroChicken loop:)
				(astroChicken
					wireLeft: (- (astroChicken wireLeft:) 1)
					incScore: 5
				)
				(weasel scrollSpeed: (+ (/ (- 15 gGameSpeed) 4) 1))
				(if (not (astroChicken wireLeft:))
					(astroChicken setLoop: 0)
				)
			)
			(else
				(= temp0 1)
			)
		)
		(return temp0)
	)
)

(instance crazedFarmer of ScrollActor
	(properties
		loop 5
	)

	(method (init)
		(= loop 5)
		(if (gCast contains: hill)
			(= y 130)
		else
			(= y 143)
		)
		(super init:)
		(= local3 10)
	)

	(method (doEgg)
		(astroChicken incScore: 0)
		(eggFall stop:)
		(eggSplatting play:)
		(egg hide: dispose:)
		(self setLoop: 8 setCel: 0 setCycle: End)
	)

	(method (doit)
		(super doit:)
		(cond
			((== loop 8))
			((and (not cycler) (astroChicken isNotHidden:) (not (-- local3)))
				(self setCycle: End self)
			)
		)
		(if
			(and
				(== loop 5)
				(<= x (astroChicken x:))
				(astroChicken isNotHidden:)
			)
			(self setLoop: 6)
		)
	)

	(method (cue)
		(gunshot play:)
		((buckShot new:) init:)
		(self setCycle: Beg)
		(= local3 (Random (+ gGameSpeed 5) (+ gGameSpeed 10)))
	)

	(method (onMe param1)
		(return
			(and
				(<= nsLeft (param1 x:) nsRight)
				(<= nsTop (param1 y:) (- nsBottom 15))
			)
		)
	)
)

(instance windMill of ScrollActor
	(properties
		loop 11
	)

	(method (init)
		(super init:)
		(= y 105)
		(self setPri: 13)
		(windMillBlade init:)
	)
)

(instance windMillBlade of ScrollActor
	(properties
		deathLoop 13
		deathMusic 55
	)

	(method (init)
		(= loop 12)
		(super init:)
		(= y 105)
		(self setPri: 14 setCycle: Fwd)
	)
)

(instance cornStalk of ScrollActor
	(properties
		y 120
		loop 11
		cel 1
	)

	(method (init)
		(super init:)
	)

	(method (doChicken)
		(if (== cel 1)
			(cornPicker play:)
			(astroChicken getEgg:)
			(self setCel: 2)
		)
	)

	(method (onMe param1)
		(return
			(and
				(<= (- nsLeft 1) (param1 x:) (+ nsRight 2))
				(<= (- nsTop 10) (param1 y:) (+ nsBottom 15))
			)
		)
	)
)

(instance rabidDog of ScrollActor
	(properties
		deathLoop 10
		deathMusic 140
	)

	(method (init)
		(= loop 15)
		(= cel 0)
		(= cycleSpeed 6)
		(if (gCast contains: hill)
			(= y 130)
		else
			(= y 143)
		)
		(super init:)
	)

	(method (doChicken)
		(if (and (== loop 15) (not (astroChicken script:)) (not cycler))
			(dogBarking play:)
			(if (< (- y (astroChicken y:)) 50)
				(= local32 1)
				(theSound number: deathMusic loop: 1 play: self)
				(gCurRoom setScript: dogDieScript)
			else
				(self setCycle: End)
			)
		)
	)

	(method (doEgg)
		(if local32
			(egg hide: dispose:)
			(= local32 0)
		else
			(astroChicken incScore: 1)
			(eggFall stop:)
			(eggSplatting play:)
			(egg hide: dispose:)
			(self setLoop: 9 setCel: 0 setCycle: End)
		)
	)

	(method (cue)
		(return 0)
	)

	(method (onMe param1)
		(if (== param1 astroChicken)
			(return
				(and
					(<= (- nsLeft 15) (param1 x:) (- nsRight 25))
					(<= (- nsTop 75) (param1 y:) nsBottom)
				)
			)
		else
			(super onMe: param1 &rest)
		)
	)
)

(instance chickenWire of ScrollActor
	(properties
		y 150
		loop 11
		cel 13
	)

	(method (init)
		(self setCel: 13)
		(super init:)
	)

	(method (doChicken)
		(astroChicken setLoop: 1 wireLeft: 3)
		(self setCel: 14)
	)
)

(instance theCage of Cage
	(properties
		top 20
		left 75
		bottom 118
		right 225
	)
)

(instance astroIndicator of Sq4Prop
	(properties
		x 16
		y 185
		view 290
		loop 11
		cel 12
		priority 15
		signal 16
	)
)

(instance egg of Sq4Actor
	(properties
		view 290
		priority 13
		signal 2064
	)

	(method (init)
		(self moveSpeed: gGameSpeed)
		(super init:)
		(eggFall play:)
		(= x (astroChicken x:))
		(= y (+ (astroChicken y:) 5))
		(= local7 7)
		(= local8 1)
		(= local6 2)
		(self setLoop: 2 setCycle: Fwd)
	)

	(method (doit)
		(super doit:)
		(self posn: (+ x local7) (+ y local8))
		(if (not (-- local6))
			(-- local7)
			(++ local8)
			(if (>= y 150)
				((eggSplat new:) init:)
				(self dispose:)
			else
				(= local6 2)
			)
		)
	)
)

(instance chickenHead of Sq4Actor
	(properties
		view 271
		loop 3
		priority 13
		signal 2064
		cycleSpeed 12
		moveSpeed 1
	)

	(method (init)
		(super init:)
		(self
			posn: (astroChicken x:) (astroChicken y:)
			setCycle: Fwd
			setMotion: MoveTo (astroChicken x:) 300
		)
	)

	(method (doit)
		(super doit:)
		(self posn: (+ x local7) (+ y local8))
		(if (not (-- local6))
			(-- local7)
			(++ local8)
			(if (>= y 150)
				((eggSplat new:) init:)
				(self dispose:)
			else
				(= local6 2)
			)
		)
	)
)

(instance fallingMs of Sq4Actor
	(properties
		view 290
		priority 1
		signal 2064
		moveSpeed 1
	)

	(method (init)
		(super init:)
		(eggFall play:)
		(= x (astroChicken x:))
		(= y (astroChicken y:))
		(= view (astroChicken view:))
		(= loop (astroChicken loop:))
		(= cel (astroChicken cel:))
		(self setStep: 0 10 ignoreActors: 1)
	)
)

(instance sellOutProp of Sq4Actor
	(properties
		x 350
		y 25
		priority 14
		moveSpeed 2
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(astroChicken isNotHidden:)
				(not (astroChicken script:))
				(astroChicken onMe: self)
			)
			(gCurRoom setScript: propDieScript self)
			(self dispose:)
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance eggSplat of Sq4Actor
	(properties
		y 155
		view 290
		loop 3
		priority 12
		signal 2064
		xStep 4
	)

	(method (init)
		(super init:)
		(eggFall stop:)
		(eggSplatting play:)
		(= x (egg x:))
		(self
			xStep: (+ (/ (- 15 gGameSpeed) 4) 1)
			moveSpeed: 2
			setCycle: End
			setMotion: MoveTo -5 y self
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance buckShot of Sq4Actor
	(properties
		yStep 9
		view 290
		loop 11
		cel 3
		signal 26624
		illegalBits 0
	)

	(method (init)
		(super init:)
		(= local3 0)
		(self
			moveSpeed: gGameSpeed
			posn: (crazedFarmer x:) 108
			setMotion: MoveTo (crazedFarmer x:) -18 self
		)
	)

	(method (doit)
		(super doit:)
		(if (and (cedric onMe: self) (not (cedric loop:)) (not local33))
			(cedric cycleSpeed: 12 setLoop: 1 setCel: 0 setCycle: End)
			(= local33 1)
		)
		(if
			(and
				(astroChicken isNotHidden:)
				(astroChicken onMe: self)
				(not (astroChicken script:))
			)
			(gCurRoom setScript: buckShotDieScript self)
			(self dispose:)
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance henHouseLeft of Sq4Actor
	(properties
		x 500
		y 145
		view 290
		loop 11
		cel 8
		priority 3
		signal 18448
	)

	(method (doit)
		(super doit: &rest)
		(if (> x 169)
			(-= x 9)
		else
			(= x 160)
		)
	)
)

(instance henHouseRight of Sq4Actor
	(properties
		x 500
		y 145
		view 290
		loop 11
		cel 9
		priority 12
		signal 18448
	)

	(method (doit)
		(super doit: &rest)
		(if (> x 169)
			(-= x 9)
		else
			(= x 160)
		)
	)
)

(instance backok of Sq4Prop
	(properties
		x 100
		y 90
		view 290
		loop 14
	)
)

(instance astroChicken2 of Sq4Actor
	(properties
		view 290
		signal 2048
	)
)

(instance musicToggle of Sq4Feature
	(properties
		x 82
		y 177
		nsTop 176
		nsLeft 81
		nsBottom 188
		nsRight 117
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(or
					(== (event type:) evMOUSEBUTTON)
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_PAUSE))
				)
				(self onMe: event)
			)
			(if (gGame masterVolume:)
				(gGame masterVolume: 0)
			else
				(gGame masterVolume: local12)
			)
			(event claimed: 1)
		)
	)
)

(instance buckShotDieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gUser canControl: 0 canInput: 0)
				(gLongSong stop:)
				(eggFall stop:)
				(theSound number: 55 loop: 1 play:)
				(astroChicken
					setMotion: 0
					view: 291
					setLoop: 0
					setCycle: End self
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(astroChicken hide:)
				(fallingMs init: setMotion: MoveTo (astroChicken x:) 220 self)
			)
			(3
				(eggFall stop:)
				(eggSplatting play:)
				(ShakeScreen 2)
				(= ticks 10)
			)
			(4
				(ShakeScreen 3)
				(= seconds 2)
			)
			(5
				(eggSplatting stop:)
				(winged play: astroChicken)
				(fallingMs dispose:)
				(astroChicken die:)
				(self dispose:)
			)
		)
	)
)

(instance propDieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gUser canControl: 0 canInput: 0)
				(gLongSong stop:)
				(eggFall stop:)
				(theSound number: 55 loop: 1 play:)
				(astroChicken
					setMotion: 0
					view: 271
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(astroChicken hide:)
				(= seconds 6)
				(chickenHead init:)
			)
			(2
				(chickenHead dispose:)
				(astroChicken die:)
				(self dispose:)
			)
		)
	)
)

(instance dogDieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong stop:)
				(eggSplatting stop:)
				(astroChicken hide:)
				(rabidDog
					setLoop: 10
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(rabidDog
					view: 291
					setLoop: 1
					setCel: 0
					cycleSpeed: 3
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(2
				(rabidDog
					view: 290
					setLoop: 15
					setCel: 0
					cycleSpeed: 18
					setCycle: 0
				)
				(astroChicken die:)
				(self dispose:)
			)
		)
	)
)

(instance sellOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				((= local29 (Sq4Actor new:))
					view: 271
					posn: 381 25
					setPri: 13
					moveSpeed: 2
					setCel: 0
					setLoop: 0
					init:
					ignoreActors: 1
					setCycle: Fwd
					setMotion: MoveTo -1000 25
				)
				(sellOutProp
					view: 271
					posn: 381 25
					setLoop: 1
					init:
					ignoreActors: 1
					setCycle: Fwd
					setMotion: MoveTo -1000 25 self
				)
			)
			(1
				(local29 dispose:)
				(sellOutProp dispose:)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance startScript of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(if (== state 0)
			(= temp1 ((= temp0 (Event new:)) type:))
			(if (OneOf temp1 1 4)
				(= seconds 0)
				(= cycles 1)
			)
			(temp0 dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
				(= local10
					(proc0_12
						{"Flight of the Pullet."}
						64
						10
						127
						25
						global129
						26
						global132
					)
				)
			)
			(1
				(proc0_12 local10)
				(gCurRoom drawPic: 290 style: -32762)
				(astroChicken
					init:
					setCycle: Fwd
					observeBlocks:
					livesLeft: 3
					showEggs:
					showPts:
				)
				((astroChicken blocks:) add: theCage)
				(client setScript: 0)
			)
		)
	)
)

(instance killCedricScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local33 1)
				(theSound number: 55 loop: 1 play:)
				(cedric posn: 1000 1000 setMotion: 0)
				(astroChicken view: 272 setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(1
				(cedric
					posn: (astroChicken x:) (astroChicken y:)
					setLoop: 3
					setMotion: MoveTo (astroChicken x:) 200
				)
				(astroChicken view: 290 setLoop: 0 setCel: 0 setCycle: Fwd)
				(backok setCel: 0 init: setCycle: End)
				(= seconds 2)
			)
			(2
				(+= local9 25)
				(astroChicken showPts:)
				(backok dispose:)
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance doHenHouse of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(if (== state 5)
			(= temp1 ((= temp0 (Event new:)) type:))
			(if (OneOf temp1 1 4)
				(= seconds 0)
				(= cycles 1)
			)
			(temp0 dispose:)
		)
	)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(+= local9 (* (astroChicken eggsLeft:) 5))
				(if local2
					(proc0_12 local2)
				)
				(= local2
					(proc0_12
						(Format @temp0 {%d} local9)
						64
						275
						178
						25
						global136
						67
						25
					)
				)
				(astroChicken2 setMotion: MoveTo 100 100 self)
			)
			(1
				(astroChicken2 setMotion: MoveTo 104 129 self)
			)
			(2
				(astroChicken2 setPri: 11 setMotion: MoveTo 174 129 self)
			)
			(3
				(backok init: setCycle: End)
				(= cycles 20)
			)
			(4
				(backok dispose:)
				(= cycles 2)
			)
			(5
				(= local10
					(proc0_12
						{Congratulations, in achieving the coveted rank of "Corn-Wheezer," you have won the Pullet Surprise!}
						64
						0
						20
						25
						global129
						26
						global140
						27
						1
						67
						319
					)
				)
				(= local11
					(proc0_12
						(Format
							@temp0
							{5 X %d eggs = %d bonus points\n\nMega-Hi Score: %d}
							(astroChicken eggsLeft:)
							(* 5 (astroChicken eggsLeft:))
							local9
						)
						64
						0
						65
						25
						global129
						26
						global136
						27
						1
					)
				)
			)
			(6
				(proc0_12 local10)
				(proc0_12 local11)
				(gCurRoom newRoom: 376)
			)
		)
	)
)

