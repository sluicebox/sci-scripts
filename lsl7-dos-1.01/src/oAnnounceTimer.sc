;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use TPSound)
(use CueMe)
(use Timer)
(use System)

(public
	oAnnounceTimer 0
	proc80_1 1
)

(local
	local0
)

(procedure (proc80_1 param1)
	(if (or (not argc) param1)
		((ScriptID 64017 0) clear: 198) ; oFlags
	else
		((ScriptID 64017 0) set: 198) ; oFlags
	)
)

(instance oAnnounceTimer of Timer
	(properties)

	(method (cue &tmp temp0)
		(if
			(or
				((ScriptID 64017 0) test: 198) ; oFlags
				((ScriptID 64017 0) test: 158) ; oFlags
				((ScriptID 64040 2) oPlane:) ; L7TalkWindow
				(and gTalkers (not (gTalkers isEmpty:)))
				(not (gUser canControl:))
				(gCurRoom script:)
				(gEgo script:)
			)
			(if local0
				(= local0 0)
				(++ global210)
			)
			(self setReal: self 3)
			(return)
		)
		(cond
			((not ((ScriptID 64017 0) test: 33)) ; oFlags
				(if (< global211 7)
					(++ global211)
				)
				(oAnnounceSFX
					playSubtitledSound:
						(+ 6000 global211)
						0
						0
						1
						global211
						oMsgCue
						80
				)
			)
			(
				(and
					((ScriptID 64017 0) test: 127) ; oFlags
					(not ((ScriptID 64017 0) test: 192)) ; oFlags
				)
				((ScriptID 64017 0) set: 192) ; oFlags
				(oAnnounceSFX playSubtitledSound: 6009 0 0 3 0 oMsgCue 80)
			)
			(
				(and
					((ScriptID 64017 0) test: 45) ; oFlags
					(not ((ScriptID 64017 0) test: 193)) ; oFlags
				)
				((ScriptID 64017 0) set: 193) ; oFlags
				(oAnnounceSFX playSubtitledSound: 6011 0 0 5 0 oMsgCue 80)
			)
			(
				(and
					((ScriptID 64017 0) test: 89) ; oFlags
					(not ((ScriptID 64017 0) test: 194)) ; oFlags
				)
				((ScriptID 64017 0) set: 194) ; oFlags
				(oAnnounceSFX playSubtitledSound: 6012 0 0 6 0 oMsgCue 80)
			)
			(
				(and
					((ScriptID 64017 0) test: 103) ; oFlags
					(not ((ScriptID 64017 0) test: 195)) ; oFlags
				)
				((ScriptID 64017 0) set: 195) ; oFlags
				(oAnnounceSFX playSubtitledSound: 6013 0 0 7 0 oMsgCue 80)
			)
			(
				(and
					((ScriptID 64017 0) test: 113) ; oFlags
					(not ((ScriptID 64017 0) test: 196)) ; oFlags
				)
				((ScriptID 64017 0) set: 196) ; oFlags
				(oAnnounceSFX playSubtitledSound: 6008 0 0 2 0 oMsgCue 80)
			)
			(
				(and
					((ScriptID 64017 0) test: 115) ; oFlags
					(not ((ScriptID 64017 0) test: 197)) ; oFlags
				)
				((ScriptID 64017 0) set: 197) ; oFlags
				(oAnnounceSFX playSubtitledSound: 6010 0 0 4 0 oMsgCue 80)
			)
			(((ScriptID 64017 0) test: 29) ; oFlags
				(proc80_1 0)
				(self dispose: delete:)
			)
			(
				(and
					((ScriptID 64017 0) test: 127) ; oFlags
					((ScriptID 64017 0) test: 45) ; oFlags
					((ScriptID 64017 0) test: 89) ; oFlags
					((ScriptID 64017 0) test: 103) ; oFlags
					((ScriptID 64017 0) test: 113) ; oFlags
					((ScriptID 64017 0) test: 115) ; oFlags
				)
				(if (< global211 4)
					(++ global211)
				)
				(oAnnounceSFX
					playSubtitledSound:
						(+ 6013 global211)
						0
						0
						8
						global211
						oMsgCue
						80
				)
			)
			((< global210 132)
				(cond
					((OneOf (Random 1 10) 3 7)
						(oAnnounceSFX
							playSubtitledSound:
								(= temp0 (Random 6200 6225))
								0
								0
								(+ 10 (- temp0 6200))
								0
								oMsgCue
								80
						)
					)
					(local0
						(= local0 0)
						(gMessager say: 0 0 global210 2 oMsgCue 80)
						(++ global210)
					)
					((OneOf global210 119 122)
						(= local0 1)
						(oAnnounceSFX
							playSubtitledSound:
								(+ 6199 global210)
								0
								0
								global210
								1
								oMsgCue
								80
						)
					)
					(else
						(oAnnounceSFX
							playSubtitledSound:
								(+ 6199 global210)
								0
								0
								global210
								0
								oMsgCue
								80
						)
						(++ global210)
					)
				)
			)
			(else
				(++ global209)
				(oAnnounceSFX
					playSubtitledSound:
						(= temp0 (Random 6200 6225))
						0
						0
						(+ 10 (- temp0 6200))
						0
						oMsgCue
						80
				)
				(if (> global209 20)
					(= global209 0)
					(= global210 101)
				)
			)
		)
		(if (or (not local0) (not (OneOf global210 123 125)))
			(self setReal: self (Random 210 270))
		)
	)
)

(instance oAnnounceSFX of TPSound
	(properties)

	(method (init)
		(= owner gGame)
		(super init:)
	)

	(method (play)
		((ScriptID 64017 0) set: 276) ; oFlags
		(if ((ScriptID 64017 0) test: 27) ; oFlags
			(if ((ScriptID 64017 0) test: 291) ; oFlags
				((ScriptID 64017 0) clear: 291) ; oFlags
			else
				((ScriptID 64017 0) set: 291) ; oFlags
			)
		)
		(super play: &rest)
	)
)

(instance oMsgCue of CueMe
	(properties)

	(method (cue)
		((ScriptID 64017 0) clear: 276) ; oFlags
		(if local0
			(oAnnounceTimer cue:)
		)
	)
)

