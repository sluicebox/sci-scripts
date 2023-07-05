;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4001)
(include sci.sh)
(use Main)
(use ExitButton)
(use Talker)
(use Scaler)
(use PolyPath)
(use Rev)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	OogaBooga 0
	wakeTheDead 1
	myReturnTimer 2
	myBoogeyMan 3
	diggerComes 4
	boogeyShowTimer 5
	firecrackerTimer 6
	diggerTalker 7
	boogeyTalker 8
)

(local
	local0
	local1
	local2
	local3
)

(class OogaBooga of Rgn
	(properties
		number 4001
		keep 1
		blowCount 0
		underWearCntr 0
	)

	(method (init)
		(super init: &rest)
		(boogeyShowTimer setReal: boogeyShowTimer (Random 30 50))
	)

	(method (newRoom newRoomNumber)
		(self setScript: 0)
		(if (gCast contains: myBoogeyMan)
			(myBoogeyMan dispose:)
		)
		(= keep
			(OneOf
				newRoomNumber
				4350
				4400
				4050
				4000
				4101
				4102
				4200
				4250
				4300
				4600
				4500
				4550
				4650
				4450
				4700
			)
		)
		(boogeyShowTimer setReal: boogeyShowTimer (Random 30 50))
	)

	(method (cue)
		(super cue:)
		(if
			(and
				(not script)
				(not (gCurRoom script:))
				(gCast contains: gEgo)
				(gUser canControl:)
				(not (OneOf gCurRoomNum 4010 4600 4700))
			)
			(if
				(OneOf
					gCurRoomNum
					4350
					4400
					4050
					4000
					4101
					4102
					4200
					4250
					4300
					4600
					4500
					4550
					4650
					4450
					4700
				)
				(if (IsFlag 170)
					(ClearFlag 170)
					(self setScript: dropOnEgo)
				)
			else
				(if (== gChapter 4)
					(gMessager say: 1 8 21 0 0 4200) ; "(AS A SCARAB)Rosella, we must hurry! Let's resume our journey!"
				)
				(ClearFlag 5)
				(ClearFlag 170)
			)
		)
	)

	(method (doVerb))

	(method (dispose)
		(boogeyShowTimer client: 0 delete: dispose:)
		(myReturnTimer client: 0 delete: dispose:)
		(firecrackerTimer client: 0 delete: dispose:)
		(self setScript: 0)
		(super dispose:)
	)
)

(instance wakeTheDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 4450 1) client: 0 delete: dispose:) ; malTimer
				(Load rsVIEW 4355)
				(Load rsSOUND 4358)
				(if (!= (gEgo heading:) 90)
					(gEgo setHeading: 90 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo view: 4355 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo setLoop: 1 1 setCel: 0)
				(gKqMusic1 stop:)
				(gSounds eachElementDo: #pause 1)
				(= cycles 6)
			)
			(3
				(sndEffect number: 4358 loop: 1 play: self)
				(gEgo view: 4355 setLoop: 1 1 setCel: 0 setCycle: CT 2 1)
			)
			(4
				(gEgo loop: 1 1 cel: 2 setCycle: End self)
			)
			(5
				(gEgo normalize: 0)
				(= cycles 2)
			)
			(6
				(gMessager say: 0 0 1 0 self 4001) ; "WHO DARES DISTURB MY SLEEP?"
			)
			(7
				(Load rsSOUND 4401)
				(Load 140 4402) ; WAVE
				(= cycles 6)
			)
			(8
				(if (gEgo scaler:)
					(thePoof setScaler: gEgo)
				)
				(thePoof
					view: 4355
					setLoop: 3 1
					setCel: 0
					posn: (+ (gEgo x:) 8) (+ (gEgo y:) 1)
					setPri: (+ (gEgo priority:) 1)
					init:
					setCycle: End self
				)
				(sfx number: 4401 loop: 1 play:)
				(sfx number: 4402 loop: 1 play:)
			)
			(9
				(gEgo hide:)
				(thePoof
					view: 4355
					setLoop: 4 1
					setCel: 0
					posn: (+ (gEgo x:) 8) (+ (gEgo y:) 1)
					setPri: (+ (gEgo priority:) 1)
					setCycle: End self
				)
			)
			(10
				(thePoof dispose:)
				(EgoDead 65 self)
			)
			(11
				(gEgo show:)
				(ClearFlag 5)
				(= global374 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance diggerComes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (= scratch (IsFlag 192)))
					(SetFlag 192)
				)
				(theDigger view: 43550 setCel: 0 init: hide:)
				(if (> (gEgo x:) 165)
					(gEgo setMotion: PolyPath 150 (gEgo y:) self)
				else
					(= cycles 1)
				)
			)
			(1
				(Load rsVIEW 4355)
				(if (!= (gEgo heading:) 90)
					(gEgo setHeading: 90 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo view: 4355 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(3
				(Load rsSOUND 4358)
				(gEgo setLoop: 1 1 setCel: 0)
				(gKqMusic1 stop:)
				(gSounds eachElementDo: #pause 1)
				(= cycles 6)
			)
			(4
				(sndEffect number: 4358 loop: 1 play: self)
				(gEgo setLoop: 1 1 setCel: 0 setCycle: CT 2 1)
			)
			(5
				(gEgo loop: 1 1 cel: 2 setCycle: End self)
			)
			(6
				(gEgo normalize: 0)
				(= cycles 2)
			)
			(7
				(Load rsSOUND 4091)
				(= cycles 6)
			)
			(8
				(sfx number: 4092 loop: -1 play:)
				(sfx2 number: 4091 loop: -1 play:)
				(= cycles 6)
			)
			(9
				(switch gCurRoomNum
					(4000
						(theDigger y: 107)
						(= register 225)
					)
					(4050
						(theDigger y: 109)
						(= register 222)
					)
					(4250
						(theDigger y: 144)
						(= register 203)
					)
					(4350
						(theDigger y: 103)
						(= register 203)
					)
					(4400
						(theDigger y: 134)
						(= register 203)
					)
					(else
						(theDigger y: 134)
						(= register 170)
					)
				)
				(if (gEgo scaler:)
					(theDigger setScaler: gEgo)
				)
				(theDigger
					setLoop: 1 1
					x: 319
					setCel: 0
					setCycle: Fwd
					show:
					setMotion: MoveTo register (theDigger y:) self
				)
			)
			(10
				(theDigger setCel: 0 setCycle: End self)
			)
			(11
				(sfx stop:)
				(theDigger setCel: 3)
				(if (IsFlag 171)
					(gMessager say: 1 65 2 3 self 4001) ; "(EXAPERATED)Geez, lady, call me when you know what you want. And don't blow that horn too often! It's enough to wake the dead!"
				else
					(gMessager say: 1 65 2 0 self 4001) ; "Where do you want me to dig?"
				)
			)
			(12
				(sfx play:)
				(theDigger
					setLoop: 1 1
					setCycle: Rev
					setMotion: MoveTo 319 (theDigger y:) self
				)
			)
			(13
				(sfx stop:)
				(sfx2 stop:)
				(gSounds eachElementDo: #pause 0)
				(gEgo normalize: 0)
				(gKqMusic1 play:)
				(theDigger dispose:)
				(gGame handsOn:)
				(if (not scratch)
					(ClearFlag 192)
				)
				(self dispose:)
			)
		)
	)
)

(instance reactToBoogey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (client register:))
					(gGame handsOff:)
				)
				(gEgo setMotion: 0)
				(proc11_3 gEgo myBoogeyMan self)
			)
			(1
				(if (== (gEgo loop:) (- (NumLoops gEgo) 1))
					(= register (gEgo cel:))
				else
					(= register (gEgo loop:))
				)
				(switch register
					(0
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8681 loop: 0)
						else
							(gEgo view: 8341 loop: 0)
						)
					)
					(1
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8681 loop: 1)
						else
							(gEgo view: 8341 loop: 1)
						)
					)
					(2
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8682 loop: 0)
						else
							(gEgo view: 8342 loop: 0)
						)
					)
					(3
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8683 loop: 0)
						else
							(gEgo view: 8343 loop: 0)
						)
					)
					(4
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8684 loop: 0)
						else
							(gEgo view: 8344 loop: 0)
						)
					)
					(5
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8684 loop: 1)
						else
							(gEgo view: 8344 loop: 1)
						)
					)
					(6
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8685 loop: 0)
						else
							(gEgo view: 8345 loop: 0)
						)
					)
					(7
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8685 loop: 1)
						else
							(gEgo view: 8345 loop: 1)
						)
					)
				)
				(gEgo cel: 0 setCycle: End self)
				(sfx2 number: 4402 setLoop: 1 play:)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize:)
				(if (not (client register:))
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance boogeyManScript of Script
	(properties)

	(method (doit)
		(if
			(and
				(gUser canControl:)
				(< (myBoogeyMan distanceTo: gEgo) 50)
			)
			(gEgo setMotion: 0)
			(= register 1)
			(gGame handsOff:)
		)
		(if (and seconds (not (gUser canControl:)))
			(= seconds 0)
			(= cycles 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo disableHotspot:)
				(if (gEgo has: 53) ; Magic_Wand
					((gInventory at: 53) deleteHotVerb: 74) ; Magic_Wand, Scarab
					((gInventory at: 55) deleteHotVerb: 69) ; Scarab, Magic_Wand
				)
				(gSounds eachElementDo: #pause 1)
				(sfx number: 4355 setLoop: 1 setVol: 0 play: fade: 127 4 2 0)
				(myBoogeyMan init: setCycle: End self)
				(if (< (myBoogeyMan loop:) 2)
					(sfx2 number: 908 setLoop: 1 play:)
				)
				(= ticks 45)
			)
			(1
				(cond
					((and (not register) (not (gUser canControl:)))
						(myBoogeyMan setScript: abortScript)
						(self dispose:)
					)
					((or (== gChapter 5) (not (IsFlag 151)))
						(self setScript: reactToBoogey self)
					)
					(else
						(if (and (!= gChapter 5) (IsFlag 151))
							(gGame handsOff:)
						)
						(gEgo setMotion: 0)
						(proc11_3 gEgo myBoogeyMan self)
					)
				)
			)
			(2)
			(3
				(if (and (!= gChapter 5) (IsFlag 151))
					(if (not (IsFlag 199))
						(SetFlag 199)
						(gMessager say: 0 0 3 0 self 4001) ; "(SLOBBERING AND LEERING)Well hello, my lovely lady Tsepish! Have you decided to leave your headless husband and run away with me yet?"
					else
						(self cue:)
					)
				else
					(+= state 2)
					(if (< (myBoogeyMan distanceTo: gEgo) 50)
						(self cue:)
					else
						(myBoogeyMan setHotspot: 8 10) ; Do, Exit
						(= seconds 15)
					)
				)
			)
			(4
				(sfx number: 4353 setLoop: 1 play:)
				(myBoogeyMan
					view: 43510
					loop: (if (< (myBoogeyMan x:) (gEgo x:)) 0 else 1)
					cel: 0
					setCycle: End self
				)
			)
			(5
				(myBoogeyMan dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
			(6
				(if
					(or
						(and (not register) (not (gUser canControl:)))
						(IsFlag 192)
						(gCurRoom script:)
					)
					(myBoogeyMan setScript: abortScript)
					(self dispose:)
				else
					(self setScript: pounceScript self)
				)
			)
			(7
				(myBoogeyMan dispose:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(ClearFlag 338)
		(gEgo enableHotspot:)
		(if (gEgo has: 53) ; Magic_Wand
			((gInventory at: 53) addRespondVerb: 74) ; Magic_Wand, Scarab
			((gInventory at: 55) addRespondVerb: 69) ; Scarab, Magic_Wand
		)
		(sfx stop:)
		(sfx2 stop:)
		(gSounds eachElementDo: #pause 0)
		(super dispose:)
	)
)

(instance abortScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myBoogeyMan
					view: 43510
					loop: (if (< (myBoogeyMan x:) (gEgo x:)) 0 else 1)
					cel: 0
					setCycle: End self
				)
			)
			(1
				(myBoogeyMan dispose:)
				(self dispose:)
			)
		)
	)
)

(instance pounceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(myBoogeyMan
					view: 43510
					loop: (if (< (myBoogeyMan x:) (gEgo x:)) 0 else 1)
					cel: 0
					setCycle: End self
				)
				(sfx
					number:
						(switch (Random 0 2)
							(0 4353)
							(1 4501)
							(2 4502)
						)
					setLoop: 1
					play:
				)
				(gEgo
					setMotion: 0
					setHeading:
						(GetAngle
							(gEgo x:)
							(gEgo y:)
							(myBoogeyMan x:)
							(myBoogeyMan y:)
						)
				)
				(= ticks 60)
			)
			(1
				(sfx2 number: 4354 setLoop: 1 play:)
			)
			(2
				(myBoogeyMan
					x: (gEgo x:)
					y: (- (gEgo y:) 1)
					setPri: (gEgo priority:)
					loop: (+ (myBoogeyMan loop:) 2)
					cel: 0
					setCycle: End self
				)
				(if (gEgo scaler:)
					(myBoogeyMan setScaler: gEgo)
				else
					(myBoogeyMan
						scaleSignal: (gEgo scaleSignal:)
						scaleX: (gEgo scaleX:)
						scaleY: (gEgo scaleY:)
					)
				)
			)
			(3
				(sfx number: 4402 setLoop: 1 play:)
				(gEgo hide:)
				(if (== gValOrRoz -3) ; Roz
					(myBoogeyMan
						view: 43512
						loop: (if (== (myBoogeyMan loop:) 2) 0 else 1)
						cel: 0
						setCycle: End self
					)
				else
					(myBoogeyMan
						view: 43511
						loop: (if (== (myBoogeyMan loop:) 2) 0 else 1)
						cel: 0
						setCycle: End self
					)
				)
			)
			(4
				(if (== gValOrRoz -3) ; Roz
					(EgoDead 19 self)
				else
					(EgoDead 57 self)
				)
			)
			(5
				(gSounds eachElementDo: #pause 0)
				(ClearFlag 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dropOnEgo of Script
	(properties)

	(method (dispose)
		(ClearFlag 5)
		(gEgo show: posn: local0 local1 get: 55 normalize: 2) ; Scarab
		(if (and (== gCurRoomNum 4101) (not (IsFlag 219)))
			((ScriptID 4101 3) play:) ; WIBWeeps
		)
		(gKqMusic1 play:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (== gCurRoomNum 4101) (not (IsFlag 219)))
					((ScriptID 4101 3) stop:) ; WIBWeeps
				)
				(switch gCurRoomNum
					(4000
						(= local2 144)
						(= local3 115)
					)
					(4050
						(= local2 173)
						(= local3 128)
					)
					(4101
						(= local2 270)
						(= local3 122)
					)
					(4102
						(= local2 185)
						(= local3 129)
					)
					(4110
						(= local2 187)
						(= local3 138)
					)
					(4200
						(= local2 159)
						(= local3 186)
					)
					(4250
						(= local2 91)
						(= local3 127)
					)
					(4300
						(= local2 232)
						(= local3 95)
					)
					(4350
						(= local2 227)
						(= local3 100)
					)
					(4400
						(= local2 162)
						(= local3 119)
					)
					(4450
						(= local2 260)
						(= local3 117)
					)
					(4500
						(= local2 223)
						(= local3 132)
					)
					(4550
						(= local2 207)
						(= local3 107)
					)
					(4650
						(= local2 142)
						(= local3 120)
					)
					(else
						(= local2 160)
						(= local3 140)
					)
				)
				(thePoof view: 4503)
				(theGargoyle view: 4132)
				(theTroll view: 41114)
				(theTroll init: hide:)
				(thePoof init: hide:)
				(theGargoyle init: hide:)
				(if (gEgo scaler:)
					(theGargoyle setScaler: gEgo)
					(theTroll setScaler: gEgo)
				)
				(if (IsFlag 151)
					(Load rsVIEW 41115)
					(Load rsVIEW 41325)
				else
					(Load rsVIEW 41114)
				)
				(Load rsSOUND 5230)
				(Load rsSOUND 4409)
				(gEgo setHeading: 270)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: PolyPath local2 local3 self)
			)
			(2
				(= local0 (gEgo x:))
				(= local1 (gEgo y:))
				(if (IsFlag 151)
					(gEgo view: 41115)
				else
					(gEgo view: 41114)
				)
				(gEgo
					setLoop: 5 1
					setCel: 0
					posn: (- local0 2) (+ local1 2)
					setCycle: CT 5 1 self
				)
			)
			(3
				(sfx number: 5230 loop: 1 play:)
				(sfx2 number: 4409 loop: 1 play:)
				(theTroll
					loop: 6
					cel: 0
					posn: (- local0 50) local1
					setPri: (+ (gEgo priority:) 1)
					show:
					setCycle: End self
				)
				(gEgo setLoop: 5 1 cel: 5 setCycle: End)
			)
			(4
				(theTroll view: 4132)
				(theTroll
					loop: 3
					cel: 0
					posn: (- local0 53) (- local1 2)
					setCycle: End self
				)
			)
			(5
				(Load 140 816) ; WAVE
				(Load rsSOUND 818)
				(= cycles 4)
			)
			(6
				(sfx number: 816 loop: 1 play:)
				(theTroll cel: (theTroll cel:) setCycle: Beg)
				(thePoof
					loop: 0
					cel: 0
					posn: (- local0 9) local1
					setPri: (+ (gEgo priority:) 2)
					show:
					setCycle: CT 4 1 self
				)
			)
			(7
				(thePoof loop: 0 cel: 4 setCycle: CT 8 1)
				(theGargoyle
					loop: 2
					cel: 0
					posn: (- local0 6) (+ local1 4)
					show:
					setCycle: Fwd
				)
				(if (IsFlag 151)
					(gEgo view: 41325)
				else
					(gEgo view: 4132)
				)
				(gEgo
					setLoop: 1 1
					cel: 0
					posn: (- local0 4) (+ local1 2)
					setCycle: End self
				)
				(sfx number: 818 loop: 1 play:)
			)
			(8
				(Load rsSOUND 865)
				(thePoof dispose:)
				(= cycles 4)
			)
			(9
				(if (IsFlag 151)
					(theGargoyle view: 41325 loop: 2)
				else
					(theGargoyle loop: 5)
				)
				(theGargoyle
					posn: (- local0 8) (+ local1 4)
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(10
				(gKqMusic1 stop:)
				(sfx number: 865 loop: 1 play:)
				(gEgo hide:)
				(theGargoyle
					posn: (- local0 8) (+ local1 4)
					cel: 4
					setCycle: End self
				)
			)
			(11
				(theTroll dispose:)
				(theGargoyle dispose:)
				(gEgo show: setCycle: 0)
				(EgoDead 29 self)
			)
			(12
				(ClearFlag 5)
				(cond
					((and (not (IsFlag 219)) (== gCurRoomNum 4101))
						((ScriptID 4101 3) play:) ; WIBWeeps
					)
					((== gCurRoomNum 4450)
						((ScriptID 4450 1) setReal: (ScriptID 4450 1) 300) ; malTimer, malTimer
					)
				)
				(gEgo show: posn: local0 local1 get: 55 normalize: 2) ; Scarab
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theDigger of Actor
	(properties)
)

(instance myBoogeyMan of Actor
	(properties
		x 160
		y 135
		view 4350
	)

	(method (init)
		(if (gEgo scaler:)
			(self setScaler: gEgo)
		else
			(self
				scaleSignal: (gEgo scaleSignal:)
				scaleX: (gEgo scaleX:)
				scaleY: (gEgo scaleY:)
			)
		)
		(self setPri: -1)
		(switch gCurRoomNum
			(4000
				(if (< (gEgo x:) 160)
					(self view: 4352 loop: 0 cel: 0 x: 295 y: 115)
				else
					(self view: 4352 loop: 1 cel: 0 x: 45 y: 124)
				)
			)
			(4050
				(cond
					((and (gEgo scaler:) (== ((gEgo scaler:) backY:) 76))
						(self view: 4352 loop: 1 cel: 0 x: 178 y: 66)
					)
					((< (gEgo x:) 160)
						(self view: 4352 loop: 0 cel: 0 x: 259 y: 135)
					)
					(else
						(self view: 4352 loop: 1 cel: 0 x: 66 y: 124)
					)
				)
			)
			(4400
				(switch (Random 0 4)
					(0
						(if (< (gEgo x:) 100)
							(self view: 4352 loop: 4 cel: 0 x: 114 y: 78)
						else
							(self view: 4352 loop: 5 cel: 0 x: 67 y: 84)
						)
					)
					(1
						(if (< (gEgo x:) 125)
							(self view: 4352 loop: 5 cel: 0 x: 109 y: 68)
						else
							(self view: 4352 loop: 4 cel: 0 x: 144 y: 68)
						)
					)
					(else
						(cond
							((> (gEgo y:) 130)
								(self view: 4352 loop: 0 cel: 0 x: 284 y: 130)
							)
							((> (gEgo y:) 113)
								(self view: 4352 loop: 1 cel: 0 x: 28 y: 113)
							)
							((< (gEgo x:) 130)
								(self view: 4352 loop: 0 cel: 0 x: 174 y: 64)
							)
							(else
								(self view: 4352 loop: 1 cel: 0 x: 75 y: 63)
							)
						)
					)
				)
			)
			(4101
				(if (< (gEgo x:) 160)
					(self view: 4352 loop: 0 cel: 0 x: 320 y: 116)
				else
					(self view: 4352 loop: 1 cel: 0 x: 65 y: 112)
				)
			)
			(4102
				(if (< (gEgo x:) 160)
					(self
						view: 4352
						loop: 0
						cel: 0
						x: (+ (gEgo x:) (Random 60 120))
					)
					(if (< y 605)
						(= y (Random 140 145))
					else
						(= y (Random 120 140))
					)
				else
					(self
						view: 4352
						loop: 1
						cel: 0
						x: (- (gEgo x:) (Random 60 120))
						y: (Random 140 145)
					)
				)
			)
			(4650
				(if (< (gEgo x:) 120)
					(self view: 4352 loop: 0 cel: 0 x: 179 y: 132)
				else
					(self view: 4352 loop: 1 cel: 0 x: 39 y: 105)
				)
			)
			(4250
				(if (> (gEgo x:) 50)
					(if (> (gEgo y:) 130)
						(self x: 40 y: 136)
					else
						(self x: 44 y: 111)
					)
				else
					(self x: 157 y: 140)
				)
				(self view: 4352 loop: (if (< x (gEgo x:)) 1 else 0) cel: 0)
			)
			(else
				(self posn:)
				(self view: 4352 loop: (if (< x (gEgo x:)) 1 else 0) cel: 0)
			)
		)
		(super init:)
	)

	(method (posn &tmp temp0 temp1)
		(cond
			(argc
				(super posn: &rest)
			)
			((= temp0 (gCurRoom obstacles:))
				(while 1
					(= x (Random (- (gEgo x:) 150) (+ (gEgo x:) 150)))
					(= y (Random (- (gEgo y:) 60) (+ (gEgo y:) 60)))
					(if
						(and
							(> (self distanceTo: gEgo) 40)
							(temp0 firstTrue: #onMe (- x 10) y)
							(temp0 firstTrue: #onMe x (- y 15))
							(temp0 firstTrue: #onMe x y)
						)
						(break)
					)
				)
			)
			(else
				(= x (Random (- (gEgo x:) 80) (+ (gEgo x:) 80)))
				(= y (Random (- (gEgo y:) 20) (+ (gEgo y:) 20)))
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if
					(and
						(== (boogeyManScript state:) 5)
						(boogeyManScript seconds:)
					)
					(boogeyManScript seconds: 0 cue:)
				)
			)
		)
	)
)

(instance theTroll of Prop
	(properties
		view 41114
	)
)

(instance theGargoyle of Prop
	(properties)
)

(instance thePoof of Prop
	(properties)
)

(instance sfx of Sound
	(properties)
)

(instance sndEffect of Sound
	(properties)
)

(instance myReturnTimer of Timer
	(properties)

	(method (cue)
		(if (== gCurRoom 4450)
			(SetFlag 474)
			(gCurRoom cue:)
		else
			(self client: 0 delete: dispose:)
		)
	)
)

(instance boogeyShowTimer of Timer
	(properties)

	(method (setReal param1)
		(if (and param1 (param1 respondsTo: #timer) (param1 timer:))
			((param1 timer:) dispose:)
			(param1 timer: 0)
		)
		(super setReal: param1 &rest)
	)

	(method (doit)
		(if
			(and
				(gUser canControl:)
				(not (gCurRoom script:))
				(not (OogaBooga script:))
			)
			(super doit:)
		)
	)

	(method (cue)
		(if
			(or
				(IsFlag 192)
				(gEgo script:)
				(gCurRoom script:)
				(OogaBooga script:)
				(and (== gCurRoomNum 4101) (== gValOrRoz -3) (IsFlag 151)) ; Roz
			)
			0
		else
			(OogaBooga setScript: boogeyManScript)
		)
		(if (and (== gChapter 4) (IsFlag 151))
			(self setReal: self (Random 200 300))
		else
			(self setReal: self (Random 30 50))
		)
	)
)

(instance firecrackerTimer of Timer
	(properties)

	(method (cue)
		(if (and (not (gCurRoom script:)) (gUser canInput:))
			(gCurRoom setScript: sFirecrackerBlowUp)
		else
			(self setCycle: self 12000)
		)
	)
)

(instance sFirecrackerBlowUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= scratch (User canControl:))
				(gGame handsOff:)
				(gEgo setMotion: 0 setHeading: 180)
				((= register (Prop new:))
					view: 9000
					setLoop: 0
					setCel: 0
					posn: (gEgo x:) (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					init:
					setCycle: CT 10 1 self
				)
				(if (gEgo scaler:)
					(register
						setScaler:
							Scaler
							((gEgo scaler:) frontSize:)
							((gEgo scaler:) backSize:)
							((gEgo scaler:) frontY:)
							((gEgo scaler:) backY:)
					)
				)
				(oogaSound number: 41093 setLoop: 1 play:)
			)
			(1
				(gEgo z: 1000)
				(register setCycle: End self)
			)
			(2
				(EgoDead 35 self)
			)
			(3
				(register dispose:)
				(gEgo z: 0)
				(gGame handsOn:)
				(User canControl: scratch)
				(firecrackerTimer setCycle: firecrackerTimer 12000)
				(self dispose:)
			)
		)
	)
)

(instance sfx2 of Sound
	(properties)
)

(instance oogaSound of Sound
	(properties)
)

(instance boogeyTalker of KQTalker
	(properties
		view 4352
		clientCel -1
	)

	(method (init)
		(= client myBoogeyMan)
		(super init: &rest)
	)
)

(instance diggerTalker of KQTalker
	(properties
		clientCel -1
	)

	(method (init)
		(= client theDigger)
		(super init: &rest)
	)
)

