;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64031)
(include sci.sh)
(use Main)
(use Talker)
(use Sound)
(use System)

(public
	SetMusicVol 0
	SetSFXVol 1
	SetAudioVol 2
)

(procedure (SetMusicVol nVol &tmp oSound node)
	(= gMusicVol nVol)
	(for ((= node (gSounds first:))) node ((= node (gSounds next: node)))
		(= oSound (KList 8 node)) ; NodeValue
		(if (oSound respondsTo: #reSyncVol)
			(oSound reSyncVol:)
		)
	)
)

(procedure (SetSFXVol nVol &tmp oSound node)
	(= gSFXVol nVol)
	(for ((= node (gSounds first:))) node ((= node (gSounds next: node)))
		(= oSound (KList 8 node)) ; NodeValue
		(if (oSound respondsTo: #reSyncVol)
			(oSound reSyncVol:)
		)
	)
)

(procedure (SetAudioVol nVol &tmp oSound node)
	(= gAudioVol nVol)
	(for ((= node (gSounds first:))) node ((= node (gSounds next: node)))
		(= oSound (KList 8 node)) ; NodeValue
		(if (oSound respondsTo: #reSyncVol)
			(oSound reSyncVol:)
		)
	)
)

(class TPSound of Sound
	(properties
		type 0
		relVolPercent 100
		audModNum 0
		audNoun 0
		audVerb 0
		audCase 0
		audSequence 0
		audTicks -1
		saveTime 0
		oSubtitle 0
	)

	(method (fadeIn nSound npTicks npSteps opFadeCuee bpLoop opEndCuee &tmp nTicks nSteps oFadeCuee bLoop oEndCuee)
		(= nTicks (if (> argc 1) npTicks else 6))
		(= nSteps (if (> argc 2) npSteps else 10))
		(= oFadeCuee (if (> argc 3) opFadeCuee else 0))
		(= bLoop
			(cond
				((> argc 4) bpLoop)
				((== type 1) 1)
				(else 0)
			)
		)
		(= oEndCuee (if (> argc 5) opEndCuee else 0))
		(self stop:)
		(self newSound: nSound)
		(if bLoop
			(self loop: -1)
			(self play: 0 0)
		else
			(self loop: 1)
			(self play: 0 oEndCuee)
		)
		(self fade: (self getCurVol:) nTicks nSteps 0 oFadeCuee)
	)

	(method (fadeOut npTicks npSteps opCuee &tmp nTicks nSteps oCuee)
		(= nTicks (if (> argc 0) npTicks else 6))
		(= nSteps (if (> argc 1) npSteps else 10))
		(= oCuee (if (> argc 2) opCuee else 0))
		(if (or (not (self isPlaying:)) (== vol 0))
			(self stop:)
			(if oCuee
				(oCuee cue:)
			)
		)
		(self fade: 0 nTicks nSteps 1 oCuee)
	)

	(method (fadeRel nVolPercent npTicks npSteps opCuee &tmp nTicks nSteps oCuee)
		(= nTicks (if (> argc 1) npTicks else 6))
		(= nSteps (if (> argc 2) npSteps else 10))
		(= oCuee (if (> argc 3) opCuee else 0))
		(= relVolPercent nVolPercent)
		(self fade: (self getCurVol:) nTicks nSteps 0 oCuee)
	)

	(method (preload parms &tmp i)
		(for ((= i 0)) (< i argc) ((++ i))
			(cond
				((ResCheck rsAUDIO [parms i])
					(Load rsAUDIO [parms i])
				)
				((ResCheck 140 [parms i]) ; WAVE
					(Load 140 [parms i]) ; WAVE
				)
				(else
					(PrintDebug {Preloaded sound not found: %d} [parms i])
				)
			)
		)
	)

	(method (stop)
		(if oSubtitle
			(oSubtitle dispose:)
			(= oSubtitle 0)
		)
		(if (!= audTicks -1)
			(DoAudio audSTOP audModNum audNoun audVerb audCase audSequence)
			(= audTicks -1)
		else
			(super stop: &rest)
		)
	)

	(method (playSubtitledSound nSound args &tmp oCuee)
		(if (not (gSounds contains: self))
			(self init:)
		)
		(self stop:)
		(= audNoun [args (= audNoun (= audVerb (= audCase (= client 0))))])
		(if (> argc 2)
			(= audVerb [args 1])
		)
		(if (> argc 3)
			(= audCase [args 2])
		)
		(if (and (> argc 4) [args 3])
			(= audSequence [args 3])
		else
			(= audSequence 1)
		)
		(if (> argc 5)
			(= oCuee [args 4])
		else
			(= oCuee 0)
		)
		(if (> argc 6)
			(= audModNum [args 5])
		else
			(= audModNum gCurRoomNum)
		)
		(if (& gMsgType $0001)
			(= oSubtitle
				(MakeMessageSubTitle audModNum audNoun audVerb audCase audSequence)
			)
		)
		(self playSound: nSound oCuee)
	)

	(method (playMessage args &tmp temp0 [temp1 2])
		(if (not (gSounds contains: self))
			(self init:)
		)
		(self stop:)
		(= audNoun [args (= audNoun (= audVerb (= audCase (= client 0))))])
		(if (> argc 1)
			(= audVerb [args 1])
		)
		(if (> argc 2)
			(= audCase [args 2])
		)
		(if (and (> argc 3) [args 3])
			(= audSequence [args 3])
		else
			(= audSequence 1)
		)
		(if (> argc 4)
			(= client [args 4])
		)
		(if (> argc 5)
			(= audModNum [args 5])
		else
			(= audModNum gCurRoomNum)
		)
		(if (> argc 6)
			(= temp0 [args 6])
		else
			(= temp0 0)
		)
		(= saveTime gGameTime)
		(= audTicks
			(DoAudio
				audPLAY
				audModNum
				audNoun
				audVerb
				audCase
				audSequence
				1
				(MulDiv relVolPercent gAudioVol 100)
			)
		)
		(if (<= audTicks 0)
			(PrintDebug
				{No audio found m:%hu n:%d v:%d c:%d s:%d}
				audModNum
				audNoun
				audVerb
				audCase
				audSequence
			)
			(return)
		)
		(if (and (& gMsgType $0001) temp0)
			(= oSubtitle
				(MakeMessageSubTitle audModNum audNoun audVerb audCase audSequence)
			)
		)
	)

	(method (check)
		(if
			(and
				(!= audTicks -1)
				(> (- gGameTime saveTime) audTicks)
				(==
					(DoAudio audPOSITION audModNum audNoun audVerb audCase audSequence)
					-1
				)
			)
			(self stop:)
			(if client
				(client cue: self)
				(= client 0)
			)
		)
		(if handle
			(DoSound sndUPDATE_CUES self)
		)
		(if signal
			(= prevSignal signal)
			(= signal 0)
			(if oSubtitle
				(oSubtitle dispose:)
				(= oSubtitle 0)
			)
			(if client
				(client cue: self)
			)
		)
	)

	(method (newSound nSound)
		(= number nSound)
		(self preload: number)
	)

	(method (isPlaying &tmp bPlaying)
		(= bPlaying (and handle (!= prevSignal -1)))
	)

	(method (play)
		(= prevSignal 0)
		(super play: &rest)
	)

	(method (setMusic nSound)
		(if (or (not (self isPlaying:)) (!= number nSound))
			(if nSound
				(self newSound: nSound)
				(self loop: -1)
				(self play: (self getCurVol:) 0)
			else
				(= number 0)
				(self stop:)
			)
		)
	)

	(method (setAmbient nSound)
		(if (or (not (self isPlaying:)) (!= number nSound))
			(if nSound
				(self newSound: nSound)
				(self loop: -1)
				(self play: (self getCurVol:) 0)
			else
				(= number 0)
				(self stop:)
			)
		)
	)

	(method (playSound nSound oCueParm &tmp oCuee)
		(if argc
			(self newSound: nSound)
		)
		(if (> argc 1)
			(= oCuee oCueParm)
		else
			(= oCuee 0)
		)
		(self loop: 1)
		(self play: (self getCurVol:) oCuee)
	)

	(method (reSyncVol &tmp volTmp)
		(if (!= (= volTmp (self getCurVol:)) vol)
			(self setVol: volTmp)
		)
	)

	(method (setRelVol nPercent)
		(= relVolPercent nPercent)
		(self reSyncVol:)
	)

	(method (getCurVol)
		(if (== type 1)
			(Min 127 (MulDiv relVolPercent gMusicVol 100))
			(return)
		)
		(if (== type 0)
			(Min 127 (MulDiv relVolPercent gSFXVol 100))
			(return)
		)
		(if (== type 2)
			(Min 127 (MulDiv relVolPercent gAudioVol 100))
			(return)
		)
	)
)

