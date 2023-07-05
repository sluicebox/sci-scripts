;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm240 0
)

(local
	local0 = -1
	local1 = -1
	local2
	local3
)

(instance rm240 of Rm
	(properties
		noun 1
		picture 240
		north 260
		south 200
	)

	(method (init)
		(Load rsVIEW 240)
		(LoadMany rsSOUND 11 144 148 149 150 207)
		(= local3 gUseSortedFeatures)
		(= gUseSortedFeatures 1)
		(cond
			((not (IsFlag 1))
				(= local0 global114)
				((ScriptID 245 0) init:) ; barMagic
			)
			((not (IsFlag 3))
				(= local1 global114)
				((ScriptID 244 0) init:) ; spectrumPuzzle
			)
		)
		(fRockWall init:)
		(fComputer init:)
		(fLavaLamp init:)
		(fSkull init:)
		(fBone init:)
		(fCarrot init:)
		(fBoot init:)
		(fLavaPit init:)
		(fHook init:)
		(fDoor init:)
		(fCornCobPipe init:)
		(fLadder init:)
		(fPipes init:)
		(pLavaLamp1 init: setCycle: Fwd)
		(pLavaLamp2 init: setCycle: Fwd)
		(pLavaLamp3 init: setCycle: Fwd)
		(pSteam1 init: cel: (- (NumCels pSteam1) 1) setScript: occasionalSteam)
		(pSteam3
			init:
			cel: (- (NumCels pSteam3) 1)
			setScript: (occasionalSteam new:)
		)
		(pSteam4
			init:
			cel: (- (NumCels pSteam4) 1)
			setScript: (occasionalSteam new:)
		)
		(pFlashingButtons init: setCycle: Fwd)
		(pDoorButton init:)
		(if (not (IsFlag 1))
			(aLeftDoor init: ignoreActors: 1)
			(aRightDoor init: ignoreActors: 1)
		else
			(aLeftDoor init: cel: 0 x: 157 addToPic:)
			(aRightDoor init: cel: 0 x: 158 addToPic:)
		)
		(aBackDoor init: ignoreHorizon:)
		(gCMusic number: 11 setLoop: -1 play: 127)
		(super init: &rest)
		(if (IsFlag 1)
			(pSteam2 init: cel: (- (NumCels pSteam2) 1))
			((pSteam2 new:)
				init:
				cel: (- (NumCels pSteam2) 1)
				y: 142
				setScript: (occasionalSteam new:)
			)
			(pSteam2 setScript: (occasionalSteam new:))
			(aLeftDoor noun: 21)
			(aRightDoor noun: 21)
		)
		(if (and (IsFlag 3) (IsFlag 55))
			(aBackDoor y: (- (aBackDoor y:) 80) setScript: closeBackDoor 0 1)
		)
	)

	(method (doit)
		(Palette palANIMATE 212 218 11)
		(super doit:)
	)

	(method (dispose)
		(steamHiss dispose:)
		(doorSound dispose:)
		(if (IsObject (ScriptID 245 0)) ; barMagic
			((ScriptID 245 0) dispose:) ; barMagic
		)
		(if (IsObject (ScriptID 244 0)) ; spectrumPuzzle
			((ScriptID 244 0) dispose:) ; spectrumPuzzle
		)
		(DisposeScript 245)
		(DisposeScript 244)
		(= gUseSortedFeatures local3)
		(super dispose: &rest)
	)
)

(instance occasionalSteam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local2
					(-- state)
				)
				(= ticks (Random 150 (Random 480 660)))
			)
			(1
				(if local2
					(= state -1)
					(= cycles 1)
				else
					(if
						(and
							(== (steamHiss prevSignal:) -1)
							(== (doorSound prevSignal:) -1)
						)
						(steamHiss number: 150 setLoop: 0 play: 127)
					)
					(client startUpd: cel: 0 setCycle: End self)
				)
			)
			(2
				(client stopUpd:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance shutBothDoors of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= local2 1)
				(aBackDoor stopUpd:)
				(doorSound number: 148 setLoop: 0 play: 127)
				(aLeftDoor
					startUpd:
					cel: 0
					setMotion: MoveTo 157 (client y:) self
				)
				(aRightDoor startUpd: cel: 0 setMotion: MoveTo 158 (client y:))
			)
			(2
				(doorSound stop: number: 149 setLoop: 0 play: 127)
				(aLeftDoor stopUpd: addToPic:)
				(aRightDoor stopUpd: addToPic:)
				(pSteam2 init: cel: (- (NumCels pSteam2) 1))
				((pSteam2 new:)
					init:
					cel: (- (NumCels pSteam2) 1)
					y: 142
					setScript: (occasionalSteam new:)
				)
				(pSteam2 setScript: (occasionalSteam new:))
				(aBackDoor startUpd:)
				(aLeftDoor noun: 21)
				(aRightDoor noun: 21)
				(= local2 0)
				(self dispose:)
			)
		)
	)
)

(instance openBackDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= local2 1)
				(doorSound number: 148 setLoop: 0 play: 127)
				(client setMotion: MoveTo (client x:) (- (client y:) 80) self)
			)
			(2
				(doorSound number: 149 setLoop: 0 play: 127 self)
			)
			(3
				(if (== register 1)
					(doorSound number: 233 play: 127)
					(ShakeScreen 6 ssUPDOWN)
					(ShakeScreen 6 ssLEFTRIGHT)
					(gMessager say: 22 9 0 0 self) ; "Wow! Wonder what that was? Something may have just broken. Perhaps you should get out of here quickly. After a quake like that what could remain "stationery" on this island?"
				else
					(= cycles 1)
				)
			)
			(4
				(= local2 0)
				(SetFlag 55)
				(self dispose:)
			)
		)
	)
)

(instance closeBackDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 1)
				(doorSound number: 148 setLoop: 0 play: 127)
				(client setMotion: MoveTo (client x:) (+ (client y:) 80) self)
			)
			(1
				(doorSound number: 149 setLoop: 0 play: 127 self)
			)
			(2
				(= local2 0)
				(ClearFlag 55)
				(self dispose:)
			)
		)
	)
)

(instance depressButton of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 144 setLoop: 0 play: 127)
				(pDoorButton startUpd: setCycle: End self)
			)
			(1
				(= ticks 14)
			)
			(2
				(gCSoundFX number: 207 setLoop: 0 play: 127)
				(pDoorButton setCycle: Beg self)
			)
			(3
				(pDoorButton stopUpd:)
				(if (IsFlag 3)
					(if (> (aBackDoor y:) 86)
						(aBackDoor setScript: openBackDoor self 0)
					else
						(aBackDoor setScript: closeBackDoor self 0)
					)
				else
					(gMessager say: (pDoorButton noun:) 4 1 0 self)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance fRockWall of Feature
	(properties
		noun 13
		onMeCheck 1
	)
)

(instance fComputer of Feature
	(properties
		noun 5
		onMeCheck 2
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4
				(cond
					(
						(or
							(< local0 0)
							(not (IsObject (ScriptID 245 0))) ; barMagic
							(not ((ScriptID 245 0) inited:)) ; barMagic
						)
						((ScriptID 245 0) init:) ; barMagic
						(= local0 global114)
					)
					((!= local0 global114)
						((ScriptID 245 0) dispose: init:) ; barMagic
						(= local0 global114)
					)
				)
				(if (IsFlag 1)
					(= temp0 1)
				else
					(= temp0 0)
				)
				(switch ((ScriptID 245 0) show:) ; barMagic
					(1
						((ScriptID 245 0) dispose:) ; barMagic
						(if (not (or (IsFlag 14) temp0))
							(aLeftDoor setScript: shutBothDoors)
						)
					)
					(0 0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fLavaLamp of Feature
	(properties
		y 150
		noun 2
		onMeCheck 4
	)
)

(instance fSkull of Feature
	(properties
		noun 7
		onMeCheck 8
	)
)

(instance fBone of Feature
	(properties
		noun 8
		onMeCheck 16
	)
)

(instance fCarrot of Feature
	(properties
		noun 10
		onMeCheck 32
	)
)

(instance fBoot of Feature
	(properties
		noun 9
		onMeCheck 64
	)
)

(instance fLavaPit of Feature
	(properties
		noun 3
		onMeCheck 128
	)
)

(instance fHook of Feature
	(properties
		noun 20
		onMeCheck 256
	)
)

(instance fDoor of Feature
	(properties
		noun 23
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (IsFlag 14)
					(gCurRoom newRoom: (rm240 north:))
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fCornCobPipe of Feature
	(properties
		noun 19
		onMeCheck 1024
	)
)

(instance fPipes of Feature
	(properties
		y 180
		noun 4
		onMeCheck 2048
	)
)

(instance fLadder of Feature
	(properties
		y 180
		noun 11
		onMeCheck 4096
	)
)

(instance pLavaLamp1 of Prop
	(properties
		x 107
		y 114
		noun 2
		view 240
		loop 3
		priority 6
		signal 18450
		cycleSpeed 12
	)
)

(instance pLavaLamp2 of Prop
	(properties
		x 107
		y 114
		noun 2
		view 240
		loop 4
		priority 6
		signal 18450
		cycleSpeed 13
	)
)

(instance pLavaLamp3 of Prop
	(properties
		x 108
		y 114
		noun 2
		view 240
		loop 5
		priority 6
		signal 18450
		cycleSpeed 14
	)
)

(instance pSteam1 of Prop
	(properties
		x 63
		y 64
		noun 24
		view 240
		loop 6
		signal 18432
	)
)

(instance pSteam2 of Prop
	(properties
		x 158
		y 100
		noun 24
		view 240
		loop 8
		signal 18432
	)
)

(instance pSteam3 of Prop
	(properties
		x 259
		y 84
		noun 24
		view 240
		loop 8
		signal 18432
	)
)

(instance pSteam4 of Prop
	(properties
		x 22
		y 102
		noun 24
		view 240
		loop 7
		priority 6
		signal 18448
	)
)

(instance pFlashingButtons of Prop
	(properties
		x 58
		y 163
		noun 5
		view 240
		loop 9
		signal 18434
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(fComputer doVerb: theVerb &rest)
	)
)

(instance pDoorButton of Prop
	(properties
		x 213
		y 43
		noun 25
		nsTop 38
		nsLeft 210
		nsBottom 52
		nsRight 219
		view 240
		loop 10
		priority 6
		signal 18449
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (and (== script 0) (== (aBackDoor script:) 0))
					(self setScript: depressButton)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aBackDoor of Actor
	(properties
		x 113
		y 87
		z 80
		noun 6
		yStep 3
		view 243
		priority 5
		signal 2064
		illegalBits 0
		xStep 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not (IsFlag 1))
					(gMessager say: noun 4 1 0) ; "If you walk over to that door now, you'll fall into the lava pit."
					(return)
				)
				(cond
					(
						(or
							(< local1 0)
							(not (IsObject (ScriptID 244 0))) ; spectrumPuzzle
							(not ((ScriptID 244 0) inited:)) ; spectrumPuzzle
						)
						((ScriptID 244 0) init:) ; spectrumPuzzle
						(= local1 global114)
					)
					((!= local1 global114)
						((ScriptID 244 0) dispose: init:) ; spectrumPuzzle
						(= local1 global114)
					)
				)
				(switch ((ScriptID 244 0) show:) ; spectrumPuzzle
					(1
						((ScriptID 244 0) dispose:) ; spectrumPuzzle
						(if (not (IsFlag 14))
							(aBackDoor setScript: openBackDoor 0 1)
							(SetFlag 14)
						)
					)
					(0 0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aLeftDoor of Actor
	(properties
		x 25
		y 130
		noun 12
		yStep 1
		view 240
		loop 1
		priority 4
		signal 18448
		cycleSpeed 1
		xStep 5
		moveSpeed 1
	)

	(method (setMotion param1)
		(if (and mover (!= mover -1))
			(mover dispose:)
		)
		(if param1
			(= mover
				(if (& (param1 -info-:) $8000)
					(param1 new:)
				else
					param1
				)
			)
			(mover init: self &rest)
		else
			(= mover 0)
		)
	)
)

(instance aRightDoor of Actor
	(properties
		x 289
		y 130
		noun 12
		yStep 1
		view 240
		loop 2
		priority 4
		signal 18448
		cycleSpeed 1
		xStep 5
		moveSpeed 1
	)

	(method (setMotion param1)
		(if (and mover (!= mover -1))
			(mover dispose:)
		)
		(if param1
			(= mover
				(if (& (param1 -info-:) $8000)
					(param1 new:)
				else
					param1
				)
			)
			(mover init: self &rest)
		else
			(= mover 0)
		)
	)
)

(instance doorSound of Sound
	(properties
		prevSignal -1
	)
)

(instance steamHiss of Sound
	(properties
		prevSignal -1
	)
)

