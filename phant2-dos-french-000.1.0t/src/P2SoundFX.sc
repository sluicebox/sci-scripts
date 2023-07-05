;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63016)
(include sci.sh)
(use Main)
(use Sound)
(use User)
(use System)

(class P2SoundFX of Sound
	(properties)

	(method (play param1 param2 param3 &tmp temp0 temp1 temp2)
		(= temp2
			(if (> argc 1)
				(Min 100 param2)
			else
				100
			)
		)
		(= temp1 (if (> argc 2) param3 else 0))
		(= temp0 (Min 127 (/ (* temp2 global236) 100)))
		(if (ResCheck 140 param1) ; WAVE
			(= number param1)
			(super play: temp1 temp0)
		else
			(PrintDebug {%d.wav not found})
			(return 0)
		)
	)

	(method (waitEvent &tmp temp0 temp1)
		(= temp1 0)
		(if (!= (DoAudio audPOSITION number) -1)
			(= temp0 (Event new:))
			(while
				(and (not (& (temp0 type:) evMOUSEBUTTON)) (!= (DoAudio audPOSITION number) -1))
				(temp0 new:)
			)
			(if (& (temp0 type:) evMOUSEBUTTON)
				(= temp1 1)
			)
			(temp0 dispose:)
		)
		(return temp1)
	)
)

(class P2SongPlyr of Sound
	(properties
		volPercent 100
		nextVol 0
		nextSong 0
		curVol 0
	)

	(method (fadeIn param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp6
			(if (> argc 1)
				(Min 100 param2)
			else
				100
			)
		)
		(= temp2 (if (> argc 2) param3 else 6))
		(= temp3 (if (> argc 3) param4 else 10))
		(= temp4 (if (> argc 4) param5 else 1))
		(= temp5 (if (> argc 5) param6 else 0))
		(= temp7 (gUser canInput:))
		(gGame handsOff:)
		(self volPercent: temp6)
		(= temp1 (self getVol: temp6))
		(if (self isPlaying:)
			(if (== number param1)
				(if temp7
					(gGame handsOn:)
				)
				(return 0)
			)
			(self fadeOut: 0)
		)
		(= prevSignal 0)
		(Load 140 param1) ; WAVE
		(Lock 140 param1 1) ; WAVE
		(= number param1)
		(= nextVol (= nextSong 0))
		(if temp4
			(self loop: -1)
			(self play: param1 0 0)
		else
			(self loop: 0)
			(self play: param1 temp5 0)
		)
		(if temp5
			(gCast add: P2SoundCheck)
		)
		(self fade: temp1 temp2 temp3 0 temp5)
		(self wait4Fade: temp2 temp3)
		(= vol (= curVol temp1))
		(return (and temp7 (gGame handsOn:)))
	)

	(method (start param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp6
			(if (> argc 1)
				(Min 100 param2)
			else
				100
			)
		)
		(= temp2 (if (> argc 2) param3 else 6))
		(= temp3 (if (> argc 3) param4 else 10))
		(= temp4 (if (> argc 4) param5 else 1))
		(= temp5 (if (> argc 5) param6 else 0))
		(= volPercent temp6)
		(= temp1 (self getVol: volPercent))
		(if (self isPlaying:)
			(if (== number param1)
				(return 0)
			)
			(self stop:)
			(Lock 140 number 0) ; WAVE
			(UnLoad 140 number)
		)
		(= prevSignal 0)
		(Load 140 param1) ; WAVE
		(Lock 140 param1 1) ; WAVE
		(= number param1)
		(if temp4
			(self loop: -1)
			(self play: param1 0 temp1)
		else
			(self loop: 0)
			(self play: param1 temp5 temp1)
		)
		(if temp5
			(gCast add: P2SoundCheck)
		)
		(return (self setVol: temp1))
	)

	(method (fadeTo param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(if (or (== param1 volPercent) (not (self isPlaying:)))
			(return 0)
		)
		(= temp2
			(if (> argc 0)
				(Min 100 param1)
			else
				100
			)
		)
		(= temp0 (if (> argc 1) param2 else 6))
		(= temp1 (if (> argc 2) param3 else 10))
		(= volPercent temp2)
		(= temp3 (self getVol: volPercent))
		(self fade: temp3 temp0 temp1 0)
		(self wait4Fade: temp0 temp1)
		(return (= vol (= curVol temp3)))
	)

	(method (fadeOut param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 [temp4 2] temp6)
		(= temp0 (if (> argc 0) param1 else 0))
		(= temp1 (if (> argc 1) param2 else 1))
		(= temp2 (if (> argc 2) param3 else 9))
		(= temp3 (if (> argc 3) param4 else 10))
		(= temp6 (gUser canInput:))
		(gGame handsOff:)
		(self fade: 0 temp2 temp3 (not temp0))
		(self wait4Fade: temp2 temp3)
		(if temp0
			(self pause: temp1)
			(= volPercent 0)
		else
			(self stop:)
		)
		(if temp6
			(gGame handsOn:)
		)
	)

	(method (play param1 param2 param3 &tmp temp0 temp1)
		(= temp1 (if (> argc 1) param2 else 0))
		(= temp0 (if (> argc 2) param3 else global236))
		(= prevSignal 0)
		(= number param1)
		(if temp1
			(gCast add: P2SoundCheck)
		)
		(if (> temp0 global236)
			(= temp0 global236)
		)
		(super play: temp1 temp0)
		(= curVol temp0)
	)

	(method (check)
		(if handle
			(DoSound sndUPDATE_CUES self)
		)
		(if signal
			(= prevSignal signal)
			(= signal 0)
			(if client
				(gCast delete: P2SoundCheck)
				(self stop:)
				(client cue: self)
			)
		)
	)

	(method (fade param1)
		(super fade: param1 &rest)
		(= vol (= curVol param1))
	)

	(method (stop)
		(super stop: &rest)
		(= curVol 0)
		(= volPercent 100)
		(gCast delete: P2SoundCheck)
		(Lock 140 number 0) ; WAVE
		(UnLoad 140 number)
	)

	(method (wait4Fade param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp2 (if (> argc 0) param1 else 6))
		(= temp3 (if (> argc 1) param2 else 10))
		(= temp0 (* temp2 temp3))
		(= temp1 (GetTime))
		(while (< (Abs (- (GetTime) temp1)) temp0)
		)
	)

	(method (isPlaying &tmp temp0)
		(= temp0 (and handle (!= prevSignal -1)))
	)

	(method (setVol)
		(super setVol: (= curVol (self getVol: volPercent)))
	)

	(method (getVol param1)
		(Min 127 (/ (* param1 global236) 100))
	)
)

(class P2SoundCheck of Code
	(properties)

	(method (doit)
		(gSounds check:)
	)
)

