;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 146)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	doSpell 0
)

(local
	local0
	local1
	local2
	local3
)

(instance doSpell of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 146)
	)

	(method (init)
		(= local0 (ScriptID 213 0)) ; warrior
		(= local1 ((ScriptID 213 0) egoHand:)) ; warrior
		(= local2 ((ScriptID 213 0) egosBack:)) ; warrior
		(= local3 ((ScriptID 213 0) egoShield:)) ; warrior
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global266 0)
				(local1 setCycle: End self)
			)
			(1
				(switch register
					(23
						(self setScript: (ScriptID 147 0) self) ; egoFlame
					)
					(21
						(self setScript: (ScriptID 148 0) self) ; egoZap
					)
					(20
						(self setScript: (ScriptID 149 0) self) ; egoDazzle
					)
					(22
						(self setScript: (ScriptID 150 0) self) ; egoCalm
					)
				)
			)
			(2
				(= register 0)
				(local1 setCycle: Beg self)
			)
			(3
				(local1 stopUpd:)
				(= global266 1)
				(self dispose:)
			)
		)
	)
)

