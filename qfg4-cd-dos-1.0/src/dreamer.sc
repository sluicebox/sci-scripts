;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use GloryRm)
(use Interface)
(use Array)
(use Print)
(use Actor)
(use System)

(public
	dreamer 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(= local1 (IntArray new: 13))
	(local1 at: 0 (bubble0 init: yourself:))
	(local1 at: 1 (bubble1 init: yourself:))
	(local1 at: 2 (bubble2 init: yourself:))
	(local1 at: 3 (bubble3 init: yourself:))
	(local1 at: 4 (bubble4 init: yourself:))
	(local1 at: 5 (bubble5 init: yourself:))
	(local1 at: 6 (bubble6 init: yourself:))
	(local1 at: 7 (bubble7 init: yourself:))
	(local1 at: 8 (bubble8 init: yourself:))
	(local1 at: 9 (bubble9 init: yourself:))
	(local1 at: 10 (bubble10 init: yourself:))
	(local1 at: 11 (bubble11 init: yourself:))
	(local1 at: 12 (bubble12 init: yourself:))
)

(instance dreamer of GloryRm
	(properties)

	(method (init)
		(ClearFlag 6)
		(if gDebugging
			(= global345 (GetNumber {dreamnum}))
		)
		(SetFlag 50)
		(gNarrator modeless: 1)
		(gGlory handsOff: setCursor: gTheCursor 0)
		(gLongSong number: 110 setLoop: -1 play:)
		(switch global345
			(1
				(gCurRoom setScript: dream1)
			)
			(2
				(gCurRoom setScript: dream2)
			)
			(3
				(gCurRoom setScript: dream3)
			)
			(4
				(gCurRoom setScript: dream4)
			)
			(5
				(gCurRoom setScript: dream5)
			)
			(6
				(gCurRoom setScript: dream6)
			)
			(7
				(gCurRoom setScript: dream7)
			)
			(8
				(gCurRoom setScript: dream8)
			)
			(9
				(gCurRoom setScript: dream9)
			)
			(10
				(gCurRoom setScript: dream10)
			)
			(else
				(gCurRoom setScript: dream1)
			)
		)
		(Palette 2 0 255 0) ; PalIntensity
		(if (OneOf global345 7 9 10)
			(proc0_16)
			(proc0_13)
			(if
				(not
					(OneOf
						gCurRoomNum
						551
						552
						553
						554
						555
						556
						557
						558
						559
						560
						561
						562
						563
						564
						565
						566
						567
						568
						569
						570
						571
						572
						573
						574
						575
						576
						577
						578
						579
						580
						581
						582
						583
						584
						585
						586
						587
						588
						589
						590
						591
						592
						593
						810 ; combat
						720
						800
						632
					)
				)
				(= global470 (= gCombatMonsterNum (= global366 0)))
				(= global462 (= global463 (= global464 0)))
			)
			(= number gCurRoomNum)
			(= gPerspective picAngle)
			(if (not plane)
				(= plane gThePlane)
			)
			(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
			(RemapColors 2 254 50) ; ByPercent
		else
			(= picture 110)
			(super init: &rest)
		)
		(RemapColors 0) ; Off
		(Print modeless: 2)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if local0
			(for ((= temp0 0)) (< temp0 13) ((++ temp0))
				(if (> ((local1 at: temp0) loop:) 4)
					((local1 at: temp0)
						y:
							(if (< ((local1 at: temp0) y:) -1)
								(Random 200 230)
							else
								(- ((local1 at: temp0) y:) 1)
							)
					)
				)
			)
			(if local2
				(= local2 0)
				(for ((= temp0 0)) (< temp0 13) ((++ temp0))
					(if (< ((local1 at: temp0) loop:) 5)
						((local1 at: temp0)
							y:
								(if (< ((local1 at: temp0) y:) -1)
									(Random 225 260)
								else
									(- ((local1 at: temp0) y:) 1)
								)
						)
					)
				)
			else
				(= local2 1)
			)
		)
	)

	(method (dispose)
		(gLongSong fade:)
		(gNarrator modeless: 0)
		(ClearFlag 50)
		(UnLoad 128 110 111)
		(SetFlag 6)
		(Print modeless: 0)
		(super dispose: &rest)
	)
)

(instance dream1 of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			(local4
				(if (> register 100)
					(= local4 (= register 0))
					(self cue:)
				else
					(++ register)
					(Palette 2 0 255 register) ; PalIntensity
				)
			)
			(register
				(-- register)
				(if (not register)
					(= local3 1)
				)
				(Palette 2 0 85 register) ; PalIntensity
				(Palette 2 112 255 register) ; PalIntensity
			)
			(local3
				(= local3 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(localproc_0)
				(= local0 1)
				(= local4 1)
			)
			(1
				(= seconds 3)
			)
			(2
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 1 6 1 0 self) ; "You feel the sensation of floating freely in a swirling cloud of magic."
			)
			(3
				(SetFlag 50)
				(RemapColors 0) ; Off
				(gLongSong number: 111 setLoop: -1 play:)
				(= register 100)
			)
			(4
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 2 6 1 0 self) ; "Suddenly, you find yourself trapped by darkness."
			)
			(5
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance dream2 of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			(local4
				(if (> register 100)
					(= local4 (= register 0))
					(self cue:)
				else
					(++ register)
					(Palette 2 0 255 register) ; PalIntensity
				)
			)
			(register
				(-- register)
				(if (not register)
					(= local3 1)
				)
				(Palette 2 0 85 register) ; PalIntensity
				(Palette 2 112 255 register) ; PalIntensity
			)
			(local3
				(= local3 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(localproc_0)
				(= local0 1)
				(= local4 1)
			)
			(1
				(= seconds 3)
			)
			(2
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 1 6 2 0 self) ; "You have returned to this wonderful place between worlds."
			)
			(3
				(SetFlag 50)
				(RemapColors 0) ; Off
				(gLongSong number: 111 setLoop: -1 play:)
				(= register 100)
			)
			(4
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 2 6 2 0 self) ; "You feel a coldness rapidly devouring you. You falter in fear as you remember what happened the last time you were here."
			)
			(5
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance dream3 of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			(local4
				(if (> register 100)
					(= local4 (= register 0))
					(self cue:)
				else
					(++ register)
					(Palette 2 0 255 register) ; PalIntensity
				)
			)
			(register
				(-- register)
				(if (not register)
					(= local3 1)
				)
				(Palette 2 0 85 register) ; PalIntensity
				(Palette 2 112 255 register) ; PalIntensity
			)
			(local3
				(= local3 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(localproc_0)
				(= local0 1)
				(= local4 1)
			)
			(1
				(= seconds 3)
			)
			(2
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 1 6 3 0 self) ; "You are flying in the very source of all magic."
			)
			(3
				(SetFlag 50)
				(RemapColors 0) ; Off
				(gLongSong number: 111 setLoop: -1 play:)
				(= register 100)
			)
			(4
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 2 6 3 0 self) ; "You hear that voice calling you again."
			)
			(5
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance dream4 of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			(local4
				(if (> register 100)
					(= local4 (= register 0))
					(self cue:)
				else
					(++ register)
					(Palette 2 0 255 register) ; PalIntensity
				)
			)
			(register
				(-- register)
				(if (not register)
					(= local3 1)
				)
				(Palette 2 0 85 register) ; PalIntensity
				(Palette 2 112 255 register) ; PalIntensity
			)
			(local3
				(= local3 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(localproc_0)
				(= local0 1)
				(= local4 1)
			)
			(1
				(= seconds 3)
			)
			(2
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 1 6 4 0 self) ; "You float gently in this ocean of harmony."
			)
			(3
				(SetFlag 50)
				(RemapColors 0) ; Off
				(gLongSong number: 111 setLoop: -1 play:)
				(= register 100)
			)
			(4
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 2 6 4 0 self) ; "You are all alone."
			)
			(5
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance dream5 of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			(local4
				(if (> register 100)
					(= local4 (= register 0))
					(self cue:)
				else
					(++ register)
					(Palette 2 0 255 register) ; PalIntensity
				)
			)
			(register
				(-- register)
				(if (not register)
					(= local3 1)
				)
				(Palette 2 0 85 register) ; PalIntensity
				(Palette 2 112 255 register) ; PalIntensity
			)
			(local3
				(= local3 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(localproc_0)
				(= local0 1)
				(= local4 1)
			)
			(1
				(= seconds 3)
			)
			(2
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 1 6 5 0 self) ; "You are in this weird and wonderful place once more."
			)
			(3
				(SetFlag 50)
				(RemapColors 0) ; Off
				(gLongSong number: 111 setLoop: -1 play:)
				(= register 100)
			)
			(4
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 2 6 5 0 self) ; "You feel the Darkness surround you, and you remember dying."
			)
			(5
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance dream6 of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if local4
			(if (> register 100)
				(= local4 (= register 0))
				(self cue:)
			else
				(++ register)
				(Palette 2 0 255 register) ; PalIntensity
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Load rsVIEW 111)
				(localproc_0)
				(= local0 1)
				(= local4 1)
			)
			(1
				(= seconds 3)
			)
			(2
				(if (or (== gHeroType 3) (== gHeroType 1)) ; Paladin, Magic User
					(RemapColors 2 254 50) ; ByPercent
					(gMessager say: 1 6 7 0 self) ; "You are surrounded by warmth and friendship."
				else
					(RemapColors 2 254 50) ; ByPercent
					(gMessager say: 1 6 8 0 self) ; "You are surrounded by warmth and friendship."
				)
			)
			(3
				(SetFlag 50)
				(RemapColors 0) ; Off
				(erana init:)
				((gCurRoom plane:) drawPic: 110 12)
				(= seconds 7)
			)
			(4
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance dream7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 111 setLoop: -1 play:)
				(= seconds 4)
			)
			(1
				(RemapColors 2 254 50) ; ByPercent
				(Palette 2 0 255 100) ; PalIntensity
				(gMessager say: 2 6 9 0 self) ; "The sounds of battle rage around you. You hear once again the death screams of a hundred brave warriors and friends."
			)
			(2
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance dream8 of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			(local4
				(if (> register 100)
					(= local4 (= register 0))
					(self cue:)
				else
					(++ register)
					(Palette 2 0 255 register) ; PalIntensity
				)
			)
			(register
				(-- register)
				(if (not register)
					(= local3 1)
				)
				(Palette 2 0 85 register) ; PalIntensity
				(Palette 2 112 255 register) ; PalIntensity
			)
			(local3
				(= local3 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Load rsVIEW 111)
				(localproc_0)
				(= local0 1)
				(= local4 1)
			)
			(1
				(= seconds 3)
			)
			(2
				(erana init:)
				((gCurRoom plane:) drawPic: 110 12)
				(= seconds 4)
			)
			(3
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 1 6 10 0 self) ; "You are walking in the land of dreams, searching for something."
			)
			(4
				(SetFlag 50)
				(RemapColors 0) ; Off
				(gLongSong number: 111 setLoop: -1 play:)
				(= register 100)
			)
			(5
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 2 6 10 0 self) ; "As the vision resumes, the Darkness swallows her, and she is torn from you."
			)
			(6
				(SetFlag 50)
				(RemapColors 0) ; Off
				(for ((= temp0 0)) (< temp0 13) ((++ temp0))
					((local1 at: temp0) hide:)
				)
				(erana hide:)
				(= cycles 3)
				(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
			)
			(7
				(symbol init:)
				(= local4 1)
			)
			(8
				(= seconds 3)
			)
			(9
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance dream9 of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if local4
			(if (> register 100)
				(= local4 (= register 0))
				(self cue:)
			else
				(++ register)
				(Palette 2 0 255 register) ; PalIntensity
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 111)
				(gLongSong number: 111 setLoop: -1 play:)
				(= seconds 4)
			)
			(1
				(symbol init:)
				(= local4 1)
			)
			(2
				(= seconds 3)
			)
			(3
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 2 6 11 0 self) ; "The Darkness lies sleeping."
			)
			(4
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance dream10 of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if local4
			(if (> register 100)
				(= local4 (= register 0))
				(self cue:)
			else
				(++ register)
				(Palette 2 0 255 register) ; PalIntensity
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 111)
				(gLongSong number: 111 setLoop: -1 play:)
				(= seconds 4)
			)
			(1
				(symbol init:)
				(= local4 1)
			)
			(2
				(= seconds 3)
			)
			(3
				(RemapColors 2 254 50) ; ByPercent
				(gMessager say: 2 6 12 0 self) ; "You are walking dark halls, and you are dying."
			)
			(4
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance bubble0 of Actor
	(properties
		x 245
		y 135
		priority 10
		fixPriority 1
		view 110
		loop 9
		signal 24577
	)
)

(instance bubble1 of Actor
	(properties
		x 68
		y 74
		priority 6
		fixPriority 1
		view 110
		signal 24577
	)
)

(instance bubble2 of Actor
	(properties
		x 94
		y 46
		priority 6
		fixPriority 1
		view 110
		loop 1
		signal 24577
	)
)

(instance bubble3 of Actor
	(properties
		x 89
		y 106
		priority 6
		fixPriority 1
		view 110
		loop 2
		signal 24577
	)
)

(instance bubble4 of Actor
	(properties
		x 187
		y 31
		priority 10
		fixPriority 1
		view 110
		loop 11
		signal 24577
	)
)

(instance bubble5 of Actor
	(properties
		x 59
		y 161
		priority 6
		fixPriority 1
		view 110
		loop 4
		signal 24577
	)
)

(instance bubble6 of Actor
	(properties
		x 75
		y 142
		priority 10
		fixPriority 1
		view 110
		loop 5
		signal 24577
	)
)

(instance bubble7 of Actor
	(properties
		x 267
		y 56
		priority 10
		fixPriority 1
		view 110
		loop 6
		signal 24577
	)
)

(instance bubble8 of Actor
	(properties
		x 231
		y 67
		priority 10
		fixPriority 1
		view 110
		loop 7
		signal 24577
	)
)

(instance bubble9 of Actor
	(properties
		x 273
		y 173
		priority 10
		fixPriority 1
		view 110
		loop 8
		signal 24577
	)
)

(instance bubble10 of Actor
	(properties
		x 318
		y 102
		priority 10
		fixPriority 1
		view 110
		loop 10
		signal 24577
	)
)

(instance bubble11 of Actor
	(properties
		x 255
		y 141
		priority 6
		fixPriority 1
		view 110
		loop 3
		signal 24577
	)
)

(instance bubble12 of Actor
	(properties
		x 315
		y 8
		priority 6
		fixPriority 1
		view 110
		loop 3
		signal 24577
	)
)

(instance erana of View
	(properties
		y 1
		view 111
		signal 24576
	)
)

(instance symbol of View
	(properties
		x 153
		y 96
		view 111
		loop 2
		signal 24576
	)
)

