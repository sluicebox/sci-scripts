;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64031)
(include sci.sh)
(use Main)
(use oMessager)
(use Str)
(use Talker)
(use Sound)
(use System)

(public
	proc64031_0 0
	proc64031_1 1
	proc64031_2 2
)

(procedure (proc64031_0 param1 &tmp temp0 temp1)
	(= global227 param1)
	(for ((= temp1 (gSounds first:))) temp1 ((= temp1 (gSounds next: temp1)))
		(= temp0 (KList 8 temp1)) ; NodeValue
		(if (temp0 respondsTo: #reSyncVol)
			(temp0 reSyncVol:)
		)
	)
)

(procedure (proc64031_1 param1 &tmp temp0 temp1)
	(= global228 param1)
	(for ((= temp1 (gSounds first:))) temp1 ((= temp1 (gSounds next: temp1)))
		(= temp0 (KList 8 temp1)) ; NodeValue
		(if (temp0 respondsTo: #reSyncVol)
			(temp0 reSyncVol:)
		)
	)
)

(procedure (proc64031_2 param1 &tmp temp0 temp1)
	(= global229 param1)
	(for ((= temp1 (gSounds first:))) temp1 ((= temp1 (gSounds next: temp1)))
		(= temp0 (KList 8 temp1)) ; NodeValue
		(if (temp0 respondsTo: #reSyncVol)
			(temp0 reSyncVol:)
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

	(method (fadeIn param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp4 (if (> argc 1) param2 else 0))
		(= temp0 (if (> argc 2) param3 else 6))
		(if (> argc 3)
			(= temp1 param4)
		else
			(if (> temp0 90)
				(PrintDebug
					{Ticks value too large. Should be less than 90. SRC}
				)
				(= temp0 90)
			)
			(= temp1 (/ (self getCurVol:) (/ 90 temp0)))
		)
		(= temp2 (if (> argc 4) param5 else 0))
		(= temp3
			(cond
				((> argc 5) param6)
				((== type 1) 1)
				(else 0)
			)
		)
		(self stop:)
		(self newSound: param1)
		(if temp3
			(self loop: -1)
			(self play: 0 0)
		else
			(self loop: 1)
			(self play: 0 temp4)
		)
		(self fade: (self getCurVol:) temp0 temp1 0 temp2)
	)

	(method (fadeOut param1 param2 param3 &tmp temp0 temp1 temp2)
		(= temp0 (if (> argc 0) param1 else 0))
		(= temp1 (if (> argc 1) param2 else 6))
		(if (> argc 2)
			(= temp2 param3)
		else
			(if (> temp1 90)
				(PrintDebug
					{Ticks value too large. Should be less than 90. SRC}
				)
				(= temp1 90)
			)
			(= temp2 (/ vol (/ 90 temp1)))
		)
		(if (or (not (self isPlaying:)) (== vol 0))
			(self stop:)
			(if temp0
				(temp0 cue:)
			)
			(return)
		)
		(= temp2 (Max 1 temp2))
		(self fade: 0 temp1 temp2 1 temp0)
	)

	(method (fadeRel param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(= temp0 (if (> argc 1) param2 else 6))
		(= temp1 (if (> argc 2) param3 else 3))
		(= temp2 (if (> argc 3) param4 else 0))
		(= relVolPercent param1)
		(self fade: (self getCurVol:) temp0 temp1 0 temp2)
	)

	(method (preload param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(cond
				((ResCheck rsAUDIO [param1 temp0])
					(Load rsAUDIO [param1 temp0])
				)
				((ResCheck 140 [param1 temp0]) ; WAVE
					(Load 140 [param1 temp0]) ; WAVE
				)
				(else
					(PrintDebug {Preloaded sound not found: %d} [param1 temp0])
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

	(method (dispose)
		(self stop:)
		(super dispose: &rest)
	)

	(method (playSubtitledSound param1 param2 &tmp temp0 temp1 temp2 temp3)
		(if (not (gSounds contains: self))
			(self init:)
		)
		(self stop:)
		(= audNoun [param2 (= audNoun (= audVerb (= audCase (= client 0))))])
		(if (> argc 2)
			(= audVerb [param2 1])
		)
		(if (> argc 3)
			(= audCase [param2 2])
		)
		(if (and (> argc 4) [param2 3])
			(= audSequence [param2 3])
		else
			(= audSequence 1)
		)
		(if (> argc 5)
			(= temp0 [param2 4])
		else
			(= temp0 0)
		)
		(if (> argc 6)
			(= audModNum [param2 5])
		else
			(= audModNum gCurRoomNum)
		)
		(if (& gMsgType $0001)
			(= temp1 (Str newWith: 1000))
			(if
				(= temp3
					(Message
						msgGET
						audModNum
						audNoun
						audVerb
						audCase
						audSequence
						(temp1 data:)
					)
				)
				(= temp2 (Str format: {%s: %s} (TalkerName temp3) temp1))
			else
				(= temp2 (Str with: {Message not found}))
			)
			(= oSubtitle (proc64928_0 temp2))
			(temp2 dispose:)
			(temp1 dispose:)
		)
		(self playSound: param1 temp0)
	)

	(method (playMessage param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (not (gSounds contains: self))
			(self init:)
		)
		(self stop:)
		(= audNoun [param1 (= audNoun (= audVerb (= audCase (= client 0))))])
		(if (> argc 1)
			(= audVerb [param1 1])
		)
		(if (> argc 2)
			(= audCase [param1 2])
		)
		(if (and (> argc 3) [param1 3])
			(= audSequence [param1 3])
		else
			(= audSequence 1)
		)
		(if (> argc 4)
			(= client [param1 4])
		)
		(if (> argc 5)
			(= audModNum [param1 5])
		else
			(= audModNum gCurRoomNum)
		)
		(if (> argc 6)
			(= temp0 [param1 6])
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
				(MulDiv relVolPercent global229 100)
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
			(= audTicks -1)
			(return)
		)
		(= sample 1)
		(if (and (& gMsgType $0001) temp0)
			(= temp1 (Str newWith: 1000))
			(if
				(= temp4
					(Message
						msgGET
						audModNum
						audNoun
						audVerb
						audCase
						audSequence
						(temp1 data:)
					)
				)
				(= temp3 (Str format: {%s: %s} (TalkerName temp4) temp1))
			else
				(= temp3 (Str with: {Message not found}))
			)
			(= oSubtitle (proc64928_0 temp3))
			(temp3 dispose:)
			(temp1 dispose:)
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

	(method (newSound param1 param2)
		(= number param1)
		(if (and (!= type 1) (or (< argc 2) (and (> argc 1) param2)))
			(self preload: number)
		)
	)

	(method (isPlaying &tmp temp0)
		(= temp0 (and handle (!= prevSignal -1)))
	)

	(method (play)
		(= prevSignal 0)
		(super play: &rest)
	)

	(method (setMusic param1)
		(if (or (not (self isPlaying:)) (!= number param1))
			(if param1
				(self newSound: param1)
				(self loop: -1)
				(self play: (self getCurVol:) 0)
			else
				(self stop:)
				(= number 0)
			)
		)
	)

	(method (setAmbient param1)
		(if (or (not (self isPlaying:)) (!= number param1))
			(if param1
				(self newSound: param1)
				(self loop: -1)
				(self play: (self getCurVol:) 0)
			else
				(self stop:)
				(= number 0)
			)
		)
	)

	(method (playSound param1 param2 param3 &tmp temp0)
		(if argc
			(self newSound: param1 (and (> argc 2) param3))
		)
		(if (> argc 1)
			(= temp0 param2)
		else
			(= temp0 0)
		)
		(self loop: 1)
		(self play: (self getCurVol:) temp0)
	)

	(method (reSyncVol &tmp temp0)
		(if (!= (= temp0 (self getCurVol:)) vol)
			(self setVol: temp0)
		)
	)

	(method (setRelVol param1)
		(= relVolPercent param1)
		(self reSyncVol:)
	)

	(method (getCurVol)
		(if (== type 1)
			(Min 127 (MulDiv relVolPercent global227 100))
			(return)
		)
		(if (== type 0)
			(Min 127 (MulDiv relVolPercent global228 100))
			(return)
		)
		(if (== type 2)
			(Min 127 (MulDiv relVolPercent global229 100))
			(return)
		)
	)
)

